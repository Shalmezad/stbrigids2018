package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.opmodes.auton.BaseAutoOp;

@Autonomous(name = "Test - Rectangle Test", group = "TEST")
public class TestAuton extends BaseAutoOp {

    @Override
    protected void runAuton() {
        // Starts at S
        // Goes forward, turns, goes forward,
        // Spits out marker at E
        // Returns to S going backwards
        /*
                  E
                 /
                / 24"
         S-----/
            24"
         */


        // Go forward
        driveTrainDriveXInches(24);

        // Turn left
        driveTrainTurnNDegrees(-45);

        // Go forward
        driveTrainDriveXInches(24);

        // Raise the arm and spit the marker:
        shoulderRaise();
        pickupOut();

        // Go back
        driveTrainDriveXInches(-24);

        // Turn back
        driveTrainTurnNDegrees(45);

        // Go back
        driveTrainDriveXInches(-24);

    }
}
