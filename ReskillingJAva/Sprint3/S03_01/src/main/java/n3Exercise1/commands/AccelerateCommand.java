package n3Exercise1.commands;

import n3Exercise1.vehicles.Vehicle;

public class AccelerateCommand implements Command {
    private Vehicle vehicle;
    
    public AccelerateCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    @Override
    public void execute() {
        System.out.println(vehicle.toString()+", is accelerating.");
    }
}
