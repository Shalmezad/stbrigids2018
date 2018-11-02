package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotMap;

/**
 * The shoulder portion of the robot, and it's motors (the ones that drive the chains)
 */
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


        leftShoulderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightShoulderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        if(RobotMap.SHOULDER_USE_ENCODER){
            leftShoulderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightShoulderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        else {
            leftShoulderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightShoulderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    /**
     * Sets the shoulder motors
     * 1 = up, -1 = down, 0 = stop
     * @param speed The speed to drive the shoulder
     */
    public void setRawSpeed(double speed) {
        // Both motors should go at the same rate
        leftShoulderMotor.setPower(speed);
        rightShoulderMotor.setPower(speed);
    }

    public void up(){
        setRawSpeed(RobotMap.MAX_SHOULDER_SPEED);
    }

    public void down(){
        setRawSpeed(-RobotMap.MAX_SHOULDER_SPEED);
    }

    public void stop(){
        setRawSpeed(0);
    }

    public int getLeftShoulderPosition(){
        return leftShoulderMotor.getCurrentPosition();
        //return leftShoulderMotor.
    }

    public int getRightShoulderPosition(){
        return rightShoulderMotor.getCurrentPosition();
        //return leftShoulderMotor.
    }

    public void resetTicks(){
        leftShoulderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightShoulderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftShoulderMotor.setTargetPosition(0);
        rightShoulderMotor.setTargetPosition(0);
        leftShoulderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightShoulderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public int getTargetTicks(){
        return rightShoulderMotor.getTargetPosition();
    }

    public void setTargetTicks(int ticks){
        rightShoulderMotor.setTargetPosition(ticks);
        leftShoulderMotor.setTargetPosition(ticks);
    }
}
