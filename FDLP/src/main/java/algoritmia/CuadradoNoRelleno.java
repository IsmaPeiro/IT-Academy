package algoritmia;

import java.util.Scanner;

public class CuadradoNoRelleno {
    public static void main(String[] args) {
        //escribe aquí tu código
        int maxPar=0;
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Introduzca un número par:");
        do {

            if (sc.hasNextInt()) {
                maxPar = sc.nextInt();
                if (maxPar % 2 == 0) {
                    exit = true;
                }
            }
            if (!exit) {
                System.out.println("Introduzca un número par.");
                sc.nextLine();
            }
        } while (!exit);

        while (sc.hasNextInt()) {
            int num=sc.nextInt();
            if (num%2==0&&num>maxPar) {
                maxPar=num;
            }
        }
        System.out.println(maxPar);

    }
}