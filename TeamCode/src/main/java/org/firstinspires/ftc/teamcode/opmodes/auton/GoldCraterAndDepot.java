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

            driveTrainTurnNDegrees(-32);
            driveTrainDriveXInches(26.6);
            driveTrainTurnNDegrees(66);
            driveTrainDriveXInches(17);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.1);
            pickupOut();
            driveTrainDriveXInches(-11.5);
            shoulder.stop();
            driveTrainTurnNDegrees(12);
            driveTrainDriveXInches(-63.5,1.0);
        }
        else if(goldPosition == GoldPosition.GOLD_POSITION_RIGHT){
            driveTrainTurnNDegrees(27);
            driveTrainDriveXInches(31);
            driveTrainTurnNDegrees(-67.8);
            driveTrainDriveXInches(19);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.1);
            pickupOut();
            driveTrainDriveXInches(-11.1);
            shoulder.stop();
            driveTrainTurnNDegrees(-70.0);
            driveTrainDriveXInches(9.3);
            driveTrainTurnNDegrees(-9.7);
            driveTrainDriveXInches(7.8);
            driveTrainTurnNDegrees(-11);
            driveTrainDriveXInches(38.7,1.0);

        }
        else { //this is for gold center or unknown


            driveTrainDriveXInches(43.75);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.1);
            pickupOut();
            driveTrainDriveXInches(-43.75);
            shoulder.stop();
            driveTrainTurnNDegrees(-51.1);
            driveTrainDriveXInches(21);
            driveTrainTurnNDegrees(-60);
            driveTrainDriveXInches(22);


        }
    }
}
