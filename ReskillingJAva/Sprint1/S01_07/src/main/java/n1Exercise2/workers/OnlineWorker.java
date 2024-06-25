package n1Exercise2.workers;

public class OnlineWorker extends Worker {
    final static int INTERNET_FLAT_RATE=30;
    public OnlineWorker(String name, String lastName, int pricePerHour) {
        super(name, lastName, pricePerHour);
    }
    
    @Override
    public Integer calculateSalary(int hours) {
        return super.calculateSalary(hours)+INTERNET_FLAT_RATE;
    }
    
    @Deprecated
    public Integer returnSalary (int hours) {
        return pricePerHour*hours;
    }
}
