package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "GoldCraterAndDepot", group = "Auto")
public class GoldCraterAndDepot extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        driveTrainDriveXInches(40);

        pickupOut();
        driveTrainTurnNDegrees(-135);
        driveTrainDriveXInches(75);
        extensionOut();
    }
}
