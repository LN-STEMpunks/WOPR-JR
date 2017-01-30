from wpilib.robotbase import RobotBase

from wpilib.resource import Resource

from .drive import Drive
from .oi import OI

from values import ids

from hardware.distancesensor import DistanceSensor

drive = None
oi = None
ultrasonic = None

def init():
	global drive, oi, ultrasonic


	if oi is not None and not RobotBase.isSimulation():
		raise RuntimeError('Subsystems have already been initialized')

	drive = Drive()

	oi = OI()

	ultrasonic = DistanceSensor(ids.ultrasonic_0)
