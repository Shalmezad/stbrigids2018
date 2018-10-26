package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.RobotMap;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.Shoulder;

public abstract class BaseTeleOp extends OpMode {

    protected DriveTrain driveTrain;
    protected Shoulder shoulder;

    @Override
    public void init() {
        if (!RobotMap.DISABLE_DRIVE_TRAIN) {
            driveTrain = new DriveTrain(hardwareMap);
        }
        if (!RobotMap.DISABLE_SHOULDER) {
            shoulder = new Shoulder(hardwareMap);
        }
    }

    @Override
    public void loop() {
        // TODO: Add shoulder
        // TODO: Add extension
        // TODO: Add pickup
        // TODO: Add robot lift
        // TODO: Don't handle joystick drive if we're shimmying
        if (!RobotMap.DISABLE_DRIVE_TRAIN) {
            handleJoystickDrive();
        }
        if (!RobotMap.DISABLE_SHOULDER) {
            handleShoulder();
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
}
