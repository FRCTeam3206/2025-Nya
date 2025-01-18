/*if you turn on debug mode on the robot itll show you more info but otherwise its quiet*/
package frc.robot;

public class Debug {
    public void trace(String string) {
        /*it says dead code but thats just cause its in normal mode right now*/
        if (Constants.runtimeMode == "DEBUG") {
            System.out.println("[2025 Nya] " + string);
        }
    }
}
