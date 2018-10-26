package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotMap;

public class Pickup {

    private DcMotor pickupMotor = null;

    public Pickup(HardwareMap hardwareMap) {
        pickupMotor = hardwareMap.get(DcMotor.class, RobotMap.HW_NAME_PICKUP_MOTOR);

        if (RobotMap.INVERT_PICKUP_MOTOR) {
            pickupMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        pickupMotor.setZeroPowerBehavior(RobotMap.ZERO_POWER_BEHAVIOR_PICKUP_MOTOR);
    }

    public void setRawSpeed(double pickup_speed) {
        pickupMotor.setPower(pickup_speed);
    }
}
