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

import team3966.robot.hardware.MotorEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class MotorPIDSource implements PIDSource {
	
	private MotorEncoder encoder;
	private double scale = 1.0;

	// by default, do distance
	private PIDSourceType sourceType = PIDSourceType.kRate;
	
	public MotorPIDSource(MotorEncoder _encoder) {
		encoder = _encoder;
	}

	public void useDistance() {
		setPIDSourceType(PIDSourceType.kDisplacement);
	}

	public void useSpeed() {
		setPIDSourceType(PIDSourceType.kRate);
	}

	public void setScale(double _scale) {
		scale = _scale;
	}


	public double pidGet() {
		if (sourceType == PIDSourceType.kDisplacement) {
			return encoder.getDistance();
		} else if (sourceType == PIDSourceType.kRate) {
			return encoder.getRate();
		} else {
			return 0;
		}
	}


	public PIDSourceType getPIDSourceType() {
		return sourceType;
	}

	public void setPIDSourceType(PIDSourceType arg0) {
		sourceType = arg0;
	}
}