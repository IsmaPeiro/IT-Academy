package n3Exercise1;

import n3Exercise1.commands.AccelerateCommand;
import n3Exercise1.commands.BrakeCommand;
import n3Exercise1.commands.Invoker;
import n3Exercise1.commands.StartCommand;
import n3Exercise1.vehicles.Bicycle;
import n3Exercise1.vehicles.Boat;
import n3Exercise1.vehicles.Car;
import n3Exercise1.vehicles.Plane;

public class Parking {
    public static void test () {
        Invoker invoker=new Invoker();
        Car car=new Car();
        Boat boat=new Boat();
        Bicycle bike=new Bicycle();
        Plane plane =new Plane();
        
        invoker.inputCommands(new StartCommand(car));
        invoker.inputCommands(new AccelerateCommand(car));
        invoker.inputCommands(new BrakeCommand(car));
        invoker.inputCommands(new StartCommand(boat));
        invoker.inputCommands(new AccelerateCommand(boat));
        invoker.inputCommands(new BrakeCommand(boat));
        invoker.inputCommands(new StartCommand(bike));
        invoker.inputCommands(new AccelerateCommand(bike));
        invoker.inputCommands(new BrakeCommand(bike));
        invoker.inputCommands(new StartCommand(plane));
        invoker.inputCommands(new AccelerateCommand(plane));
        invoker.inputCommands(new BrakeCommand(plane));
        
        invoker.executeCommands();
    }
}
