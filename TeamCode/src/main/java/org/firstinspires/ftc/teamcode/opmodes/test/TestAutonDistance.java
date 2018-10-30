package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.opmodes.auton.BaseAutoOp;
import org.firstinspires.ftc.teamcode.util.Constants;

@Autonomous(name = "Distance Test", group = "TEST")
public class TestAutonDistance extends BaseAutoOp {

    @Override
    protected void runAuton() {
        telemetry.addData("Status", "Going 5 feet");
        telemetry.update();
        double distanceInches = 5 * Constants.INCHES_PER_FOOT;
        driveXInches(distanceInches);
        telemetry.addData("Status", "Went 5 feet");
        telemetry.addData("CurrentTicks", "%d", driveTrain.currentDistanceTicks());
    }
}
