package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "SilverCraterAndDepotHardCodedRight", group = "Auto")
public class SilverCraterAndDepotHardCodedRight extends SilverCraterAndDepot {
    @Override
    protected void runAuton() {
        lowerRobot();

        GoldPosition goldPosition = getGoldPosition();

        positionSpecific(GoldPosition.GOLD_POSITION_RIGHT);


        //
        raiseRobot();
    }

}
