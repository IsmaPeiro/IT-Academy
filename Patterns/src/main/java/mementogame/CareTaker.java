package mementogame;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Originator> originators =new ArrayList<>();
    private int index;
    
    public CareTaker() {
        index=0;
    }
    
    public void save(Originator originator) {
        originators.add(originator);
    }
    
    public Originator undo() {
        if (originators.isEmpty() || index == originators.size())
            throw new IndexOutOfBoundsException("no states");
        Originator originator = originators.get(index);
        index++;
        return originator;
    }
    
    public Originator redo () {
        if (originators.isEmpty() || index==0)
            throw new IndexOutOfBoundsException("no states");
        Originator originator = originators.get(index);
        index--;
        return originator;
    }
}
