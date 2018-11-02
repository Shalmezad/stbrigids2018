package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.opmodes.auton.BaseAutoOp;
import org.firstinspires.ftc.teamcode.util.Constants;

@Autonomous(name = "Test - Lower Robot Test", group = "TEST")
public class TestAutonLower extends BaseAutoOp {

    @Override
    protected void runAuton() {
        // The sole purpose of this test is to see if lowering the robot works
        lowerRobot();
    }
}
