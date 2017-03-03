/* L&N STEMpunks c 2017

WOPR-JR.

Full repo: github.com/ln-stempunks/WOPR-JR

Full licensing here: programming.lnstempunks.org/licensing

GPLv3
*/

package team3966.robot.commands;

/**
 *
 * @author Ethan Duckworth
 */


public class Autonomous3HopperSide {
    AutoShell left, middle, right;
    void LeftSide() {
        left = new AutoShell(false, 3.25, 30, true, 0.7008876, 0, true, -0.75, -30, 1.5);
    }
    void Middle() {
        middle = new AutoShell(true, 0, 0, false, -1.404355, -90, false, 2, 90, 2);
    }
    void RightSide() {
        right = new AutoShell(false, 3.25, -30, true, 0.7008876, 0, true, -0.75, 30, 1.5);
    }
}
