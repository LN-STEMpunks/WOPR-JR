VexBot-py (0.1.0); urgency=low

   * implemented joystick scaling
     - \_pow_scale and \_exp_scale scale the input for gradual changes


 -- Cade Brown <cade@cade.site>  2017-01-12 19:18 -500

VexBot-java (0.1.0); urgency=high

   * implemented joystick scaling
     - \_pow_scale and \_exp_scale scale the input for gradual changes


 -- Cade Brown <cade@cade.site>  2017-01-11 19:18 -500


VexBot-py (0.1.0); urgency=low

   * cleaned up code
     - refactored

  * PCMs still don't work
     - changing gears is not supported 


 -- Cade Brown <cade@cade.site>  2017-01-11 19:20 -500

VexBot-java (0.1.0); urgency=high

   * fixed PCMs
     - both gears are now enabled with the java version only


 -- Cade Brown <cade@cade.site>  2017-01-11 19:20 -500


VexBot (0.0.1); urgency=low

   * First changelog
      - in roughly Debian format

   * created `hardware` folder under src/... for hardware abstraction
     - Still debating usage of PS4Controller

   * created `values` folder under src/... for storing values similar to constants
     - Not mathematical constants, but rather things like PINs, IDs, Buttons (for controller), etc.

   * created `math` and `math/complex` folders
     - Handles complex numbers, could be useful for rotations and whatnot.

   * updated gradle script for more recent versions
     - still waiting on new Toast version with 2017 WPILib bundled


 -- Cade Brown <cade@cade.site>  2017-01-06 15:58 -500
