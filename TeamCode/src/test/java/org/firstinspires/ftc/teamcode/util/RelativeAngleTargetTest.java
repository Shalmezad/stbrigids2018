package org.firstinspires.ftc.teamcode.util;

import junit.framework.TestCase;


public class RelativeAngleTargetTest extends TestCase {

    public void testWrapAnglePositiveNoWrap(){
        double angle = RelativeAngleTarget.wrapAngle(90.0);
        assertEquals(90.0, angle);
    }

    public void testWrapAnglePositiveWrap(){
        double angle = RelativeAngleTarget.wrapAngle(270.0);
        assertEquals(-90.0, angle);
    }

    public void testWrapAngleNegativeNoWrap(){
        double angle = RelativeAngleTarget.wrapAngle(-90.0);
        assertEquals(-90.0, angle);
    }

    public void testWrapAngleNegativeWrap(){
        double angle = RelativeAngleTarget.wrapAngle(-270.0);
        assertEquals(90.0, angle);
    }


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

    public void testIsAtTargetTurnLeftPositiveOnly(){
        RelativeAngleTarget rat = new RelativeAngleTarget(5.0, 10.0);
        // So we're going to 15.0.
        // We're not there at our start position:
        assertFalse(rat.isAtTarget(5.0));
        // We're not there if we went the wrong way:
        assertFalse(rat.isAtTarget(-5.1));
        // We're not there halfway:
        assertFalse(rat.isAtTarget(10.0));
        // We're not there when we're really close:
        assertFalse(rat.isAtTarget(14.9));
        // We're there once we past it:
        assertTrue(rat.isAtTarget(15.1));
    }


    public void testIsAtTargetTurnLeftNegativeOnly() {
        RelativeAngleTarget rat = new RelativeAngleTarget(-90.0, 10.0);
        // So we're going to -80.0
        // We're not there at our start position:
        assertFalse(rat.isAtTarget(-90.0));
        // We're not there if we went the wrong way:
        assertFalse(rat.isAtTarget(-100.1));
        // We're not there halfway:
        assertFalse(rat.isAtTarget(-85.0));
        // We're not there when we're really close:
        assertFalse(rat.isAtTarget(-80.1));
        // We're there once we past it:
        assertTrue(rat.isAtTarget(-79.9));
    }


    public void testIsAtTargetTurnLeftNegativePositive() {
        RelativeAngleTarget rat = new RelativeAngleTarget(-5.0, 10.0);
        // So we're going to 5.0
        // We're not there at our start position:
        assertFalse(rat.isAtTarget(-5.0));
        // We're not there if we went the wrong way:
        assertFalse(rat.isAtTarget(-15.1));
        // We're not there halfway:
        assertFalse(rat.isAtTarget(0.0));
        // We're not there when we're really close:
        assertFalse(rat.isAtTarget(4.9));
        // We're there once we past it:
        assertTrue(rat.isAtTarget(5.1));
    }


    public void testIsAtTargetTurnLeftOverflow() {
        RelativeAngleTarget rat = new RelativeAngleTarget(175.0, 10.0);
        // So we're going to -175.0
        // We're not there at our start position:
        assertFalse(rat.isAtTarget(175.0));
        // We're not there if we went the wrong way:
        assertFalse(rat.isAtTarget(164.9));
        // We're not there halfway:
        assertFalse(rat.isAtTarget(180.0));
        // We're not there when we're really close:
        assertFalse(rat.isAtTarget(-175.1));
        // We're there once we past it:
        assertTrue(rat.isAtTarget(-174.9));
    }

    public void testIsAtTargetTurnRightPositiveOnly(){
        RelativeAngleTarget rat = new RelativeAngleTarget(90.0, -10.0);
        // So we're going to 80
        // We're not there at our start position:
        assertFalse(rat.isAtTarget(90.0));
        // We're not there if we went the wrong way:
        assertFalse(rat.isAtTarget(100.1));
        // We're not there halfway:
        assertFalse(rat.isAtTarget(85.0));
        // We're not there when we're really close:
        assertFalse(rat.isAtTarget(80.1));
        // We're there once we past it:
        assertTrue(rat.isAtTarget(79.9));
    }

    public void testIsAtTargetTurnRightNegativeOnly(){
        RelativeAngleTarget rat = new RelativeAngleTarget(-90.0, -10.0);
        // So we're going to -100
        // We're not there at our start position:
        assertFalse(rat.isAtTarget(-90.0));
        // We're not there if we went the wrong way:
        assertFalse(rat.isAtTarget(-79.9));
        // We're not there halfway:
        assertFalse(rat.isAtTarget(-95.0));
        // We're not there when we're really close:
        assertFalse(rat.isAtTarget(-99.9));
        // We're there once we past it:
        assertTrue(rat.isAtTarget(-100.1));
    }

    public void testIsAtTargetTurnRightPositiveNegative(){
        RelativeAngleTarget rat = new RelativeAngleTarget(5.0, -10.0);
        // So we're going to -5
        // We're not there at our start position:
        assertFalse(rat.isAtTarget(5.0));
        // We're not there if we went the wrong way:
        assertFalse(rat.isAtTarget(15.1));
        // We're not there halfway:
        assertFalse(rat.isAtTarget(0.0));
        // We're not there when we're really close:
        assertFalse(rat.isAtTarget(-4.9));
        // We're there once we past it:
        assertTrue(rat.isAtTarget(-5.1));
    }


    public void testIsAtTargetTurnRightOverflow(){
        RelativeAngleTarget rat = new RelativeAngleTarget(-175.0, -10.0);
        // So we're going to 175.0
        // We're not there at our start position:
        assertFalse(rat.isAtTarget(-175.0));
        // We're not there if we went the wrong way:
        assertFalse(rat.isAtTarget(-164.9));
        // We're not there halfway:
        assertFalse(rat.isAtTarget(-180.0));
        assertFalse(rat.isAtTarget(180.0));
        // We're not there when we're really close:
        assertFalse(rat.isAtTarget(175.1));
        // We're there once we past it:
        assertTrue(rat.isAtTarget(174.9));
    }

}