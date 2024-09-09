package n3Exercise1.vehicles;

public class Boat extends Vehicle {
    static int boat_id = 1;
    
    public Boat() {
        this.type = "Boat";
        this.id = type + "-" + boat_id;
        boat_id++;
    }
}
