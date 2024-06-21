package n2Exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    public static byte readByte(String message) {
        boolean exit = false;
        byte result = 0;

        do {
            System.out.println(message);
            try {
                result = sc.nextByte();
                exit = true;
            } catch (InputMismatchException e) {
                System.err.println("Format error.");
            } finally {
                sc.nextLine();
            }
        } while (!exit);
        return result;
    }

    public static int readInt(String message) {
        boolean exit = false;
        int result = 0;

        do {
            System.out.println(message);
            try {
                result = sc.nextInt();
                exit = true;
            } catch (InputMismatchException e) {
                System.err.println("Format Error.");
            } finally {
                sc.nextLine();
            }
        } while (!exit);
        return result;
    }

    public static float readFloat(String message) {
        boolean exit = false;
        float result = 0;

        do {
            System.out.println(message);
            try {
                result = sc.nextFloat();
                exit = true;
            } catch (InputMismatchException e) {
                System.err.println("Format Error");
            } finally {
                sc.nextLine();
            }
        } while (!exit);
        return result;
    }


    public static double readDouble(String message) {
        boolean exit = false;
        double result = 0;

        do {
            System.out.println(message);
            try {
                result = sc.nextDouble();
                exit = true;
            } catch (InputMismatchException e) {
                System.err.println("Format Error");
            } finally {
                sc.nextLine();
            }
        } while (!exit);
        return result;
    }

    public static char readChar(String message) {
        boolean exit = false;
        String result = "";

        do {
            System.out.println(message);
            try {
                result = sc.next();
                if (result.length() != 1) {
                    throw new Exception();
                } else {
                    exit = true;
                }
            } catch (Exception e) {
                System.err.println("Format Error");
            } finally {
                sc.nextLine();
            }
        } while (!exit);
        return result.charAt(0);
    }

    public static String readString(String message) {
        boolean exit = false;
        String result = "";

        do {
            System.out.println(message);
            try {
                result = sc.nextLine();
                exit = true; //que no lea nums
            } catch (Exception e) {
                System.err.println("Format Error");
            }
        } while (!exit);
        return result;
    }


    public static boolean readYesNo(String message) {
        boolean exit = false;
        boolean result = true;
        String yesNo = "";

        do {
            System.out.println(message);
            try {
                yesNo = sc.next();
                if (yesNo.matches("[Yy]")) {
                    result = true;
                    exit = true;
                } else if (yesNo.matches("[Nn]")) {
                    result = false;
                    exit = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Format Error");
            }
        } while (!exit);
        return result;
    }
}






