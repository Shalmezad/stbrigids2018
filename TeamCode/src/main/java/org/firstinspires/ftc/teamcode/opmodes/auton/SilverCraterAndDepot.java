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
            driveTrainDriveXInches(13.7);
            driveTrainTurnNDegrees(38.6);
            driveTrainTurnNDegreesSpecial(-38.6);
            driveTrainDriveXInches(13.3);
            driveTrainTurnNDegrees(-65.7);
            driveTrainDriveXInches(12.1);
            driveTrainTurnNDegrees(-8.4);
            driveTrainDriveXInches(28.8);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.5);
            pickupOut();
            driveTrainDriveXInches(-5.6);
            shoulder.stop();
            driveTrainTurnNDegrees(-4.8);
            driveTrainDriveXInches(-57.7);

        }
        else if(goldPosition == GoldPosition.GOLD_POSITION_RIGHT){
            driveTrainDriveXInches(1.9);
            driveTrainTurnNDegrees(38);
            driveTrainDriveXInches(13);
            driveTrainDriveXInches(-13);
            driveTrainTurnNDegreesSpecial(-38);
            driveTrainTurnNDegrees(-57.2);
            driveTrainDriveXInches(27);
            driveTrainTurnNDegrees(-65.7);
            driveTrainDriveXInches(12.1);
            driveTrainTurnNDegrees(-8.4);
            driveTrainDriveXInches(28.8);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.5);
            pickupOut();
            driveTrainDriveXInches(-5.6);
            shoulder.stop();
            driveTrainTurnNDegrees(-4.8);
            driveTrainDriveXInches(-57.7);
        }
        else { //this is for gold center or unknown

           driveTrainDriveXInches(20.4);
           driveTrainDriveXInches(-18.8);
           driveTrainTurnNDegrees(-57.2);
           driveTrainDriveXInches(27);
           driveTrainTurnNDegrees(-65.7);
           driveTrainDriveXInches(12.1);
           driveTrainTurnNDegrees(-8.4);
           driveTrainDriveXInches(28.8);
            shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
            waitNSeconds(1.5);
            pickupOut();
            driveTrainDriveXInches(-5.6);
            shoulder.stop();
            driveTrainTurnNDegrees(-4.8);
            driveTrainDriveXInches(-57.7);




        }
    }
}
