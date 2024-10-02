package n2Exercise1;

import n2Exercise1.observers.ActiveTrades;
import n2Exercise1.observers.Fpmarkets;
import n2Exercise1.observable.Broker;

public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();
        
        ActiveTrades activeTrades = new ActiveTrades();
        Fpmarkets fpmarkets = new Fpmarkets();
        
        broker.subsctibe(activeTrades);
        broker.subsctibe(fpmarkets);
        
        broker.notifyChanges(+100);
        
        broker.unsubscribe(fpmarkets);
        
        broker.notifyChanges(-10);
    }
}
