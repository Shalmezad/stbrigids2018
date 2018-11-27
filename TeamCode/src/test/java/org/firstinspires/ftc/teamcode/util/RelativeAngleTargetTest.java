package org.firstinspires.ftc.teamcode.util;

import junit.framework.TestCase;


public class RelativeAngleTargetTest extends TestCase {

    public void testEndAngleTurnLeftPositiveOnly() {
        RelativeAngleTarget rat = new RelativeAngleTarget(5.0, 10.0);
        assertEquals(15.0, rat.getEndAngle());
    }

    public void testEndAngleTurnLeftNegativeOnly() {
        RelativeAngleTarget rat = new RelativeAngleTarget(-90.0, 10.0);
        assertEquals(-80.0, rat.getEndAngle());
    }

    public void testEndAngleTurnLeftNegativePositive() {
        RelativeAngleTarget rat = new RelativeAngleTarget(-5.0, 10.0);
        assertEquals(5.0, rat.getEndAngle());
    }

    public void testEndAngleTurnLeftOverflow() {
        RelativeAngleTarget rat = new RelativeAngleTarget(175.0, 10.0);
        assertEquals(-175.0, rat.getEndAngle());
    }

    public void testEndAngleTurnRightPositiveOnly(){
        RelativeAngleTarget rat = new RelativeAngleTarget(90.0, -10.0);
        assertEquals(80.0, rat.getEndAngle());
    }

    public void testEndAngleTurnRightNegativeOnly(){
        RelativeAngleTarget rat = new RelativeAngleTarget(-90.0, -10.0);
        assertEquals(-100.0, rat.getEndAngle());
    }

    public void testEndAngleTurnRightPositiveNegative(){
        RelativeAngleTarget rat = new RelativeAngleTarget(5.0, -10.0);
        assertEquals(-5.0, rat.getEndAngle());
    }

    public void testEndAngleTurnRightOverflow(){
        RelativeAngleTarget rat = new RelativeAngleTarget(-175.0, -10.0);
        assertEquals(175.0, rat.getEndAngle());
    }


}