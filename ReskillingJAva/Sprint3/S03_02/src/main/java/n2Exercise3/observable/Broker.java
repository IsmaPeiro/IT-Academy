package n2Exercise3.observable;

import n2Exercise3.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class Broker implements Observable {
    
    List<Observer> observers = new ArrayList<>();
    StockMarket market=new StockMarket("NASDAQ");
    
    @Override
    public void subsctibe(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyChanges(int movement) {
        market.movement(movement);
        for (Observer observer : observers) {
            observer.update("The index of " + market.getName() + " market, has a movement of: " + movement);
        }
    }
}
