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

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Lidar {
    //lidar/distance 
    // var is Distance
    private NetworkTable nt = NetworkTable.getTable("lidar/distance");
    public double getDistance() {    
        double distance = nt.getNumber("Distance", Math.PI);
        return distance;
    }
    public double getInches () {
        double distance = nt.getNumber("Distance", Math.PI);
        double inches = distance * 0.393701;
        return inches;
    }
    
}