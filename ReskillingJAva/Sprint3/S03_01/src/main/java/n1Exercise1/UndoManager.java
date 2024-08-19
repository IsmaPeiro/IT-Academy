package n1Exercise1;
//CareTaker

import java.util.ArrayList;
import java.util.List;

public class UndoManager {
    private List<UndoOriginator> undoOriginators = new ArrayList<>();
    private int index;
    
    public UndoManager() {
        index=0;
    }
    
    public void add (UndoOriginator undoOriginator) {
        if (index>= undoOriginators.size()) {
            index=undoOriginators.size()-1;
        } else if (index < 0) {
            index=0;
        }
        if (index== undoOriginators.size()-1) {
            undoOriginators.add(undoOriginator);
            index = undoOriginators.size()-1;
        } else {
            undoOriginators.add(index, undoOriginator);
        }
    }
    
    public UndoOriginator remove () {
        undoOriginators.remove(index);
        if (index==-1) {
            index=0;
        } else if (index== undoOriginators.size()) {
            index--;
        }
        System.out.println ("command removed");
        return undoOriginators.get (this.index);
    }
    
    public UndoOriginator back() {
        if (index>= undoOriginators.size()) {
            index=undoOriginators.size()-1;
        }
        index--;
        UndoOriginator undoOriginator = undoOriginators.get(index);
        return undoOriginator;
    }
    
    public UndoOriginator forward() {
        if (index < 0) {
            index=0;
        }
        index++;
        UndoOriginator undoOriginator = undoOriginators.get(index);
        return undoOriginator;
    }
    
    public List<UndoOriginator> returnAll () {
        return undoOriginators;
    }
}
