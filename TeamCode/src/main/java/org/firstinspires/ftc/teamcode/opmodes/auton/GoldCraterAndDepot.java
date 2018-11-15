package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotMap;

@Autonomous(name = "GoldCraterAndDepot", group = "Auto")
public class GoldCraterAndDepot extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();

        GoldPosition goldPosition = getGoldPosition();

        if(goldPosition == GoldPosition.GOLD_POSITION_LEFT){
            driveTrainDriveXInches(11.2);
            driveTrainTurnNDegrees(-50);
            driveTrainDriveXInches(29.5);
            driveTrainTurnNDegrees(56);
            driveTrainDriveXInches(13.5);
            driveTrainTurnNDegrees(28);
            driveTrainDriveXInches(16.4);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.5);
            pickupOut();
            driveTrainDriveXInches(-11.7);
            shoulder.stop();
            driveTrainTurnNDegrees(15);
            driveTrainDriveXInches(-37.3);
        }
        else if(goldPosition == GoldPosition.GOLD_POSITION_RIGHT){

        }
        else {  // Either center or unknown

        }


        pickupOut();
        driveTrainTurnNDegrees(-135);
        driveTrainDriveXInches(75);
        extensionOut();
    }
}
