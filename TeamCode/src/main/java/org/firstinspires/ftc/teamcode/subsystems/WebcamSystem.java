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

import java.util.List;

public class WebcamSystem {
    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";


    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    private GoldPosition goldPosition;

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
    }

    public void startTracking(){
        if(canUseWebcam)
            tfod.activate();
    }

    public void stopTracking(){
        if(canUseWebcam)
            tfod.shutdown();
    }

    public GoldPosition getGoldPosition(){
        if (tfod != null) {
            float maxConfidence = 0;
            Recognition bestRecognition = null;
            List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null) {
                for (Recognition recognition : updatedRecognitions) {
                    if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                        float confidence = recognition.getConfidence();
                        if(maxConfidence == 0 || confidence > maxConfidence){
                            maxConfidence = confidence;
                            bestRecognition = recognition;
                        }
                    }
                }
                // We have our best recognition.
                double recognitionCenter = bestRecognition.getLeft() + bestRecognition.getWidth()/2;
                double percWidth = recognitionCenter / bestRecognition.getImageWidth();
                if(percWidth < 0.40){
                    goldPosition = GoldPosition.GOLD_POSITION_LEFT;
                }
                else if(percWidth > 0.6){
                    goldPosition = GoldPosition.GOLD_POSITION_RIGHT;
                }
                else{
                    goldPosition = GoldPosition.GOLD_POSITION_CENTER;
                }
            }
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
