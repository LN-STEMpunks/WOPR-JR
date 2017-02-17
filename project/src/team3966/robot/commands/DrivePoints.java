package team3966.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team3966.math.algorithms.TravellingSalesman;

/**
 * Drives to a number of points
 *
 * @author cade
 */
public class DrivePoints extends CommandGroup {

    private double[][] offsets;
    
    public DrivePoints(double[][] _offsets, boolean optimized) {
        if (optimized) {
            offsets = TravellingSalesman.minimizeDistance_simpleswap(_offsets);
        } else {
            offsets = _offsets;
        }
        double angle, lastAngle = 0;
        double lastX = 0, lastY = 0;
        
        double dist;
        
        for (int i = 0; i < offsets.length; ++i) {
            double dx = offsets[i][0]-lastX, dy = offsets[i][1]-lastY;
            angle = Math.atan2(dy, dx) * 180 / Math.PI;
            dist = Math.sqrt(dx*dx+dy*dy);
            addSequential(new TankDriveAngle(angle-lastAngle));
            addSequential(new TankDriveDistance(dist, dist));
            lastAngle = angle;
            lastX = offsets[i][0];
            lastY = offsets[i][1];
        }
    }
}
