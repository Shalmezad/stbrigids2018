package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.RobotMap;
import org.firstinspires.ftc.teamcode.subsystems.*;

public abstract class BaseTeleOp extends OpMode {

    protected DriveTrain driveTrain;
    protected Shoulder shoulder;
    protected Extension extension;
    protected Pickup pickup;
    protected RobotLift robotLift;

    @Override
    public void init() {
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
    public void loop() {
        // TODO: Don't handle joystick drive if we're shimmying
        if (!RobotMap.DISABLE_DRIVE_TRAIN) {
            handleJoystickDrive();
        }
        if (!RobotMap.DISABLE_SHOULDER) {
            handleShoulder();
        }
        if (!RobotMap.DISABLE_EXTENSION) {
            handleExtension();
        }
        if (!RobotMap.DISABLE_PICKUP) {
            handlePickup();
        }
        if (!RobotMap.DISABLE_LIFT) {
            handleLift();
        }
    }

    // This will be handled by the children opmodes
    // This way, we can have multiple different drives (tank, halo, arcade, etc)
    abstract void handleJoystickDrive();

    private void handleShoulder() {
        double shoulderSpeed = -gamepad2.left_stick_y;

        shoulderSpeed = Range.scale(shoulderSpeed,
                -1.0, 1.0,
                -RobotMap.MAX_SHOULDER_SPEED, RobotMap.MAX_SHOULDER_SPEED);

        shoulder.setRawSpeed(shoulderSpeed);
    }

    private void handleExtension() {
        double extensionSpeed = -gamepad2.right_stick_y;

        extensionSpeed = Range.scale(extensionSpeed,
                -1.0, 1.0,
                -RobotMap.MAX_EXTENSION_SPEED, RobotMap.MAX_EXTENSION_SPEED);

        extension.setRawSpeed(extensionSpeed);
    }


    private void handlePickup() {
        double pickupSpeed = 0;

        if (gamepad2.left_bumper) {
            pickupSpeed = -RobotMap.MAX_PICKUP_SPEED;
        } else if (gamepad2.right_bumper) {
            pickupSpeed = RobotMap.MAX_PICKUP_SPEED;
        }

        pickup.setRawSpeed(pickupSpeed);
    }

    private void handleLift() {
        double liftSpeed = 0;

        if (gamepad2.dpad_up) {
            liftSpeed = -RobotMap.MAX_LIFT_SPEED;
        } else if (gamepad2.dpad_down) {
            liftSpeed = RobotMap.MAX_LIFT_SPEED;
        }

        robotLift.setRawSpeed(liftSpeed);
    }
}
