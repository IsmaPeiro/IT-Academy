package n3Exercise1.commands;

import n3Exercise1.vehicles.Vehicle;

public class StartCommand implements Command {
    private Vehicle vehicle;
    
    public StartCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    @Override
    public void execute() {
        System.out.println(vehicle.toString()+", started the engine.");
    }
}
