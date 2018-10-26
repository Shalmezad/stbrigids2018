package org.firstinspires.ftc.teamcode;

/**
 * Contains all configuration options such as:
 * * Hardware names
 * * Encoder ticks per foot values
 * * Enable/Disable using switches/encoders/other-sensors/etc
 */
public class RobotMap {

    //region HW NAMES

    public static final String HW_NAME_LEFT_DRIVE_TRAIN_MOTOR = "l_drive";
    public static final String HW_NAME_RIGHT_DRIVE_TRAIN_MOTOR = "r_drive";

    //endregion

    //region MOTOR INVERSIONS
    // If a motor is going backwards, change it here:

    // Base on our robot, only ONE of these should be inverted
    public static final boolean INVERT_LEFT_DRIVE_TRAIN_MOTOR = false;
    public static final boolean INVERT_RIGHT_DRIVE_TRAIN_MOTOR = true;

    //endregion
}
