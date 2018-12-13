package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.RobotMap;
import org.firstinspires.ftc.teamcode.opmodes.auton.BaseAutoOp;
import org.firstinspires.ftc.teamcode.util.Constants;

@Autonomous(name = "Test - Shoulder Test", group = "TEST")
@Disabled
public class TestShoulder extends BaseAutoOp {

    @Override
    protected void runAuton() {
        shoulder.resetTicks();
        shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_DOWN);
        waitNSeconds(2);
        shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_LOW);
        waitNSeconds(2);
        shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_HIGH);
        waitNSeconds(2);
        shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_LOW);
        waitNSeconds(2);
        shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_DOWN);
        waitNSeconds(2);
        shoulder.stop();
    }
}
