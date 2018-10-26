package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotMap;

public class Extension {

    private DcMotor extensionMotor = null;

    public Extension(HardwareMap hardwareMap) {
        extensionMotor = hardwareMap.get(DcMotor.class, RobotMap.HW_NAME_EXTENSION_MOTOR);

        if (RobotMap.INVERT_EXTENSION_MOTOR) {
            extensionMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        extensionMotor.setZeroPowerBehavior(RobotMap.ZERO_POWER_BEHAVIOR_EXTENSION_MOTOR);
    }

    public void setRawSpeed(double extension_speed) {
        extensionMotor.setPower(extension_speed);
    }
}
