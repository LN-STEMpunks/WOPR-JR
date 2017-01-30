package org.usfirst.frc.team3966.robot.hardware;


import org.usfirst.frc.team3966.robot.values.IDs;
import edu.wpi.first.wpilibj.AnalogInput;

public class DistanceSensor extends AnalogInput {

	// millivolts per centimeter
	private double MV_PER_M = 1000 * 4.9;
	
    public DistanceSensor() {
    	super(IDs.ultrasonic_0);
		setOversampleBits(4);
		setAverageBits(2);
		setGlobalSampleRate(62500);
		
    }

    // returns distance in meters
	public double getDistance() {
		double millivolts = getVoltage() * 1000;
		return millivolts / MV_PER_M;
	}
}
