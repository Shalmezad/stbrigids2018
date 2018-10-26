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

    //endregion

    //region HW NAMES

    public static final String HW_NAME_LEFT_DRIVE_TRAIN_MOTOR = "l_drive";
    public static final String HW_NAME_RIGHT_DRIVE_TRAIN_MOTOR = "r_drive";

    public static final String HW_NAME_LEFT_SHOULDER_MOTOR = "l_shoulder";
    public static final String HW_NAME_RIGHT_SHOULDER_MOTOR = "r_shoulder";

    //endregion

    //region MOTOR INVERSIONS
    // If a motor is going backwards, change it here:

    // Base on our robot, only ONE of these should be inverted
    public static final boolean INVERT_LEFT_DRIVE_TRAIN_MOTOR = false;
    public static final boolean INVERT_RIGHT_DRIVE_TRAIN_MOTOR = true;

    // Base on our robot, only ONE of these should be inverted
    public static final boolean INVERT_LEFT_SHOULDER_MOTOR = false;
    public static final boolean INVERT_RIGHT_SHOULDER_MOTOR = true;

    //endregion

    //region MOTOR ZERO POWER MODES
    // This determines whether a motor coasts or brakes when it's set to 0
    // Brake means it immediately stops, and tries to hold the position (like slamming brakes on a car)
    // Coast means it drifts slowly to a stop (like letting go of the gas on a car)

    public static final DcMotor.ZeroPowerBehavior ZERO_POWER_BEHAVIOR_DRIVE_TRAIN_MOTORS = DcMotor.ZeroPowerBehavior.BRAKE;

    public static final DcMotor.ZeroPowerBehavior ZERO_POWER_BEHAVIOR_SHOULDER_MOTORS = DcMotor.ZeroPowerBehavior.BRAKE;

    //endregion


    //region MOTOR MAX SPEEDS
    // This limits the maximum speeds we allow certain motors to go
    // This is to help prevent going too fast on sensitive parts

    public static final double MAX_SHOULDER_SPEED = 0.5;

    //endregion
}
