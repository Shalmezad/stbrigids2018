package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.RobotMap;

@Autonomous(name = "GoldCraterAndDepotHardCodedLeft", group = "Auto")
@Disabled
public class GoldCraterAndDepotHardCodedLeft extends GoldCraterAndDepot {
    @Override
    protected void runAuton() {
        lowerRobot();

        GoldPosition goldPosition = getGoldPosition();

        positionSpecific(GoldPosition.GOLD_POSITION_LEFT);


        raiseRobot();
    }

}
