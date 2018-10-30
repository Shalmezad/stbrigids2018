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
    }

    @Override
    public void runOpMode() throws InterruptedException {
        setupBot();
        runAuton();
    }

    // This will be handled by the children opmodes

    abstract protected void runAuton();

    protected void driveXInches(double inches) {
        // Short circuit if we aren't using the drive train:
        if (RobotMap.DISABLE_DRIVE_TRAIN) {
            return;
        }

        driveTrain.setDistanceTargetInches(inches);
        timeout.reset();

        // TODO: Move magic numbers to RobotMap
        // Yes, I'm aware this will mean 2 time values for drive x feet.
        // One for driving based on time, and this one as an emergency in case an encoder fails
        double timeoutTime = Math.abs(inches) * 2.0 / 12.0; // Should take about 2 seconds per foot tops

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

    /**
     * POSITIVE IS CLOCKWISE
     * NEGATIVE IS COUNTERCLOCKWISE
     *
     * @param degrees
     */
    protected void turnNDegrees(double degrees) {
        // TODO: Code me

        // Short circuit if we aren't using the drive train:
        if (RobotMap.DISABLE_DRIVE_TRAIN) {
            return;
        }

    }

}
