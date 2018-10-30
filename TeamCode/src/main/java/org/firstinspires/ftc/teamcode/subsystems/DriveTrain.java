package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.RobotMap;
import org.firstinspires.ftc.teamcode.util.Constants;

public class DriveTrain {

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    BNO055IMU imu;

    private double targetInches = 0;
    private ElapsedTime runtime = new ElapsedTime();

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

        if (RobotMap.AUTON_TURN_N_DEGREES_USE_IMU) {
            BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

            parameters.mode = BNO055IMU.SensorMode.IMU;
            parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
            parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
            parameters.loggingEnabled = false;

            imu = hardwareMap.get(BNO055IMU.class, "imu");

            imu.initialize(parameters);
        }
    }

    /**
     * Sets the drive train motors
     * 1 = forward, -1 = backwards, 0 = stop
     *
     * @param leftSpeed  The left speed of the drive train
     * @param rightSpeed The right speed of the drive train
     */
    public void setRawSpeed(double leftSpeed, double rightSpeed) {
        leftDrive.setPower(leftSpeed);
        rightDrive.setPower(rightSpeed);
    }

    public void stop() {
        setRawSpeed(0, 0);
    }

    public void forward(double speed) {
        speed = Math.abs(speed);
        setRawSpeed(speed, speed);
    }

    public void backward(double speed) {
        speed = -1 * Math.abs(speed);
        setRawSpeed(speed, speed);
    }

    public int currentDistanceTicks() {
        return leftDrive.getCurrentPosition();
    }

    public void setDistanceTargetInches(double inches) {
        targetInches = inches;
        runtime.reset();
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public boolean isAtTargetDistance() {
        // Look at config, see if we're running by encoder or time
        if (RobotMap.AUTON_DRIVE_X_INCHES_USE_ENCODER) {
            // use the encoder distance
            int currentTicks = currentDistanceTicks();
            double targetFeet = targetInches * Constants.FEET_PER_INCH;
            double targetTicks = RobotMap.AUTON_DRIVE_X_INCHES_TICKS_PER_FOOT * targetFeet;
            return currentTicks >= targetTicks;
        } else {
            // use the timer:
            double targetFeet = targetInches * Constants.FEET_PER_INCH;
            double targetTimeSeconds = RobotMap.AUTON_DRIVE_X_INCHES_SECONDS_PER_FOOT * targetFeet;
            return runtime.seconds() >= targetTimeSeconds;
        }
    }
}
