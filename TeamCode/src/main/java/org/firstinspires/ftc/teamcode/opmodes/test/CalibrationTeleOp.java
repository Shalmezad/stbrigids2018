package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.RobotMap;
import org.firstinspires.ftc.teamcode.subsystems.*;

// TODO: Add instructions
/**
 * This is for testing the MOTOR configurations in RobotMap
 * FOLLOW THE INSTRUCTIONS BELOW:
 *
 * PRECONFIGURE:
 * - Make sure robot is disabled
 * - Set up both controllers (Start + A, Start + B)
 * - Make sure someone is on the driver phone, and knows to stop the robot should something go wrong
 * - Start robot
 *
 * DRIVE TRAIN CONFIGURE
 * - Press the LEFT BUMPER on JOYSTICK 1
 * - The LEFT drive train motor should go FORWARD
 *   - If the right motor goes, you set the wrong names on the phone, or in RobotMap
 *   - If it goes BACKWARD, set RobotMap.INVERT_LEFT_DRIVE_TRAIN_MOTOR to the opposite of what it was
 * - Press the RIGHT BUMPER on JOYSTICK 1
 * - The RIGHT drive train motor should go FORWARD
 *   - If the left motor goes, you set the wrong names on the phone, or in RobotMap
 *   - If it goes BACKWARD, set RobotMap.INVERT_RIGHT_DRIVE_TRAIN_MOTOR to the opposite of what it was
 *
 * SHOULDER CONFIGURE
 * - Have a mentor set and hold the shoulder at about halfway up
 * - Press Y (the top yellow button) on JOYSTICK 1
 * - The shoulder should go UP
 *   - If the motor goes down:
 *     - Set INVERT_LEFT_SHOULDER_MOTOR to the opposite of what it was
 *     - Set INVERT_RIGHT_SHOULDER_MOTOR to the opposite of what it was
 *     - THEY SHOULD BE OPPOSITES OF EACH OTHER
 *
 * EXTENSION CONFIGURE
 * - Have a mentor set and hold the extension at about halfway out
 * - Press RIGHT BUMPER on JOYSTICK 2
 * - The extension should go out
 *   - If the extension goes in, set RobotMap.INVERT_EXTENSION_MOTOR to the opposite of what it was
 *
 * PICKUP CONFIGURE
 * - Have a mentor set and hold the shoulder partly up
 * - Press Y (top yellow button) on JOYSTICK 2
 * - The pickup should go in (moves pieces upward)
 *   - If the pickup goes out, set RobotMap.INVERT_PICKUP_MOTOR to the opposite of what it was
 *
 * ROBOT LIFT CONFIGURE
 * - Have a mentor set up the lift part way out
 * - Press D-PAD UP (the plus thing on the left hand side) on JOYSTICK 2
 * - The lift should go up
 *   - If the lift goes down, set RobotMap.INVERT_LIFT_MOTOR to the opposite of what it was
 *
 * POSTCONFIGURE
 * - Switch to one of the drive modes (tank, halo)
 * - Try driving the robot
 * - IF SOMETHING IS BACKWARDS, DO NOT CHANGE ANY MOTOR INVERTS
 *   - The configuration above is to ensure the robot is standardized for autonomous
 *   - If it's still backwards, it's the CONTROLS that need inverted, not the motors
 *   - This should be done in BaseTeleOp
 */
@TeleOp(name = "Calibration Mode", group = "TEST")
public class CalibrationTeleOp extends OpMode {

    protected DriveTrain driveTrain;
    protected Shoulder shoulder;
    protected Extension extension;
    protected Pickup pickup;
    protected RobotLift robotLift;

    @Override
    public void init() {
        if (!RobotMap.DISABLE_DRIVE_TRAIN) {
            driveTrain = new DriveTrain(hardwareMap);
        }
        if (!RobotMap.DISABLE_SHOULDER) {
            shoulder = new Shoulder(hardwareMap);
        }
        if (!RobotMap.DISABLE_EXTENSION) {
            extension = new Extension(hardwareMap);
        }
        if (!RobotMap.DISABLE_PICKUP) {
            pickup = new Pickup(hardwareMap);
        }
        if (!RobotMap.DISABLE_LIFT) {
            robotLift = new RobotLift(hardwareMap);
        }
    }

    @Override
    public void loop() {
        if(gamepad1.left_bumper){
            driveTrain.setRawSpeed(0.5, 0);
        }
        else if(gamepad1.right_bumper){
            driveTrain.setRawSpeed(0, 0.5);
        }
        else {
            driveTrain.setRawSpeed(0, 0);
        }

        if(gamepad1.y){
            shoulder.up();
        }
        else {
            shoulder.stop();
        }

        if(gamepad2.right_bumper){
            extension.forward();
        }
        else {
            extension.stop();
        }

        if(gamepad2.y){
            pickup.in();
        }
        else {
            pickup.stop();
        }


        if(gamepad2.dpad_up){
            robotLift.up();
        }
        else {
            robotLift.stop();
        }
    }
}
