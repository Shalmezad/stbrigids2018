package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name = "SilverCraterAndDepotHardCodedRight", group = "Auto")
@Disabled
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
