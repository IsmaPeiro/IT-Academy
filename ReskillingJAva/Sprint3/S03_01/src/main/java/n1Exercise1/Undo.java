package n1Exercise1;
//Memento & Singleton

public class Undo {
    private String command;
    private static UndoManager undoManager = new UndoManager();
    private static Undo instance;
    
    private Undo() {
    }
    
    private Undo(String command) {
        this.command = command;
    }
    
    public static Undo getInstance(String command) {
        if (instance == null) {
            instance = new Undo(command);
        }
        return instance;
    }
    
    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }
    
    public void setCommand(String command) {
        this.command = command;
    }
    
    public String getCommand() {
        return command;
    }
    
    public void save (){
        undoManager.add(new UndoOriginator(this));
    }
    
    public void undo () {
        try {
            UndoOriginator undoOriginator = undoManager.back();
            setCommand(undoOriginator.getCommand());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No more commands to undo");
        }
    }
    
    public void redo () {
        try {
            UndoOriginator undoOriginator = undoManager.forward();
            setCommand(undoOriginator.getCommand());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No more commands to redo");
        }
    }
    
    public void removeCommand () {
        try {
            UndoOriginator undoOriginator = undoManager.remove();
            setCommand(undoOriginator.getCommand());
        } catch (IndexOutOfBoundsException e) {
            setCommand(null);
            System.out.println("No more commands to remove");
        }
    }
    
    public String showAll () {
        String result="";
        if (undoManager.returnAll().isEmpty()) {
            result="No commands in list";
        } else {
            for (UndoOriginator o : undoManager.returnAll()) {
                result +=o.toString()+"\n";
            }
        }
        
        return result;
    }
    
    @Override
    public String toString() {
        return "command = " + command;
    }
}
