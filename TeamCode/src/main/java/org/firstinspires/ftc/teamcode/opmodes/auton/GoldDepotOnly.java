package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.RobotMap;

@Autonomous(name = "GoldDepotOnly", group = "Auton")
public class GoldDepotOnly extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        driveTrainDriveXInches(40);
        shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_LOW);
        waitNSeconds(.75);
        pickupOut();
        driveTrainDriveXInches(-12);
        shoulder.stop();

    }
}
