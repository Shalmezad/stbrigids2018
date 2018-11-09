package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.RobotMap;

@Autonomous(name = "SliverCraterAndDepot", group = "Auton")
public class SliverCraterAndDepot extends BaseAutoOp {

    @Override
    public String getVersion(){
        return "10.0";
    }

    @Override
    protected void runAuton() {
        lowerRobot();
        driveTrainDriveXInches(26.5);
        driveTrainDriveXInches(-17);
        driveTrainTurnNDegrees(-90);
        driveTrainDriveXInches(28);
        driveTrainTurnNDegrees(-60);
        driveTrainDriveXInches(40);
        shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
        waitNSeconds(1.5);
        pickupOut();
        driveTrainDriveXInches(-12);
        shoulder.stop();
       // driveTrainTurnNDegrees(-45);
        //driveTrainDriveXInches(24);
        //driveTrainTurnNDegrees(-45);
        //driveTrainDriveXInches(55);
        driveTrainDriveXInches(-72);
        raiseRobot();
    }
}
