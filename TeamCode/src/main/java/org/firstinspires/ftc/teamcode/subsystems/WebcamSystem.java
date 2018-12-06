package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.RobotMap;
import org.firstinspires.ftc.teamcode.opmodes.auton.GoldPosition;
import org.firstinspires.ftc.teamcode.util.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WebcamSystem {
    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";


    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    private GoldPosition goldPosition;

    private HashMap<GoldPosition, Integer> timesSeen;

    private boolean canUseWebcam;

    public WebcamSystem(HardwareMap hardwareMap){
        goldPosition = GoldPosition.GOLD_POSITION_UNKNOWN;
        initVuforia(hardwareMap);

        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod(hardwareMap);
            canUseWebcam = true;
        } else {
            canUseWebcam = false;
        }
        timesSeen = new HashMap<>();
    }

    public void startTracking(){
        if(canUseWebcam)
            tfod.activate();
    }

    public void stopTracking(){
        if(canUseWebcam)
            tfod.shutdown();
    }

    public void checkPosition(){
        if (tfod != null) {
            float maxConfidence = 0;
            Recognition bestRecognition = null;
            List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null && updatedRecognitions.size() > 0) {
                for (Recognition recognition : updatedRecognitions) {
                    if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                        float confidence = recognition.getConfidence();
                        if(maxConfidence == 0 || bestRecognition == null || confidence > maxConfidence){
                            maxConfidence = confidence;
                            bestRecognition = recognition;
                        }
                    }
                }
                if(bestRecognition != null) {
                    // We have our best recognition.
                    double recognitionCenter = bestRecognition.getLeft() + bestRecognition.getWidth() / 2;
                    double percWidth = recognitionCenter / bestRecognition.getImageWidth();
                    if (percWidth < 0.40) {
                        goldPosition = GoldPosition.GOLD_POSITION_LEFT;
                    } else if (percWidth > 0.6) {
                        goldPosition = GoldPosition.GOLD_POSITION_RIGHT;
                    } else {
                        goldPosition = GoldPosition.GOLD_POSITION_CENTER;
                    }
                    if(!timesSeen.containsKey(goldPosition)){
                        timesSeen.put(goldPosition, 0);
                    }
                    int prevTimeSeen = timesSeen.get(goldPosition);
                    timesSeen.put(goldPosition, prevTimeSeen + 1);
                }
            }
        }
    }

    public GoldPosition getGoldPosition(){
        if(RobotMap.AUTON_AVERAGE_WEBCAM_SIGHTINGS){
            // Add up all the times seen:
            Set<GoldPosition> keys = timesSeen.keySet();
            int totalSightings = 0;
            for(GoldPosition key : keys){
                totalSightings += timesSeen.get(key);
            }
            double maxSightPerc = 0.0;
            GoldPosition maxPosition = GoldPosition.GOLD_POSITION_UNKNOWN;
            for(GoldPosition key : keys){
                double perc = timesSeen.get(key) / ((double)totalSightings);
                if(perc > maxSightPerc){
                    maxSightPerc = perc;
                    maxPosition = key;
                }
            }
            return maxPosition;
        }
        return goldPosition;
    }

    /**
     * Initialize the Vuforia localization engine.
     */
    private void initVuforia(HardwareMap hardwareMap) {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = Constants.VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, RobotMap.HW_NAME_WEBCAM);

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the Tensor Flow Object Detection engine.
    }

    /**
     * Initialize the Tensor Flow Object Detection engine.
     */
    private void initTfod(HardwareMap hardwareMap) {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);
    }
}
