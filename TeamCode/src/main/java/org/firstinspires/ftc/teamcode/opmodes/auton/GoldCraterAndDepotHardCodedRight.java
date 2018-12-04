package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotMap;

@Autonomous(name = "GoldCraterAndDepotHardCodedRight", group = "Auto")
public class GoldCraterAndDepotHardCodedRight extends GoldCraterAndDepot {
    @Override
    protected void runAuton() {
        lowerRobot();


        GoldPosition goldPosition = getGoldPosition();

        positionSpecific(GoldPosition.GOLD_POSITION_RIGHT);


        raiseRobot();
    }

}
