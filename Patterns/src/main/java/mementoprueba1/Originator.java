package mementoprueba1;

public class Originator {
    private String state;
    
    public Originator(Memento memento) {
        state= memento.getState();
    }
    
    public void setState (Memento memento) {
        this.state=memento.getState();
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "state = "+state;
    }
}
