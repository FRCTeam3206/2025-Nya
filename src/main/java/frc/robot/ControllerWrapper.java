/*makes it so you can use joysticks and controllers as the same and connect it to the same callback
Dont work yet but it will soon...
https://docs.wpilib.org/en/stable/docs/software/basic-programming/joystick.html 
https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/GenericHID.html
*/
package frc.robot;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.Debug;

import java.lang.reflect.Method;
import java.util.ArrayList;

public interface Thingy {
    //wtf if this
    void doTheThing();
}

public class ControllerWrapper extends XboxController {
    public ArrayList<Thingy> poop = new ArrayList<Thingy>();
    public Method thingToListenFor;
    public ControllerWrapper() {
        super(Constants.OIConstants.kDriverControllerPort);
        Debug.trace("Making new ControllerWrapper " + this);
    }
    //erm what the jsdoc
    /**
     * @param id nickname of the callback for traces and errors
     * @param upOrDown add the event listner on button "up", or "down"
     * @param callback the function 
     */
    public void addButtonListener(String name, String whichButton, String upOrDown, Thingy callback) {
        switch (whichButton) {
            case "xbox.a": thingToListenFor = this.getAButton(); break;
            default:
                throw new Error("Button " + whichButton + " doesn't exist")
        }
    }
    private boolean checkIfTheThingyHappened() {
        return thingToListenFor;
    }
}
