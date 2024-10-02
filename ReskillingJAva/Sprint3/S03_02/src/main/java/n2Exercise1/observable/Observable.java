package n2Exercise1.observable;

import n2Exercise1.observers.Observer;

public interface Observable {
    void subsctibe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyChanges(int movement);
}
