package n3Exercise1.vehicles;

public class Bicycle extends Vehicle {
    static int byclicle_id = 1;
    
    public Bicycle() {
        this.type = "Bicycle";
        this.id = type + "-" + byclicle_id;
        byclicle_id++;
    }
}
