package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOp - Halo", group = "TeleOps")
public class HaloTeleOp extends BaseTeleOp {

    @Override
    void handleJoystickDrive() {
        double leftPower;
        double rightPower;

        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        leftPower = Range.clip(drive + turn, -1.0, 1.0);
        rightPower = Range.clip(drive - turn, -1.0, 1.0);

        driveTrain.setRawSpeed(leftPower, rightPower);
    }
}
