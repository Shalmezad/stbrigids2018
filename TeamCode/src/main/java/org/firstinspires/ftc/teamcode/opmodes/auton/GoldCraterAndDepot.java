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
            driveTrainTurnNDegrees(10.3);
            driveTrainTurnNDegrees(25);
            driveTrainTurnNDegrees(28.3);
            driveTrainTurnNDegrees(-59);
            driveTrainTurnNDegrees(36.2);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.5);
            pickupOut();
            driveTrainDriveXInches(-8.5);
            shoulder.stop();
            driveTrainTurnNDegrees(-53);
            driveTrainDriveXInches(7.9);
            driveTrainTurnNDegrees(-35);
            driveTrainDriveXInches(11.5);
            driveTrainTurnNDegrees(-18);
            driveTrainDriveXInches(43.8);
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
