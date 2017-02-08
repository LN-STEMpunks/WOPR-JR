package team3966.robot.hardware;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class UltrasonicSerial {
	SerialPort serial = null;

	public String PortReadout() {
		try {
			if (serial == null) {
				serial = new SerialPort(9600, Port.kOnboard);
				serial.setTimeout(0.020);
			}
			// byte [] buf = serial.read(8);
			// return new String(buf);

			if (serial.getBytesReceived() > 0) {

				String readout = serial.readString();
				return readout;
			} else {
				return "No data";
			}
		} catch (Exception e) {
			return "Got an error";
		}
	}

}
