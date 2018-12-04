package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotMap;

@Autonomous(name = "GoldCraterAndDepot", group = "Auto")
public class GoldCraterAndDepot extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();

        GoldPosition goldPosition = getGoldPosition();

        positionSpecific(goldPosition);


        raiseRobot();
    }

    protected void positionSpecific(GoldPosition goldPosition) {
        if(goldPosition == GoldPosition.GOLD_POSITION_LEFT){

            driveTrainTurnNDegrees(-36.4);
            driveTrainDriveXInches(26.6);
            driveTrainTurnNDegrees(69.2);
            driveTrainDriveXInches(22.5);
            driveTrainDriveXInches(20);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.5);
            pickupOut();
            driveTrainDriveXInches(-11.5);
            shoulder.stop();
            driveTrainTurnNDegrees(18.8);
            driveTrainDriveXInches(-60.9);
        }
        else if(goldPosition == GoldPosition.GOLD_POSITION_RIGHT){
            driveTrainTurnNDegrees(29.9);
            driveTrainDriveXInches(32.4);
            driveTrainTurnNDegrees(-67.8);
            driveTrainDriveXInches(20);
            driveTrainDriveXInches(20);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.5);
            pickupOut();
            driveTrainDriveXInches(-8.1);
            shoulder.stop();
            driveTrainTurnNDegrees(-72.3);
            driveTrainDriveXInches(8.8);
            driveTrainTurnNDegrees(-9.7);
            driveTrainDriveXInches(8.8);
            driveTrainTurnNDegrees(-11.7);
            driveTrainDriveXInches(38.7);

        }
        else { //this is for gold center or unknown


            driveTrainDriveXInches(43.75);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.5);
            pickupOut();
            driveTrainDriveXInches(-42.25);
            shoulder.stop();
            driveTrainTurnNDegrees(-51.1);
            driveTrainDriveXInches(21);
            driveTrainTurnNDegrees(-60);
            driveTrainDriveXInches(23);


        }
    }
}
