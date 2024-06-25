package n1Ejercicio5;

import java.util.Scanner;

public class Select {
    static void init(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "-d" -> {
                    String[] copyArgs = new String[args.length - 1];
                    System.arraycopy(args, 1, copyArgs, 0, args.length - 1);
                    n1Ejercicio2.ShowDirTree.init(copyArgs);
                }
                case "-s" -> {
                    String[] copyArgs = new String[args.length - 1];
                    System.arraycopy(args, 1, copyArgs, 0, args.length - 1);
                    n1Ejercicio3.SaveDirTree.init(copyArgs);
                }
                case "-r" -> {
                    String[] copyArgs = new String[args.length - 1];
                    System.arraycopy(args, 1, copyArgs, 0, args.length - 1);
                    n1Ejercicio4.ReadTxt.init(copyArgs);
                }
                case "-ser", "-dser" -> {
                    String[] copyArgs = new String[args.length - 1];
                    System.arraycopy(args, 1, copyArgs, 0, args.length - 1);
                    Serializate.init(args[0], copyArgs);
                }
                default -> System.out.println("Incorrect parameters.");
            }
        } else {
            menu(args);
        }
    }
    
    private static void menu(String[] args) {
        int option = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("¿What do you want to do?\n");
            System.out.println("1. Show DirTree | 2. SaveDirTree | 3. Read Txt | 4. Serialize | 5. Deserialize | 0. Exit");
            if (sc.hasNextByte()) option = sc.nextByte();
            sc.nextLine();
            if (option > 5 || option < 0) System.out.println("Chose Valid Option.");
        } while (option > 5 || option < 0);
        
        switch (option) {
            case 1 -> n1Ejercicio2.ShowDirTree.init(args);
            case 2 -> n1Ejercicio3.SaveDirTree.init(args);
            case 3 -> n1Ejercicio4.ReadTxt.init(args);
            case 4 -> Serializate.init("-ser", args);
            case 5 -> Serializate.init("-dser", args);
            case 0 -> System.out.println("Thank you for use the application.");
        }
    }
}
