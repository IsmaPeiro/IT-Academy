package algoritmia;

import java.util.Scanner;

public class M72Ejercicio3 {

	public static void main(String[] args) {
		/*
		 * Fes un programa que mostri el següent per pantalla:
		 *		 * * * * * *
		 * 		 * * * * *
		 *		 * * * *
		 * 		 * * *
		 * 		 * *
		 * 		 * 
		 * El nombre de línies formades per “*” vindrà donat per un número que l’usuari/ària introduirà per consola.
		 * Condició: En tot el codi del programa només hi pot haver un *
		 * També, a poder ser, no utilitzis cap mètode com repeat() o substring() de la classe String.
		 * 
		 */
		drawTree(numLines());
	}
	
	public static int numLines () {
		Scanner sc=new Scanner(System.in);
		int lines;
		System.out.println("introdice el número de líneas:");
		do {
			lines=sc.nextInt();
			if (lines<0) {
				System.out.println("Has de introducir un número positivo");
			}
		} while (lines<0);
		return lines;
	}
	
	public static void drawTree (int numLines) {
		for (int i=numLines;i>0;i--) {
			for (int z=0;z<i;z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}	
}