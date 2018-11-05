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
    public static final boolean INVERT_LEFT_DRIVE_TRAIN_MOTOR = true;
    public static final boolean INVERT_RIGHT_DRIVE_TRAIN_MOTOR = false;

    // Base on our robot, only ONE of these should be inverted
    public static final boolean INVERT_LEFT_SHOULDER_MOTOR = false;
    public static final boolean INVERT_RIGHT_SHOULDER_MOTOR = true;

    public static final boolean INVERT_EXTENSION_MOTOR = false;

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

    public static final double MAX_SHOULDER_SPEED = 0.75;

    public static final double MAX_EXTENSION_SPEED = 1.0;

    public static final double MAX_PICKUP_SPEED = 0.8;

    public static final double MAX_LIFT_SPEED = 0.8;

    //endregion

    //region SHOULDER POSITIONS

    // Whether or not to use the encoder.
    // If not, it'll just be plain ol' voltage mode
    public static final boolean SHOULDER_USE_ENCODER = false;

    // Note: MIN must be less than 0 so that it can be driven down if encoder is off
    // In the event of emergency, hold down and keep pressing reset.
    public static final int SHOULDER_POSITION_MIN = -30;
    public static final int SHOULDER_POSITION_DOWN = 0;
    // For reaching into the crater.
    public static final int SHOULDER_POSITION_LOW = 103;
    // For reaching the lander
    public static final int SHOULDER_POSITION_HIGH = 520;
    public static final int SHOULDER_POSITION_MAX = 580;

    // This is hard to describe.
    // So, a joystick goes from -1 to 1
    // We want to translate that to the number of ticks we should adjust our target position
    // EVERY TIME WE LOOP (about once every 30ms or so if I recall)
    public static final int SHOULDER_TICKS_PER_JOYSTICK_PER_LOOP = 10;


    //endregion

    //region AUTON VALUES

    // How fast to drive when we're going a set distance. Range [0, 1]
    public static final double AUTON_DRIVE_X_INCHES_SPEED = 0.5;

    // Whether or not to use the encoder. If not, it'll use time
    public static final boolean AUTON_DRIVE_X_INCHES_USE_ENCODER = true;

    // How long it takes to drive 1 foot at AUTON_DRIVE_X_INCHES_SPEED power
    public static final double AUTON_DRIVE_X_INCHES_SECONDS_PER_FOOT = 0.5;

    // How many encoder ticks are in 1 foot of drive distance?
    public static final double AUTON_DRIVE_X_INCHES_TICKS_PER_FOOT = 300;

    // Whether or not to use the IMU (the built in sensor on the rev module). If not, it'll use time
    public static final boolean AUTON_TURN_N_DEGREES_USE_IMU = false;

    public static final boolean AUTON_TURN_N_DEGREES_USE_ENCODERS = true;

    // How long to turn 1 degree.
    // Would recommend expressing it like 2.0 / 90.0 (2 seconds to turn 90 degrees)
    public static final double AUTON_TURN_N_DEGREES_SECONDS_PER_DEGREE = 2.5 / 90.0;

    public static final double AUTON_TURN_N_DEGREES_TICKS_PER_DEGREE = 300/80;

    public static final double AUTON_TURN_N_DEGREES_SPEED = 0.5;


    // How long to drive the lift:
    public static final double AUTON_LIFT_TIME = 10;

    //endregion
}
