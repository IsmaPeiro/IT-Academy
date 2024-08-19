package mementoprueba1;


import java.util.List;

public class Memento {
    private String state;
    private static CareTaker careTaker = new CareTaker();
    
    public Memento() {
    }
    
    public Memento(String state) {
        this.state = state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public void save() {
        careTaker.save(new Originator(this));
    }
    
    public void back() {
        try {
            Originator originator = careTaker.undo();
            setState(originator.getState());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void forward() {
        Originator originator = careTaker.redo();
        setState(originator.getState());
    }
    
    public Originator getPosition (int index) {
        Originator originator=careTaker.get(index);
        return originator;
    }
    
    public void setPosition (int index) {
        Originator originator=careTaker.set(index);
        setState(originator.getState());
    }
    
    public void removePosition () {
        try {
            Originator originator=careTaker.remove();
            setState(originator.getState());
        } catch (IndexOutOfBoundsException e) {
            setState(null);
            System.out.println(e.getMessage());
        }
        
    }
    
    public List<Originator> showAll () {
        return careTaker.returnAll();
    }
    
    @Override
    public String toString() {
        return "state = "+state;
    }
}
