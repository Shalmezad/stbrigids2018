package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name = "SilverDepotOnly", group = "Auton")
@Disabled
public class SilverDepotOnly extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        driveTrainDriveXInches(7);
        driveTrainTurnNDegrees(-90);
        driveTrainDriveXInches(34);
        driveTrainTurnNDegrees(-45);
        driveTrainDriveXInches(57);
        pickupOut();
    }
}
