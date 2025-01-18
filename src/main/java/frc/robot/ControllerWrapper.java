/*makes it so you can use joysticks and controllers as the same and connect it to the same callback
Dont work yet but it will soon...
https://docs.wpilib.org/en/stable/docs/software/basic-programming/joystick.html */
package frc.robot;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.ButtonCallback;

public class ControllerWrapper {
    private static int HOW_MANY_CALLBACKS_CAN_YOU_HAVE_AT_ONCE_LIKE_THE_MAXIMUM_AMOUNT_BASICALLY = 50;
    public ButtonCallback[] callbacks = new ButtonCallback[HOW_MANY_CALLBACKS_CAN_YOU_HAVE_AT_ONCE_LIKE_THE_MAXIMUM_AMOUNT_BASICALLY];
    public void addCallback(String id, Function callback) {
        for (ButtonCallback thingy : callbacks) {
            if (callback.id == thingy.id) {
                trace("Callback for " + callback.id + " already exists, adding to it...");
            }
        }
    }
}
