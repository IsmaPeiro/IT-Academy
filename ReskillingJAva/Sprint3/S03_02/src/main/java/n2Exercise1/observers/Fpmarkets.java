package n2Exercise1.observers;

public class Fpmarkets extends StockAgency implements Observer {
    public Fpmarkets() {
        this.name = "Fpmarkets";
    }
    
    @Override
    public void update(String message) {
        System.out.println(getName() + " has received the following message: '" + message + "', and will act accordingly");
    }
}
