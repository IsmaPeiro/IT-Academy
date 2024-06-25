package n3Ejercicio1;

import java.util.Scanner;

public class Select {
    static void init(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "-enc", "-dec" -> {
                    String[] copyArgs = new String[args.length - 1];
                    System.arraycopy(args, 1, copyArgs, 0, args.length - 1);
                    Encryption.init(args[0], copyArgs);
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
            System.out.println("1. Encrypt file | 2. Decrypt file | 0. Exit");
            if (sc.hasNextByte()) option = sc.nextByte();
            sc.nextLine();
            if (option > 2 || option < 0) System.out.println("Chose Valid Option.");
        } while (option > 2 || option < 0);
        
        switch (option) {
            case 1 -> Encryption.init("-enc", args);
            case 2 -> Encryption.init("-dec", args);
            case 0 -> System.out.println("Thank you for use the application.");
        }
    }
}
