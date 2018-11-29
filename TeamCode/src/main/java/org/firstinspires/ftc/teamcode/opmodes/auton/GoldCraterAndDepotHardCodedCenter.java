package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "GoldCraterAndDepotHardCodedCenter", group = "Auto")
public class GoldCraterAndDepotHardCodedCenter extends GoldCraterAndDepot {
    @Override
    protected void runAuton() {
        lowerRobot();

        GoldPosition goldPosition = getGoldPosition();

        positionSpecific(GoldPosition.GOLD_POSITION_CENTER);


        //
        raiseRobot();
    }

}
