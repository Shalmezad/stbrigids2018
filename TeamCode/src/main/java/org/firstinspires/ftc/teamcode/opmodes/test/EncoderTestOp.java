package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.Extension;
import org.firstinspires.ftc.teamcode.subsystems.Shoulder;

@TeleOp(name = "Test - Encoders", group = "TEST")
@Disabled
public class EncoderTestOp extends OpMode {
    private Shoulder shoulder;
    private Extension extension;
    private DriveTrain driveTrain;

    @Override
    public void init() {
        shoulder = new Shoulder(hardwareMap);
        shoulder.resetTicks();
        extension = new Extension(hardwareMap);
        driveTrain = new DriveTrain(hardwareMap);
        driveTrain.setAngleTargetDegreesRelative(0);
    }

    @Override
    public void loop() {

        telemetry.addData("LeftShoulderTicks", "%d", shoulder.getLeftShoulderPosition());
        telemetry.addData("RightShoulderTicks", "%d", shoulder.getRightShoulderPosition());

        telemetry.addData("LeftDriveTicks", "%d", driveTrain.currentLeftDistanceTicks());
        telemetry.addData("RightDriveTicks", "%d", driveTrain.currentRightDistanceTicks());
    }
}
