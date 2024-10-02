package n2Exercise1.observers;

public class ActiveTrades extends StockAgency implements Observer {
    public ActiveTrades() {
        this.name="Activetrades";
    }
    
    @Override
    public void update(String message) {
        System.out.println(getName() + " has received the following message: '" + message + "', and will act accordingly");
    }
}
