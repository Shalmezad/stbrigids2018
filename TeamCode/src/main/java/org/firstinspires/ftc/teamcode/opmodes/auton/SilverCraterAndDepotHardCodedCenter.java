package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "SilverCraterAndDepotHardCodedCenter", group = "Auto")
public class SilverCraterAndDepotHardCodedCenter extends SilverCraterAndDepot {
    @Override
    protected void runAuton() {
        lowerRobot();

        GoldPosition goldPosition = getGoldPosition();

        positionSpecific(GoldPosition.GOLD_POSITION_CENTER);


        //
        raiseRobot();
    }

}
