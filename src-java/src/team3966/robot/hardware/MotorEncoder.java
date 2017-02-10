package team3966.robot.hardware;


import edu.wpi.first.wpilibj.Encoder;

public class MotorEncoder extends Encoder {

	// m/s max speed
	public static final double MAX_SPEED = 2.5;
	public static final double MAX_TOLERANCE = 0.2;
	public static final double DISTANCE_PER_TICK = .000827 / 4.8;
	
	// no encoder
	public MotorEncoder(int chA, int chB) {
		super(chA, chB, false, Encoder.EncodingType.k4X);
		setDistancePerPulse(DISTANCE_PER_TICK);
	}

}
