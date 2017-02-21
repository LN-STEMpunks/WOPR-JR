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
package team3966.math.algorithms;

/**
 *
 * @author cade
 */
public class TravellingSalesman {
    public static double distancePoint(double[] a, double[] b) {
        return Math.sqrt(distanceSqrPoint(a, b));
    }
    
    public static double distanceSqrPoint(double[] a, double[] b) {
        double dx = b[0] - a[0], dy = b[1] - a[1];
        return dx * dx + dy * dy;
    }
    
    // distances going from (current, current) to points[i][0, 1] and then so on. Points are the offsets
    public static double distance(double[][] points) {
        double dist = 0;
        for (int i = 1; i < points.length; ++i) {
            dist += distancePoint(points[i], points[i-1]);
        }
        return dist;
    }

    public static double[][] minimizeDistance_simpleswap(double[][] points) {
        double[][] tmpa;
        double[] tmp;
        boolean wasSwitched = true;
        while (wasSwitched) {
            wasSwitched = false;
            for (int i = 0; i < points.length; ++i) {
                for (int j = i+1; j < points.length; ++j) {
                    tmpa = points.clone();
                    tmp = tmpa[i];
                    tmpa[i] = tmpa[j];
                    tmpa[j] = tmp;
                    if (distance(tmpa) < distance(points)) {
                        wasSwitched = true;
                        points = tmpa.clone();
                    }
                }            
            }
        }
        return points;
    }
    
}
