package team3966.robot.hardware;


import edu.wpi.first.wpilibj.Encoder;

public class MotorEncoder extends Encoder {

	// m/s max speed wheels can turn
	public static final double MAX_SPEED = 3.0;
	// max distance to go, just something huge
	public static final double MAX_DISTANCE = 10000.0;
	
	// in m/s
	public static final double MAX_TOLERANCE_SPEED = 0.08;
	// in m
	public static final double MAX_TOLERANCE_DISTANCE = 0.1;
	
	// in m, found empirically
	public static final double DISTANCE_PER_TICK = 0.000172291666d;
	
	// no encoder
	public MotorEncoder(int... channels) {
		super(channels[0], channels[1], false, Encoder.EncodingType.k4X);
		setDistancePerPulse(DISTANCE_PER_TICK);
		if (channels.length != 2) {
			System.out.printf("ERROR: Use two channels to create an encoder\n");
		}
	}

}
