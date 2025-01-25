package frc.robot.subsystems;

//idk what motor were gonna use im just gonna guess spark cause I Dont Know What That Is
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.simulation.ElevatorSim;
import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.system.plant.DCMotor;

import frc.robot.Constants;

public class Elevator extends SubsystemBase {
    //two motors they should move at the same time and speed but different directions
    //I dont know what a spark motor is or if we have it im just gonna assume we have it
    private final Spark leftMotor = new Spark(Constants.ElevatorConstants.kLeftPort);
    private final Spark rightMotor = new Spark(Constants.ElevatorConstants.kRightPort);
    //Simulation needs a dc motor for some reason
    //i dont know what torque is so im gonna say 0
    private final DCMotor dcMotor = new DCMotor(Constants.ElevatorConstants.kVoltage, 
        0,
        0,
        0,
        0, 
        Constants.ElevatorConstants.kMotorsInGearbox
    );
    private final LinearSystem imaginaryElevator = LinearSystemId.createElevatorSystem(
        null, 
        0, 
        0,
        0
    );
    private final Spark[] motors = {leftMotor, rightMotor};
    private final ElevatorSim simulated = new ElevatorSim(
        imaginaryElevator,
        dcMotor,
        Constants.ElevatorConstants.kBottomHeight,
        Constants.ElevatorConstants.kTopHeight,
        true,
        //assuming it starts at the bottom
        Constants.ElevatorConstants.kBottomHeight,
        0
    );
    private final double speed = Constants.ElevatorConstants.kMotorSpeed;
    /*private final Odometry odometry = new Odometry<>(null, null, leftMotor, null);
    imma do this later not yet*/
    public Elevator() {
        for (Spark motor : motors) {
            motor.setVoltage(Constants.ElevatorConstants.kVoltage);
        }
        simulated.setInputVoltage(Constants.ElevatorConstants.kVoltage);
    }
    public void up() {
        rightMotor.set(speed);
        //Eat Sleep Fortnite Repeat
        leftMotor.set(-speed);
    }
    public void down() {
        rightMotor.set(-speed);
        leftMotor.set(speed);
    }
    public void stop() {
        for (Spark motor : motors) {
            //uhuhuhuh i am the best and youre the worst i am the best and youre the uh uhuhh i wanna go home  i wanna go home i keep hearin ght the voices inside my head i wanna go home then finish the job!!!!!
            //look up ena temptation stairway
            motor.stopMotor();
        }
    }
    public void periodic() {
        if (simulated.hasHitLowerLimit() || simulated.hasHitUpperLimit()) {
            stop();
        }
    }
}
