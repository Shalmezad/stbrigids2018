package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotMap;

public class Shoulder {

    private DcMotor leftShoulderMotor = null;
    private DcMotor rightShoulderMotor = null;

    public Shoulder(HardwareMap hardwareMap) {

        leftShoulderMotor = hardwareMap.get(DcMotor.class, RobotMap.HW_NAME_LEFT_SHOULDER_MOTOR);
        rightShoulderMotor = hardwareMap.get(DcMotor.class, RobotMap.HW_NAME_RIGHT_SHOULDER_MOTOR);

        if (RobotMap.INVERT_LEFT_SHOULDER_MOTOR) {
            leftShoulderMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        if (RobotMap.INVERT_RIGHT_SHOULDER_MOTOR) {
            rightShoulderMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        leftShoulderMotor.setZeroPowerBehavior(RobotMap.ZERO_POWER_BEHAVIOR_SHOULDER_MOTORS);
        rightShoulderMotor.setZeroPowerBehavior(RobotMap.ZERO_POWER_BEHAVIOR_SHOULDER_MOTORS);

    }

    public void setRawSpeed(double speed) {
        // Both motors should go at the same rate
        leftShoulderMotor.setPower(speed);
        rightShoulderMotor.setPower(speed);
    }
}
