package team3966.robot.hardware;

import edu.wpi.first.wpilibj.VictorSP;

public class DriveMotor extends VictorSP {
	
	// no encoder
	public DriveMotor(int channel) {
		super(channel);
	}
}
