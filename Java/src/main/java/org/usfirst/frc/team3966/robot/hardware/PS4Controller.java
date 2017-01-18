package org.usfirst.frc.team3966.robot.hardware;


import edu.wpi.first.wpilibj.Joystick;
import static org.usfirst.frc.team3966.robot.values.PS4Buttons.*;
import org.usfirst.frc.team3966.util.Logger;

/**
 * PS4 controller wrapper for a joystick.
 * @author Matthew.Lythgoe
 */
public class PS4Controller extends Joystick {
    
    private Logger ps4controller_logger;

    
    public PS4Controller(int port) {
        super(port);
        ps4controller_logger = new Logger("PS4 Controller (" + port + ")");
    }

    private double _pow_scale(double val, double pow) {
        double _abs_v = Math.abs(val);
        double _sgn_v = Math.signum(val);
        return _sgn_v * Math.pow(_abs_v, pow);
    }

    private double _pow_scale(double val) {
        return _pow_scale(val, 2.5);
    }
    
    private double _exp_scale(double val, double base) {
        double _abs_v = Math.abs(val);
        double _sgn_v = Math.signum(val);
        return _sgn_v * (Math.pow(base, _abs_v) - 1.0) / (base - 1.0);
    }

    private double _exp_scale(double val) {
        return _exp_scale(val, Math.E);
    }

    public boolean getButton(int port) {
        return getRawButton(port);
    }

    public double getAxis(int port) {
        return _pow_scale(getRawAxis(port));
    }
}
