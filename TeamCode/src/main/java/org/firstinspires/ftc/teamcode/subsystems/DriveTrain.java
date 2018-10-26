package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotMap;

public class DriveTrain {

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    public DriveTrain(HardwareMap hardwareMap) {
        leftDrive = hardwareMap.get(DcMotor.class, RobotMap.HW_NAME_LEFT_DRIVE_TRAIN_MOTOR);
        rightDrive = hardwareMap.get(DcMotor.class, RobotMap.HW_NAME_RIGHT_DRIVE_TRAIN_MOTOR);

        if (RobotMap.INVERT_LEFT_DRIVE_TRAIN_MOTOR) {
            leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        if (RobotMap.INVERT_RIGHT_DRIVE_TRAIN_MOTOR) {
            rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        leftDrive.setZeroPowerBehavior(RobotMap.ZERO_POWER_BEHAVIOR_DRIVE_TRAIN_MOTORS);
        rightDrive.setZeroPowerBehavior(RobotMap.ZERO_POWER_BEHAVIOR_DRIVE_TRAIN_MOTORS);
    }

    /**
     * Sets the drive train motors
     * 1 = forward, -1 = backwards, 0 = stop
     * @param leftSpeed The left speed of the drive train
     * @param rightSpeed The right speed of the drive train
     */
    public void setRawSpeed(double leftSpeed, double rightSpeed) {
        leftDrive.setPower(leftSpeed);
        rightDrive.setPower(rightSpeed);
    }
}
