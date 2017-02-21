/*
 * L&N STEMpunks c 2017
 *
 * WOPR-JR.
 *
 * Full repo: github.com/ln-stempunks/WOPR-JR
 *
 * Full licensing here: programming.lnstempunks.org/licensing
 *
 * GPLv3
 */
package team3966.robot.hardware;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class UltrasonicSerial {
	SerialPort serial = null;
	String distanceString = "No data";
        double lastGoodValue = 0;

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
			return "0";
		}
	}
        
        public double getDistance() {
            String read = PortReadout().replace("R", "");
            if (read == "No data") {
                return 0;
            }
            boolean hasNonZero = false;
            String fread = "";
            for (int i = 0; i < read.length(); ++i) {
                if (read.toCharArray()[i] != '0') {
                    hasNonZero = true;
                }
                if (!hasNonZero) {
                    fread = read.substring(i+1, read.length()-1);
                }
            }
            double ret = 0;
            try {
                ret = Integer.parseInt(fread) / 1000.0;
            } catch (Exception e) {
                ret = lastGoodValue;
            }
            if (ret <= 0) {
                ret = lastGoodValue;
            }
            return ret;
        }

}
