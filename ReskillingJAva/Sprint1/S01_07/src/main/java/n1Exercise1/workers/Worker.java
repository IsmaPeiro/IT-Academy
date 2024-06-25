package n1Exercise1.workers;

public class Worker {
    protected String name;
    protected String lastName;
    protected int pricePerHour;
    
    public Worker(String name, String lastName, int pricePerHour) {
        this.name = name;
        this.lastName = lastName;
        this.pricePerHour = pricePerHour;
    }
    
    public Integer calculateSalary (int hours) {
        return this.pricePerHour*hours;
    }
}
