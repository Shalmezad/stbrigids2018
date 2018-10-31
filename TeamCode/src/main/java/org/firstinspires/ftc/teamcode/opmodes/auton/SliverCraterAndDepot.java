package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "SliverCraterAndDepot", group = "Auton")
public class SliverCraterAndDepot extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        driveTrainDriveXInches(19.5);
        driveTrainDriveXInches(-5.5);
        driveTrainTurnNDegrees(-90);
        driveTrainDriveXInches(36);
        driveTrainTurnNDegrees(-45);
        driveTrainDriveXInches(56);
        driveTrainTurnNDegrees(-90);
        driveTrainDriveXInches(80);
        //add extend arm
    }
}
