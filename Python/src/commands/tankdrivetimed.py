"""

Sets tankdrive lspeed and rspeed for a time in seconds

"""


from wpilib.command import TimedCommand

import subsystems

class TankDriveTimed(TimedCommand):
    def __init__(self, lspeed, rspeed, timeoutInSeconds):
        super().__init__('Set Speed (%f, %f) for %f s' % (lspeed, rspeed, timeoutInSeconds), timeoutInSeconds)

        self.lspeed, self.rspeed = lspeed, rspeed
        self.requires(subsystems.drive)

    def initialize(self):
        subsystems.drive.tank(self.lspeed, self.rspeed)


    def end(self):
        subsystems.drive.tank(0, 0)