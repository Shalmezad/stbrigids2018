package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "SliverCraterOnly", group = "Auton")
public class SliverCraterOnly extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        waitNSeconds(1);
        driveTrainDriveXInches(31.5);
        raiseRobot();
    }
}
