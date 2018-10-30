package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.opmodes.auton.BaseAutoOp;

@Autonomous(name = "Rectangle Test", group = "TEST")
public class TestAuton extends BaseAutoOp {

    @Override
    protected void runAuton() {
        driveXInches(24);
        turnNDegrees(90);
        driveXInches(12);
        turnNDegrees(90);
        driveXInches(24);
        turnNDegrees(90);
        driveXInches(12);
        turnNDegrees(90);
    }
}
