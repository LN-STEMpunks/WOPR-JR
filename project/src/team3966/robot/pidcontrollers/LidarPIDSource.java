/* L&N STEMpunks c 2017

WOPR-JR.

Full repo: github.com/ln-stempunks/WOPR-JR

Full licensing here: programming.lnstempunks.org/licensing

GPLv3
*/
package team3966.robot.pidcontrollers;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import team3966.robot.hardware.Lidar;
/**
 *
 * @author Ethan Duckworth
 */


public class LidarPIDSource implements PIDSource {
    
    public Lidar lidar;
    
    private PIDSourceType sourcetype = PIDSourceType.kDisplacement;
    public LidarPIDSource(Lidar _lidar) {
       lidar = _lidar;
    }
    public void setPIDSourceType(PIDSourceType pidst) {
        sourcetype = pidst;
    }

    public PIDSourceType getPIDSourceType() {
        return sourcetype;
    }

    public double pidGet() {
        return lidar.getInches();
    }
    
}
