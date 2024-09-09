package n3Exercise1.vehicles;

public class Vehicle {
    protected String type;
    protected String id;
    
    public Vehicle() {
    }
    
    @Override
    public String toString() {
        return "Vehicle type: " + type + ", id: " + id;
    }
}