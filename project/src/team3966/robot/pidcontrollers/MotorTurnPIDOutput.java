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

public class MotorTurnPIDOutput implements PIDOutput {
	
	private DriveMotor[] Lmotors, Rmotors;

	// |scale| < 1, should be
	private double scale = 1.0;
	
	public MotorTurnPIDOutput(DriveMotor[] _Lmotors, DriveMotor[] _Rmotors) {
		Lmotors = _Lmotors;
                Rmotors = _Rmotors;
	}
        
        public void setScale(double _scale) {
            scale = _scale;
        }

	public void pidWrite(double speed) {
		for (DriveMotor motor : Lmotors) {
			motor.pidWrite(speed * scale);
		}
                for (DriveMotor motor : Rmotors) {
			motor.pidWrite(-speed * scale);
		}
	}
}