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
package team3966.robot.pidcontrollers;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NetworkTablePIDSource implements PIDSource {

    private String ntPath;
    private String ntVar;

    private NetworkTable nt;
    
    public double lastVal = 0;

    // by default, do distance
    private PIDSourceType sourceType = PIDSourceType.kDisplacement;

    public NetworkTablePIDSource(String _ntPath, String _ntVar) {
        ntPath = _ntPath;
        ntVar = _ntVar;
        nt = NetworkTable.getTable(ntPath);
    }
 
    public double pidGet() {
        double ret = nt.getNumber(ntVar, 0);
        lastVal = ret;
        //SmartDashboard.putNumber("PID Get NT", ret);
        return ret;
    }

    public PIDSourceType getPIDSourceType() {
        return sourceType;
    }

    public void setPIDSourceType(PIDSourceType arg0) {
        sourceType = arg0;
    }
}
