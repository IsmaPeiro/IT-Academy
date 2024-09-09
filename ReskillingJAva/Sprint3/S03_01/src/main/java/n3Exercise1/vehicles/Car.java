package n3Exercise1.vehicles;

public class Car extends Vehicle {
    static int car_id = 1;
    
    public Car() {
        this.type = "Car";
        this.id = type + "-" + car_id;
        car_id++;
    }
}
