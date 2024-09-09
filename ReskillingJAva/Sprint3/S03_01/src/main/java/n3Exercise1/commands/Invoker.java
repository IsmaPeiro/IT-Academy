package n3Exercise1.commands;

import java.util.ArrayList;
import java.util.Stack;

public class Invoker {
    
    private Stack<Command> commands=new Stack<>();
    
    public void inputCommands (Command command) {
        commands.push(command);
    }
    
    public void executeCommands() {
        commands.forEach(c->c.execute());
    }
}
