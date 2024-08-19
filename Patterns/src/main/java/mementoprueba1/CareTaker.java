package mementoprueba1;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Originator> originators =new ArrayList<>();
    private int index;
    
    public CareTaker () {
        index=0;
    }
    
    public void save(Originator originator) {
        originators.add(originator);
        index= originators.size()-1;
    }
    
    public Originator remove() {
        originators.remove(index);
        if (!originators.isEmpty() && index > 0) {
            index=originators.size()-1;
        }
        return originators.get(this.index);
    }
    
    public Originator get(int index) {
        return originators.get(index);
    }
    
    public Originator set(int index) {
        this.index=index;
        return originators.get(index);
    }
    
    public Originator undo() throws IndexOutOfBoundsException {
        if (!originators.isEmpty() && index > 0) {index--;}
        Originator originator= originators.get(index);
        return originator;
    }
    
    public Originator redo () {
        if (originators.isEmpty() || index== originators.size()-1)
            throw new IndexOutOfBoundsException("no states");
        index++;
        Originator originator= originators.get(index);
        
        return originator;
    }
    
    public List<Originator> returnAll () {
        return originators;
    }
}
