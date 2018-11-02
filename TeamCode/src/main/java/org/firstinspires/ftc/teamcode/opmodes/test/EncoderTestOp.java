package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Extension;
import org.firstinspires.ftc.teamcode.subsystems.Shoulder;

@TeleOp(name = "Test - Encoders", group = "TEST")
public class EncoderTestOp extends OpMode {
    private Shoulder shoulder;
    private Extension extension;

    @Override
    public void init() {
        shoulder = new Shoulder(hardwareMap);
        shoulder.resetTicks();
        extension = new Extension(hardwareMap);
    }

    @Override
    public void loop() {

        telemetry.addData("LeftShoulderTicks", "%d", shoulder.getLeftShoulderPosition());
        telemetry.addData("RightShoulderTicks", "%d", shoulder.getRightShoulderPosition());
    }
}
