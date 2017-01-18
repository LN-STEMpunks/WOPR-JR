from wpilib.robotbase import RobotBase

from wpilib.resource import Resource

from .drive import Drive
from .oi import OI

drive = None
oi = None


def init():
    global drive, oi


    if oi is not None and not RobotBase.isSimulation():
        raise RuntimeError('Subsystems have already been initialized')

    drive = Drive()

    oi = OI()