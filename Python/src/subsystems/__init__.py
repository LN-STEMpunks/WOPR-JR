from wpilib.robotbase import RobotBase

from wpilib.resource import Resource

from .drive import Drive
from .oi import OI
from .sensors import Sensors

drive = None
oi = None
sensors = None

def init():
	global drive, oi, sensors


	if oi is not None and not RobotBase.isSimulation():
		raise RuntimeError('Subsystems have already been initialized')

	drive = Drive()

	oi = OI()

	sensors = Sensors()
