package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.RobotMap;
import org.firstinspires.ftc.teamcode.subsystems.*;

public abstract class BaseAutoOp extends LinearOpMode {

    protected DriveTrain driveTrain;
    protected Shoulder shoulder;
    protected Extension extension;
    protected Pickup pickup;
    protected RobotLift robotLift;
    protected WebcamSystem webcamSystem;
    private ElapsedTime timeout = new ElapsedTime();

    private void setupBot() {
        if (!RobotMap.DISABLE_DRIVE_TRAIN) {
            driveTrain = new DriveTrain(hardwareMap);
        }
        if (!RobotMap.DISABLE_SHOULDER) {
            shoulder = new Shoulder(hardwareMap);
        }
        if (!RobotMap.DISABLE_EXTENSION) {
            extension = new Extension(hardwareMap);
        }
        if (!RobotMap.DISABLE_PICKUP) {
            pickup = new Pickup(hardwareMap);
        }
        if (!RobotMap.DISABLE_LIFT) {
            robotLift = new RobotLift(hardwareMap);
        }
        if (RobotMap.AUTON_USE_WEBCAM){
            webcamSystem = new WebcamSystem(hardwareMap);
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        setupBot();

        showVersion();

        // Maybe replace with `waitForStart();`?
        // Seems to be working.... for now
        while (!(isStarted() || isStopRequested())) {
            idle();
            showVersion();
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }

        if (RobotMap.AUTON_USE_WEBCAM){
            webcamSystem.startTracking();
        }
        runAuton();
        if (RobotMap.AUTON_USE_WEBCAM){
            webcamSystem.stopTracking();
        }
    }


    public void showVersion(){
        telemetry.addData("VERSION", getVersion());
    }

    public String getVersion(){
        return "NO VERSION";
    }

    // This will be handled by the children opmodes

    abstract protected void runAuton();

    /**
     * Waits a couple of seconds before moving on
     *
     * @param seconds
     */
    protected void waitNSeconds(double seconds) {
        timeout.reset();

        double timeoutTime = seconds;

        while (opModeIsActive() &&
                (timeout.seconds() < timeoutTime)) {
        }
    }

    protected void driveTrainDriveXInches(double inches) {
        // Short circuit if we aren't using the drive train:
        if (RobotMap.DISABLE_DRIVE_TRAIN) {
            return;
        }

        driveTrain.setDistanceTargetInches(inches);
        timeout.reset();

        // TODO: Move magic numbers to RobotMap
        // Yes, I'm aware this will mean 2 time values for drive x feet.
        // One for driving based on time, and this one as an emergency in case an encoder fails
        double timeoutTime = Math.abs(inches) * 4.0 / 12.0; // Should take about 2 seconds per foot tops

        while (opModeIsActive() &&
                !driveTrain.isAtTargetDistance() &&
                (timeout.seconds() < timeoutTime)) {
            if (inches > 0) {
                driveTrain.forward(RobotMap.AUTON_DRIVE_X_INCHES_SPEED);
            } else {
                driveTrain.backward(RobotMap.AUTON_DRIVE_X_INCHES_SPEED);
            }
        }

        driveTrain.stop();
    }

    protected void driveTrainTurnNDegreesAbsolute(double degrees){
        // TODO: Code me
    }

    protected void driveTrainTurnNDegreesSpecial(double degrees){
        // Short circuit if we aren't using the drive train:
        if (RobotMap.DISABLE_DRIVE_TRAIN) {
            return;
        }

        driveTrain.setAngleTargetDegreesRelative(degrees);
        timeout.reset();

        // TODO: Move magic numbers to RobotMap
        double timeoutTime = Math.abs(degrees) * 4.0 / 90.0; // Should take about 2 seconds per 90 degrees tops

        while (opModeIsActive() &&
                !driveTrain.isAtTargetAngle() &&
                (timeout.seconds() < timeoutTime)) {
            if (degrees > 0) {
                driveTrain.turnRightSpecial(RobotMap.AUTON_TURN_N_DEGREES_SPEED);
            } else {
                driveTrain.turnLeftSpecial(RobotMap.AUTON_TURN_N_DEGREES_SPEED);
            }
        }

        driveTrain.stop();
    }

    /**
     * Turns N Degrees RELATIVE to the robot's current heading
     * POSITIVE IS CLOCKWISE
     * NEGATIVE IS COUNTERCLOCKWISE
     *
     * @param degrees
     */
    protected void driveTrainTurnNDegrees(double degrees) {
        // Short circuit if we aren't using the drive train:
        if (RobotMap.DISABLE_DRIVE_TRAIN) {
            return;
        }

        driveTrain.setAngleTargetDegreesRelative(degrees);
        timeout.reset();

        // TODO: Move magic numbers to RobotMap
        double timeoutTime = Math.abs(degrees) * 4.0 / 90.0; // Should take about 2 seconds per 90 degrees tops

        while (opModeIsActive() &&
                !driveTrain.isAtTargetAngle() &&
                (timeout.seconds() < timeoutTime)) {
            if (degrees > 0) {
                driveTrain.turnRight(RobotMap.AUTON_TURN_N_DEGREES_SPEED);
            } else {
                driveTrain.turnLeft(RobotMap.AUTON_TURN_N_DEGREES_SPEED);
            }
        }

        driveTrain.stop();

    }

    //Resets robot angle to zero
    protected void zeroRobotTurn(){
        double current = driveTrain.currentAngleDegrees();
        driveTrainTurnNDegrees(current);
    }

    protected void shoulderRaise() {
        // Short circuit if we aren't using the shoulder:
        if (RobotMap.DISABLE_SHOULDER) {
            return;
        }

        timeout.reset();

        double timeoutTime = 0.3;

        while (opModeIsActive() &&
                (timeout.seconds() < timeoutTime)) {
            shoulder.up();
        }

        shoulder.stop();
    }

    protected void pickupOut() {
        // Short circuit if we aren't using the shoulder:
        if (RobotMap.DISABLE_PICKUP) {
            return;
        }

        timeout.reset();

        double timeoutTime = 0.5;

        while (opModeIsActive() &&
                (timeout.seconds() < timeoutTime)) {
            pickup.out();
        }

        pickup.stop();
    }

    protected GoldPosition getGoldPosition(){
        if(RobotMap.AUTON_USE_WEBCAM){
            GoldPosition goldPosition = webcamSystem.getGoldPosition();
            printGoldPosition(goldPosition);
            return goldPosition;
        }
        else {
            return GoldPosition.GOLD_POSITION_UNKNOWN;
        }
    }

    private void printGoldPosition(GoldPosition goldPosition){
        if(goldPosition == GoldPosition.GOLD_POSITION_LEFT){
            telemetry.addData("Gold Mineral Position", "Left");
        }
        if(goldPosition == GoldPosition.GOLD_POSITION_CENTER){
            telemetry.addData("Gold Mineral Position", "Center");
        }
        if(goldPosition == GoldPosition.GOLD_POSITION_RIGHT){
            telemetry.addData("Gold Mineral Position", "Right");
        }
        if(goldPosition == GoldPosition.GOLD_POSITION_UNKNOWN){
            telemetry.addData("Gold Mineral Position", "Unknown");
        }
        telemetry.update();
    }

    protected void lowerRobot() {
        liftUp();
        driveTrainDriveXInches(4.5);
        zeroRobotTurn();
    }

    protected void liftDown() {
        //Short circuit if we aren't using the lift:
        if (RobotMap.DISABLE_LIFT) {
            return;
        }

        timeout.reset();

        double timeoutTime = RobotMap.AUTON_LIFT_DOWN_TIME;

        while (opModeIsActive() &&
                (timeout.seconds() < timeoutTime)) {
            robotLift.down();
        }

        robotLift.stop();
    }

    protected void raiseRobot() {
        liftDown();

    }

    protected void liftUp() {
        // Short circuit if we aren't using the lift:
        if (RobotMap.DISABLE_LIFT) {
            return;
        }

        timeout.reset();

        double timeoutTime = RobotMap.AUTON_LIFT_UP_TIME;

        while (opModeIsActive() &&
                (timeout.seconds() < timeoutTime)) {
            if(RobotMap.AUTON_USE_WEBCAM){
                webcamSystem.checkPosition();
                printGoldPosition(getGoldPosition());
            }
            robotLift.up();
        }
        //comment this out for competition...for testing only so
        //we do not have to reset the hook
        while (opModeIsActive() &&
                (timeout.seconds() < timeoutTime)) {
            robotLift.down();
        }

        robotLift.stop();
    }

    protected void extensionOut() {
        // Short circuit if we aren't using the extension:
        if (RobotMap.DISABLE_EXTENSION) {
            return;
        }

        timeout.reset();

        double timeoutTime = 2;

        while (opModeIsActive() &&
                (timeout.seconds() < timeoutTime)) {
            extension.forward();
        }

        extension.stop();
    }

    protected void extensionIn() {
        // Short circuit if we aren't using the extension:
        if (RobotMap.DISABLE_EXTENSION) {
            return;
        }

        timeout.reset();

        double timeoutTime = 2;

        while (opModeIsActive() &&
                (timeout.seconds() < timeoutTime)) {
            extension.backwards();
        }

        extension.stop();
    }
}
