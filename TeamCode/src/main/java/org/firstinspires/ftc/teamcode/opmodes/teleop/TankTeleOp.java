package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp - Tank", group = "TeleOps")
public class TankTeleOp extends BaseTeleOp {

    @Override
    void handleJoystickDrive() {
        double leftPower;
        double rightPower;

        leftPower = -gamepad1.left_stick_y;
        rightPower = -gamepad1.right_stick_y;

        driveTrain.setRawSpeed(leftPower, rightPower);
    }
}
