package n1Exercise3;

import java.util.Scanner;

public class Select {
    static void init(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "-d" -> {
                    String[] copyArgs = new String[args.length - 1];
                    System.arraycopy(args, 1, copyArgs, 0, args.length - 1);
                    n1Exercise2.ShowDirTree.init(copyArgs);
                }
                case "-s" -> {String[] copyArgs = new String[args.length - 1];
                    System.arraycopy(args, 1, copyArgs, 0, args.length - 1);
                    SaveDirTree.init(copyArgs);
                }
                default -> System.out.println("Incorrect parameters.");
            }
        } else {
            menu(args);
        }
    }
    
    private static void menu (String[] args) {
        int option = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("¿What do you want to do?\n");
            System.out.println("1. Show DirTree | 2. SaveDirTree | 0. Exit");
            if (sc.hasNextByte()) option = sc.nextByte();
            sc.nextLine();
            if (option > 2 || option < 0) System.out.println("Chose Valid Option.");
        } while (option > 2 || option < 0);
        
        switch (option) {
            case 1 -> n1Exercise2.ShowDirTree.init(args);
            case 2 -> SaveDirTree.init(args);
            case 0 -> System.out.println("Thank you for use the application.");
        }
    }
}
