package team3966.robot.hardware;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class UltrasonicSerial {
	SerialPort serial = null;
	String distanceString = "No data";

	public String PortReadout() {
		try {
			if(serial == null) {
				serial = new SerialPort(9600, Port.kOnboard);
				serial.setTimeout(0.1);
			}
			// byte [] buf = serial.read(8);
			// return new String(buf);

			if (serial.getBytesReceived() > 0) {

				String readout = serial.readString();
				this.distanceString = readout;
			} 
			return this.distanceString;
		} catch (Exception e) {
			return "Got an error";
		}
	}

}
