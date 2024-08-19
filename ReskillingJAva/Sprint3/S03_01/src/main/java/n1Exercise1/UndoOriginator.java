package n1Exercise1;
//Originator

public class UndoOriginator {
    private String command;
    
    public UndoOriginator(Undo undo) {
        command = undo.getCommand();
    }
    
    public void setCommand(Undo undo) {
        this.command = undo.getCommand();
    }
    
    public String getCommand() {
        return command;
    }
    
    public void setState(String state) {
        this.command = state;
    }
    
    @Override
    public String toString() {
        return "command = " + command;
    }
}
