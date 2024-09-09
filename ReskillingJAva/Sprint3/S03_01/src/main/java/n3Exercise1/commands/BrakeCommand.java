package n3Exercise1.commands;

import n3Exercise1.vehicles.Vehicle;

public class BrakeCommand implements Command {
    private Vehicle vehicle;
    
    public BrakeCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    @Override
    public void execute() {
        System.out.println(vehicle.toString()+", is braking.");
    }
}
