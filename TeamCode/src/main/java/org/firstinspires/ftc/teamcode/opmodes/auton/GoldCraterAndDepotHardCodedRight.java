package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

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
