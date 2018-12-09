package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotMap;

@Autonomous(name = "SilverCraterAndDepot", group = "Auto")
public class SilverCraterAndDepot extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();

        GoldPosition goldPosition = getGoldPosition();

        positionSpecific(goldPosition);


        raiseRobot();
    }

    protected void positionSpecific(GoldPosition goldPosition) {
        if(goldPosition == GoldPosition.GOLD_POSITION_LEFT){
            driveTrainDriveXInches(1.9);
            driveTrainTurnNDegrees(-57.2);
            driveTrainDriveXInches(6.7);
            driveTrainTurnNDegrees(38.6);
            driveTrainTurnNDegreesSpecial(-38.6);
            driveTrainDriveXInches(16.8);
            driveTrainTurnNDegrees(-65.7);
            driveTrainDriveXInches(12.1);
            driveTrainTurnNDegrees(-5.4);
            driveTrainDriveXInches(28.8);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.1);
            pickupOut();
            driveTrainDriveXInches(-5.6);
            shoulder.stop();
            driveTrainTurnNDegrees(-3);
            driveTrainDriveXInches(-60,1.0);

        }
        else if(goldPosition == GoldPosition.GOLD_POSITION_RIGHT){
            driveTrainDriveXInches(1.9);
            driveTrainTurnNDegrees(36);
            driveTrainDriveXInches(14);
            driveTrainDriveXInches(-14);
            driveTrainTurnNDegreesSpecial(-36);
            driveTrainTurnNDegrees(-64);
            driveTrainDriveXInches(22.0);
            driveTrainTurnNDegrees(-65.7);
            driveTrainDriveXInches(12.1);
            driveTrainTurnNDegrees(-5.4);
            driveTrainDriveXInches(28.8);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.1);
            pickupOut();
            driveTrainDriveXInches(-5.6);
            shoulder.stop();
            driveTrainTurnNDegrees(-3);
            driveTrainDriveXInches(-60,1.0);
        }
        else { //this is for gold center or unknown

           driveTrainDriveXInches(20.4);
           driveTrainDriveXInches(-18.8);
           driveTrainTurnNDegrees(-57.2);
           driveTrainDriveXInches(23.5);
           driveTrainTurnNDegrees(-65.7);
           driveTrainDriveXInches(12.1);
           driveTrainTurnNDegrees(-5.4);
           driveTrainDriveXInches(28.8);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.1);
            pickupOut();
            driveTrainDriveXInches(-5.6);
            shoulder.stop();
            driveTrainTurnNDegrees(-4);
            driveTrainDriveXInches(-60, 1.0);




        }
    }
}
