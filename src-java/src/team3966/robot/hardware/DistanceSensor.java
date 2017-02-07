package team3966.robot.hardware;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.AnalogInput;

public class DistanceSensor extends AnalogInput {

	// millivolts per meter
	private double MV_PER_M = 100 * 4.9;
	
	public DistanceSensor(int id) {
		super(id);
		setOversampleBits(4);
		setAverageBits(2);
		setGlobalSampleRate(62500);
		//SmartDashboard.putNumber("Distance Sensor", DistanceSensor.getDistance());
	}

	// returns distance in meters
	// Is finicky, try debugging it
	public double getDistance() {
		double millivolts = getAverageVoltage() * 1000.0;
		return millivolts / MV_PER_M;
	}
}

