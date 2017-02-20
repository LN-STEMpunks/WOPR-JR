/*
 * L&N STEMpunks c 2017
 *
 * WOPR-JR.
 *
 * Full repo: github.com/ln-stempunks/WOPR-JR
 *
 * Full licensing here: programming.lnstempunks.org/licensing
 *
 * GPLv3
 */
package team3966.robot.pidcontrollers;

import team3966.robot.hardware.DriveMotor;
import edu.wpi.first.wpilibj.PIDOutput;

public class MotorTurnAndMovePIDOutput implements PIDOutput {

    private DriveMotor[] Lmotors, Rmotors;

    private double Lconst, Rconst;

    // |scale| < 1, should be
    private double scale = 1.0;

    public MotorTurnAndMovePIDOutput(DriveMotor[] _Lmotors, DriveMotor[] _Rmotors, double _Lconst, double _Rconst) {
        Lmotors = _Lmotors;
        Rmotors = _Rmotors;
        Lconst = _Lconst;
        Rconst = _Rconst;
    }

    public void setScale(double _scale) {
        scale = _scale;
    }

    public void pidWrite(double speed) {
        double Lval = Lconst + speed * scale;
        double Rval = Rconst - speed * scale;
        if (Lval > 1) {
            Lval = 1;
        }
        if (Lval < -1) {
            Lval = -1;
        }
        if (Rval > 1) {
            Rval = 1;
        }
        if (Rval < -1) {
            Rval = -1;
        }

        for (DriveMotor motor : Lmotors) {
            motor.pidWrite(Lval);
        }
        for (DriveMotor motor : Rmotors) {
            motor.pidWrite(Rval);
        }
    }
}
