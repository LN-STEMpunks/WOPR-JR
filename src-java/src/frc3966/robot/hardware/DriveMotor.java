package frc3966.robot.hardware;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;

public class DriveMotor extends VictorSP {

	// m/s max speed
	public static final double MAX_SPEED = 1.5;
	public static final double MAX_TOLERANCE = 0.2;
	
	private Encoder enc;
	
	// no encoder
	public DriveMotor(int channel) {
		super(channel);
	}

	// pass channel, and then encoder a channel and b channel
	public DriveMotor(int channel, int... encoder_dio) {
		super(channel);
		enc = new Encoder(encoder_dio[0], encoder_dio[1], false, Encoder.EncodingType.k4X);
		enc.setMaxPeriod(.1);
		enc.setSamplesToAverage(7);
		enc.setMinRate(10);
		
		// PID controller: http://wpilib.screenstepslive.com/s/3120/m/7912/l/79828-operating-the-robot-with-feedback-from-sensors-pid-control
		
		// this is the distance (in meters) per 'pulse' (every little click) of the encoder.
		// probably found empirically, but the formula might look like:
		// C = circumference of wheel, P = pulses per 360 degree revolution
		// set this value to: C / P
		enc.setDistancePerPulse(5);

		// uncomment to reverse
		//enc.setReverseDirection(true);
		
		enc.reset();
	}
	
	// for use in Drive.java
	public void pidWrite(double speed) {
		set(speed / MAX_SPEED);
	}
	
	
	public Encoder getEncoder() {
		return enc;
	}
	
	public double getDistance() {
		// calculated using setDistancePerPulse
		return enc.getDistance();
	}
	
	// in m/s
	public double getSpeed() {
		return enc.getRate();
	}
}
