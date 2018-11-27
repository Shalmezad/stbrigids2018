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

    private double calculateEndAngle() {
        double angleSum = _startAngle + _turnAngle;
        if ((angleSum >= 0 && angleSum <= 180) ||
                (Math.abs(_turnAngle) > Math.abs(_startAngle) && _startAngle * _turnAngle < 0)) {
            return angleSum;
        } else {
            if (angleSum >= 0) {
                return angleSum - 360;
            } else {
                return angleSum + 360;
            }
        }
    }

    public boolean isAtTarget(double currentAngle){

        double angleSum = _startAngle + _turnAngle;

        if ((angleSum >= 0 && angleSum <= 180) || (Math.abs(_turnAngle) > Math.abs(_startAngle) && _startAngle * _turnAngle < 0 )) {

            if(_turnAngle > 0) {
                if(_endAngle == 180){
                    return currentAngle < 0;
                }
                else {
                    return currentAngle >= _endAngle;
                }
            }
            else {
                return currentAngle <= _endAngle;
            }
        }
        else {
            if(_turnAngle >= 0){
                return currentAngle < 0 && currentAngle >= _endAngle;
            }
            else {
                return currentAngle > 0 && currentAngle <= _endAngle;
            }
        }
    }
}
