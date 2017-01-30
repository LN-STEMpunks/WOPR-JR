package frc3966.robot.hardware;


import edu.wpi.first.wpilibj.Joystick;

/**
 * PS4 controller wrapper for a joystick.
 * @author Matthew.Lythgoe
 */
public class Controller extends Joystick {
   
    
    public Controller(int port) {
        super(port);
    }

    private double _pow_scale(double val, double pow) {
        double _abs_v = Math.abs(val);
        double _sgn_v = Math.signum(val);
        return _sgn_v * Math.pow(_abs_v, pow);
    }

    private double _pow_scale(double val) {
        return _pow_scale(val, 2.0);
    }
    
    public boolean getButton(int port) {
        return getRawButton(port);
    }

    public double getAxis(int port) {
        return _pow_scale(getRawAxis(port));
    }
}
