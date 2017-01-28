"""

Operator interface.

We have this in python, but not in Java.

We might change it there or here.

For now, it is sort of a singleton

"""


from wpilib.command.subsystem import Subsystem

from hardware import controller
from values import ids

class OI(Subsystem):

	def __init__(self):

		super().__init__('OI')

		self.joystick = controller.Controller(ids.controller)
