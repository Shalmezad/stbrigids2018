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
            driveTrainTurnNDegrees(-64);
            driveTrainDriveXInches(12.1);
            driveTrainTurnNDegrees(-6.4);
            driveTrainDriveXInches(28.8);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.1);
            pickupOut();
            driveTrainDriveXInches(-8.6);
            shoulder.stop();
            //driveTrainTurnNDegrees(-4);
            driveTrainDriveXInches(-57,1.0);

        }
        else if(goldPosition == GoldPosition.GOLD_POSITION_RIGHT){
            driveTrainDriveXInches(1.9);
            driveTrainTurnNDegrees(36);
            driveTrainDriveXInches(15);
            driveTrainDriveXInches(-15);
            driveTrainTurnNDegreesSpecial(-36);
            driveTrainTurnNDegrees(-64);
            driveTrainDriveXInches(22.0);
            driveTrainTurnNDegrees(-67.7);
            driveTrainDriveXInches(11.1);
            driveTrainTurnNDegrees(-5.4);
            driveTrainDriveXInches(29.8);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.1);
            pickupOut();
            driveTrainDriveXInches(-7.6);
            shoulder.stop();
            driveTrainTurnNDegrees(-3);
            driveTrainDriveXInches(-60.5,1.0);
        }
        else { //this is for gold center or unknown

           driveTrainDriveXInches(23.9);
           driveTrainDriveXInches(-22.3);
           driveTrainTurnNDegrees(-57.2);
           driveTrainDriveXInches(23.5);
           driveTrainTurnNDegrees(-65.7);
           driveTrainDriveXInches(12.1);
           driveTrainTurnNDegrees(-7.4);
           driveTrainDriveXInches(28.8);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.1);
            pickupOut();
            driveTrainDriveXInches(-8.6);
            shoulder.stop();
            driveTrainTurnNDegrees(-4);
            driveTrainDriveXInches(-57, 1.0);




        }
    }
}
