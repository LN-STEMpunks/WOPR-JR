
from wpilib.command.subsystem import Subsystem

from wpilib import RobotDrive

from hardware.motor import Motor
from values import ids

from wpilib.solenoid import Solenoid

class Drive(Subsystem):

	def __init__(self):
		super().__init__('Drive')

		# These can be used individually, but you should use RobotDrive to controll these
		self.LB = Motor(ids.LB_motor)
		self.LF = Motor(ids.LF_motor)
		self.RB = Motor(ids.RB_motor)
		self.RF = Motor(ids.RF_motor)

		self.LB.setInverted(True)
		self.LF.setInverted(True)

		self.drive_train = RobotDrive(self.LF, self.LB, self.RF, self.RB)
		self.drive_train.setExpiration(0.1)

		## Uncomment to fail
		#import time
		#time.sleep(5)
		# doesn't work bc HAL Resource error
		#self.pcm0 = Solenoid(ids.PCM_pin0)  
		#self.pcm1 = Solenoid(ids.PCM_pin1)

	def stop(self):
		self.tank(0, 0)

	def tank(self, L_speed, R_speed):
		self.drive_train.tankDrive(L_speed, R_speed, squaredInputs=False)

	def mecanum_cartesian(self, X_speed, Y_speed, R_speed=0, gyroHeading=0):
		self.drive_train.mecanumDrive_Cartesian(X_speed, Y_speed, R_speed, gyroHeading)

	def mecanum_polar(self, _speed, _direction, R_speed=0):
		self.drive_train.mecanumDrive_Polar(_speed, _direction, R_speed)

