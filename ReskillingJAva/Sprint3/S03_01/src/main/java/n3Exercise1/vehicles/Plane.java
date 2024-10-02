package n3Exercise1.vehicles;

public class Plane extends Vehicle {
    static int plain_id = 1;
    
    public Plane() {
        this.type = "Plane";
        this.id = type + "-" + plain_id;
        plain_id++;
    }
}
