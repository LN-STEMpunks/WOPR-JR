import wpilib
from wpilib.joystick import Joystick

import math

class Controller(Joystick):

    def _sgn(val):
        if val > 0:
            return 1
        elif val == 0:
            return 0
        else:
            return -1

    def _pow_scale(val, pw=2.0):
        _abs_v = abs(val)
        _sgn_v = Controller._sgn(val)
        return _sgn_v * (_abs_v ** pw)

    def _exp_scale(val, base=2**5):
        _abs_v = abs(val)
        _sgn_v = Controller._sgn(val)
        return _sgn_v * ((base**_abs_v-1)/(base-1))

    def getAxis(self, id):
        #return self.getRawAxis(id)
        return Controller._pow_scale(self.getRawAxis(id))


