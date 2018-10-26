package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

public abstract class BaseTeleOp extends OpMode {

    protected DriveTrain driveTrain;

    @Override
    public void init() {
        driveTrain = new DriveTrain(hardwareMap);
    }

    @Override
    public void loop() {
        // TODO: Add shoulder
        // TODO: Add extension
        // TODO: Add pickup
        // TODO: Add robot lift
        // TODO: Don't handle joystick drive if we're shimmying
        handleJoystickDrive();
    }

    abstract void handleJoystickDrive();
}
