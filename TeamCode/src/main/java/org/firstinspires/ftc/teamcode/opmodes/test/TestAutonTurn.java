package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.opmodes.auton.BaseAutoOp;
import org.firstinspires.ftc.teamcode.util.Constants;

@Autonomous(name = "Test - Turn Test", group = "TEST")
@Disabled
public class TestAutonTurn extends BaseAutoOp {

    @Override
    protected void runAuton() {
        telemetry.addData("Status", "Turning 90 degrees");
        telemetry.update();
        driveTrainTurnNDegrees(90);
        telemetry.addData("Status", "Went 90 degrees");
        telemetry.addData("CurrentTicks", "%d", driveTrain.currentDistanceTicks());
        telemetry.update();
        waitNSeconds(10);
    }
}
