package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name = "SilverCraterAndDepotHardCodedLeft", group = "Auto")
@Disabled
public class SilverCraterAndDepotHardCodedLeft extends SilverCraterAndDepot {
    @Override
    protected void runAuton() {
        lowerRobot();

        GoldPosition goldPosition = getGoldPosition();

        positionSpecific(GoldPosition.GOLD_POSITION_LEFT);


        //
        raiseRobot();
    }

}
