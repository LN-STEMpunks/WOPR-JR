package team3966.robot.pidcontrollers;

import team3966.robot.hardware.MotorEncoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class SpeedPID implements PIDSource {
	
	private MotorEncoder enc;
	private PIDSourceType sourceType = PIDSourceType.kRate;
	private double scale;
	
	public SpeedPID(double sc, MotorEncoder _e) {
		enc = _e;
		scale = sc;
	}

	public PIDSourceType getPIDSourceType() {
		return sourceType;
	}

	public double pidGet() {
		//return (motors[0].getSpeed() + motors[1].getSpeed()) / 2.0;
		return enc.getRate()*scale;
	}

	public void setPIDSourceType(PIDSourceType arg0) {
		sourceType = PIDSourceType.kRate;
		
	}
}