package n2Exercise3.observable;

import n2Exercise3.observers.Observer;

public interface Observable {
    void subsctibe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyChanges(int movement);
}
