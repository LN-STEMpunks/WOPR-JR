package team3966.robot.hardware;

import edu.wpi.first.wpilibj.Spark;

public class DriveMotor extends Spark {
	
	// no encoder
	public DriveMotor(int channel) {
		super(channel);
	}
}
