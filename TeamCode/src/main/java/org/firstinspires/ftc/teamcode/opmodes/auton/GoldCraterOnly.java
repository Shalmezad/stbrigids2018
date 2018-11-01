package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "GoldCraterOnly", group = "Auton")
public class GoldCraterOnly extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        driveTrainDriveXInches(15);
        driveTrainTurnNDegrees(90);
        driveTrainDriveXInches(43);
        driveTrainTurnNDegrees(45);
        driveTrainDriveXInches(16);
        extensionOut();
    }
}
