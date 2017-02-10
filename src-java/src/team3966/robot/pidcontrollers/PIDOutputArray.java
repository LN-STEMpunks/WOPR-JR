package team3966.robot.pidcontrollers;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDOutputArray implements PIDOutput {
	
	private PIDOutput[] outputs;
	private double scale;
	
	public PIDOutputArray(double sc, PIDOutput... _outputs) {
		outputs = _outputs;
		scale = sc;
	}

	public void pidWrite(double speed) {
		for (PIDOutput output : outputs) {
			output.pidWrite(speed*scale);
		}
	}
}