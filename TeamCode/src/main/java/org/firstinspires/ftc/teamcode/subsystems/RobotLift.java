package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotMap;

/**
 * The lift portion of the robot, and it's motors (the one that drives the worm gear)
 */
public class RobotLift {

    private DcMotor liftMotor = null;

    public RobotLift(HardwareMap hardwareMap) {

        liftMotor = hardwareMap.get(DcMotor.class, RobotMap.HW_NAME_LIFT_MOTOR);

        if (RobotMap.INVERT_LIFT_MOTOR) {
            liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        }

        liftMotor.setZeroPowerBehavior(RobotMap.ZERO_POWER_BEHAVIOR_LIFT_MOTOR);

        liftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    /**
     * Sets the lift motor
     * 1 = up (lowers robot), -1 = down (raises robot), 0 = stop
     * @param speed The speed to drive the lift
     */
    public void setRawSpeed(double speed) {
        liftMotor.setPower(speed);
    }

    public void up(){
        setRawSpeed(RobotMap.MAX_LIFT_SPEED);
    }

    public void down(){
        setRawSpeed(-RobotMap.MAX_LIFT_SPEED);
    }

    public void stop(){
        setRawSpeed(0.0);
    }
}
