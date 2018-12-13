package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name = "GoldCraterAndDepotHardCodedCenter", group = "Auto")
@Disabled
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
