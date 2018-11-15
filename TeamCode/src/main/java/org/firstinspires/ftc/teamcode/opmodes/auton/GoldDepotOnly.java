package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.RobotMap;

@Autonomous(name = "GoldDepotOnly", group = "Auton")
public class GoldDepotOnly extends BaseAutoOp {
    @Override
    protected void runAuton() {
        lowerRobot();
        driveTrainDriveXInches(56);
        shoulder.setTargetTicks(RobotMap.SHOULDER_POSITION_MID);
        waitNSeconds(1.5);
        pickupOut();
        driveTrainDriveXInches(-30);
        shoulder.stop();
        raiseRobot();
    }
}
