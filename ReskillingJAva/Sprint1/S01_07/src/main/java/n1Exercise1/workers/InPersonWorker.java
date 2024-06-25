package n1Exercise1.workers;

public class InPersonWorker extends Worker {
    static int fuel=50;
    
    public InPersonWorker(String name, String lastName, int pricePerHour) {
        super(name, lastName, pricePerHour);
    }
    
    @Override
    public Integer calculateSalary(int hours) {
        return super.calculateSalary(hours)+fuel;
    }
}
