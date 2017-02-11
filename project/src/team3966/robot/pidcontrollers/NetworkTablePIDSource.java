package team3966.robot.pidcontrollers;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class NetworkTablePIDSource implements PIDSource {
	
	private String ntPath;
        private String ntVar;
        
        private NetworkTable nt;

	// by default, do distance
	private PIDSourceType sourceType = PIDSourceType.kDisplacement;
	
	public NetworkTablePIDSource(String _ntPath, String _ntVar) {
		ntPath = _ntPath;
                ntVar = _ntVar;
                nt = NetworkTable.getTable(ntPath);
	}


	public double pidGet() {
		return nt.getNumber(ntVar, 0);
	}


	public PIDSourceType getPIDSourceType() {
		return sourceType;
	}

	public void setPIDSourceType(PIDSourceType arg0) {
		sourceType = arg0;
	}
}