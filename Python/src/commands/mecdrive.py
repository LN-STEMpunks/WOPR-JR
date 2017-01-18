"""

Tank drive, using controllers

"""


from wpilib.command import Command

import subsystems

from values import exbuttons

class MecDrive(Command):

    def __init__(self):
        super().__init__('MecDrive')

        self.requires(subsystems.drive)


    def execute(self):

        _axis = subsystems.oi.joystick.getAxis

        subsystems.drive.mecanum_cartesian(_axis(exbuttons.STICK_X_AXIS), -_axis(exbuttons.STICK_Y_AXIS), _axis(exbuttons.STICK_ROT))




