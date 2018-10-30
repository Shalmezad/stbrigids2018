package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotMap;

/**
 * The linear slide portion of the robot, and it's motor (the one that pulls the strings)
 */
public class Extension {

    private DcMotor extensionMotor = null;

    public Extension(HardwareMap hardwareMap) {
        extensionMotor = hardwareMap.get(DcMotor.class, RobotMap.HW_NAME_EXTENSION_MOTOR);

        if (RobotMap.INVERT_EXTENSION_MOTOR) {
            extensionMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        extensionMotor.setZeroPowerBehavior(RobotMap.ZERO_POWER_BEHAVIOR_EXTENSION_MOTOR);

        extensionMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    /**
     * Sets the extension motor
     * 1 = forward, -1 = backwards, 0 = stop
     * @param extensionSpeed The speed to drive the extension
     */
    public void setRawSpeed(double extensionSpeed) {
        extensionMotor.setPower(extensionSpeed);
    }

    public void forward(){
        setRawSpeed(RobotMap.MAX_EXTENSION_SPEED);
    }

    public void backwards(){
        setRawSpeed(-RobotMap.MAX_EXTENSION_SPEED);
    }

    public void stop(){
        setRawSpeed(0);
    }
}
