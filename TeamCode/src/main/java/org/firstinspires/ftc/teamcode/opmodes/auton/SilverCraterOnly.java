package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name = "SilverCraterOnly", group = "Auton")
@Disabled
public class SilverCraterOnly extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        waitNSeconds(1);
        driveTrainDriveXInches(28.5);
        raiseRobot();
    }
}
