package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Contains all configuration options such as:
 * * Hardware names
 * * Encoder ticks per foot values
 * * Enable/Disable using switches/encoders/other-sensors/etc
 */
public class RobotMap {

    //region DISABLES
    // These will disable ENTIRE SECTIONS OF THE ROBOT
    // ONLY use if you need to test an individual part, or remove a malfunctioning part
    public static final boolean DISABLE_DRIVE_TRAIN = false;
    public static final boolean DISABLE_SHOULDER = false;
    public static final boolean DISABLE_EXTENSION = false;
    public static final boolean DISABLE_PICKUP = false;
    public static final boolean DISABLE_LIFT = false;

    //endregion

    //region HW NAMES

    public static final String HW_NAME_LEFT_DRIVE_TRAIN_MOTOR = "l_drive";
    public static final String HW_NAME_RIGHT_DRIVE_TRAIN_MOTOR = "r_drive";

    public static final String HW_NAME_LEFT_SHOULDER_MOTOR = "l_shoulder";
    public static final String HW_NAME_RIGHT_SHOULDER_MOTOR = "r_shoulder";

    public static final String HW_NAME_EXTENSION_MOTOR = "extension";

    public static final String HW_NAME_PICKUP_MOTOR = "pickup";

    public static final String HW_NAME_LIFT_MOTOR = "lift";

    //endregion

    //region MOTOR INVERSIONS
    // If a motor is going backwards, change it here:

    // Base on our robot, only ONE of these should be inverted
    public static final boolean INVERT_LEFT_DRIVE_TRAIN_MOTOR = false;
    public static final boolean INVERT_RIGHT_DRIVE_TRAIN_MOTOR = true;

    // Base on our robot, only ONE of these should be inverted
    public static final boolean INVERT_LEFT_SHOULDER_MOTOR = false;
    public static final boolean INVERT_RIGHT_SHOULDER_MOTOR = true;

    public static final boolean INVERT_EXTENSION_MOTOR = true;

    public static final boolean INVERT_PICKUP_MOTOR = false;

    public static final boolean INVERT_LIFT_MOTOR = false;
    //endregion

    //region MOTOR ZERO POWER MODES
    // This determines whether a motor coasts or brakes when it's set to 0
    // Brake means it immediately stops, and tries to hold the position (like slamming brakes on a car)
    // Float means it drifts slowly to a stop (like letting go of the gas on a car)

    public static final DcMotor.ZeroPowerBehavior ZERO_POWER_BEHAVIOR_DRIVE_TRAIN_MOTORS = DcMotor.ZeroPowerBehavior.BRAKE;

    public static final DcMotor.ZeroPowerBehavior ZERO_POWER_BEHAVIOR_SHOULDER_MOTORS = DcMotor.ZeroPowerBehavior.BRAKE;

    public static final DcMotor.ZeroPowerBehavior ZERO_POWER_BEHAVIOR_EXTENSION_MOTOR = DcMotor.ZeroPowerBehavior.BRAKE;

    public static final DcMotor.ZeroPowerBehavior ZERO_POWER_BEHAVIOR_PICKUP_MOTOR = DcMotor.ZeroPowerBehavior.FLOAT;

    public static final DcMotor.ZeroPowerBehavior ZERO_POWER_BEHAVIOR_LIFT_MOTOR = DcMotor.ZeroPowerBehavior.FLOAT;

    //endregion


    //region MOTOR MAX SPEEDS
    // This limits the maximum speeds we allow certain motors to go
    // This is to help prevent going too fast on sensitive parts

    public static final double MAX_SHOULDER_SPEED = 0.5;

    public static final double MAX_EXTENSION_SPEED = 0.5;

    public static final double MAX_PICKUP_SPEED = 0.5;

    public static final double MAX_LIFT_SPEED = 0.5;

    //endregion

    //region AUTON VALUES

    // How fast to drive when we're going a set distance. Range [0, 1]
    public static final double AUTON_DRIVE_X_INCHES_SPEED = 0.5;

    // Whether or not to use the encoder. If not, it'll use time
    public static final boolean AUTON_DRIVE_X_INCHES_USE_ENCODER = true;

    // How long it takes to drive 1 foot at AUTON_DRIVE_X_INCHES_SPEED power
    public static final double AUTON_DRIVE_X_INCHES_SECONDS_PER_FOOT = 2.0;

    // How many encoder ticks are in 1 foot of drive distance?
    public static final double AUTON_DRIVE_X_INCHES_TICKS_PER_FOOT = 1280;

    // Whether or not to use the IMU (the built in sensor on the rev module). If not, it'll use time
    public static final boolean AUTON_TURN_N_DEGREES_USE_IMU = true;

    //endregion
}
