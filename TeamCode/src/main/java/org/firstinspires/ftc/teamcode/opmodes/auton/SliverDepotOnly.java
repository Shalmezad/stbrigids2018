package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "SliverDepotOnly", group = "Auton")
public class SliverDepotOnly extends BaseAutoOp {
    @Override
    protected void runAuton() {
        driveTrainDriveXInches();
    }
}
