package n2Exercise3;

import n2Exercise3.observable.Broker;
import n2Exercise3.observers.ActiveTrades;
import n2Exercise3.observers.Fpmarkets;

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
