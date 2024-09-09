package n3Exercise1.vehicles;

public class Plain extends Vehicle {
    static int plain_id = 1;
    
    public Plain() {
        this.type = "Plain";
        this.id = type + "-" + plain_id;
        plain_id++;
    }
}
