package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "GoldDepotOnly", group = "Auton")
public class GoldDepotOnly extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        driveTrainDriveXInches(40);
        pickupOut();
    }
}
