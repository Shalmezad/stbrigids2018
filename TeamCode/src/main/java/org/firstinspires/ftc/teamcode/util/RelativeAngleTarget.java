package org.firstinspires.ftc.teamcode.util;

public class RelativeAngleTarget {
    private final double _startAngle;
    private final double _turnAngle;
    private final double _endAngle;

    public RelativeAngleTarget(double startAngle, double turnAngle) {
        _startAngle = startAngle;
        _turnAngle = turnAngle;
        _endAngle = calculateEndAngle();
    }

    /**
     * Wraps an angle to (-180, 180]
     * @param angle An angle that may be beyond the range (-180, 180]
     * @return The angle wrapped to (-180, 180]
     */
    public static double wrapAngle(double angle){
        // Don't reinvent the wheel:
        // https://stackoverflow.com/a/43780476/978509
        return angle - 360. * Math.floor((angle + 180.0) * (1.0 / 360.0));
    }

    private double calculateEndAngle() {
        double angleSum = _startAngle + _turnAngle;
        return wrapAngle(angleSum);
    }

    public double getEndAngle(){
        return _endAngle;
    }

    public boolean isAtTarget(double currentAngle){
        // Are we turning left or right?
        if(_turnAngle > 0){
            // We're turning LEFT (positive)
            // Is this the overflow condition?
            if(_turnAngle + _startAngle > 180){
                // It's the overflow condition
                return currentAngle < 0 && currentAngle > _endAngle;
            } else {
                // It's not the overflow condition
                return currentAngle > _endAngle;
            }
        }
        else { //if(_turnAngle > 0){
            // We're turning RIGHT (negative)
            // Is this the overflow condition?
            if(_turnAngle + _startAngle < -180){
                // It's the overflow condition
                return currentAngle > 0 && currentAngle <= _endAngle;
            } else {
                // It's not the overflow condition
                return currentAngle < _endAngle;
            }
        }
    }
}
