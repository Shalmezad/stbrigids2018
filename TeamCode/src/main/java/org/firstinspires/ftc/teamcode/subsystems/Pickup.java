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

    /**
     * Sets the pickup motor
     * 1 = in/up, -1 = out/down, 0 = stop
     * @param pickupSpeed The speed to drive the pickup
     */
    public void setRawSpeed(double pickupSpeed) {
        pickupMotor.setPower(pickupSpeed);
    }
}
