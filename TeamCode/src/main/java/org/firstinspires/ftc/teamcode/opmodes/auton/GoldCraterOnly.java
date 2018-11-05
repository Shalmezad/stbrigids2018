package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "GoldCraterOnly", group = "Auton")
public class GoldCraterOnly extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        driveTrainDriveXInches(46);
        driveTrainTurnNDegrees(135);
        driveTrainDriveXInches(72);
        raiseRobot();
        //extensionOut();
    }
}
