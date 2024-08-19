package n1Exercise1;

import java.util.Scanner;

public class Input {
    private Undo undo = Undo.getInstance();
    private Scanner sc = new Scanner(System.in);
    
    public void menu() {
        System.out.println("Input commands or UNDO, REDO, LIST, REMOVE (current command) or EXIT");
        boolean exit = false;
        String cmd = "";
        do {
            cmd = sc.nextLine();
            switch (cmd.toUpperCase()) {
                case "EXIT" -> {
                    System.out.println("Good Bye!");
                    exit = true;
                }
                case "UNDO" -> {
                    undo.undo();
                    System.out.println("Current: " + undo);
                }
                case "REDO" -> {
                    undo.redo();
                    System.out.println("Current: " + undo);
                }
                case "LIST" -> {
                    System.out.println(undo.showAll());
                    System.out.println("Current: " + undo);
                }
                case "REMOVE" -> {
                    undo.removeCommand();
                    System.out.println("Current: " + undo);
                }
                default -> {
                    undo.setCommand(cmd);
                    undo.save();
                    System.out.println("Current: " + undo);
                }
            }
        } while (!exit);
    }
}
