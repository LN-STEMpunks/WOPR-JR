package team3966.robot.hardware;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class UltrasonicSerial {
		public String PortReadout () {
			SerialPort serial = new SerialPort(9600, Port.kOnboard);
			String readout = serial.readString();
			return readout;
		}
		
}
