package algoritmia;

import java.util.Scanner;

public class M4Ejercicio1 {

	public static void main(String[] args) {
		/* Crea un programa que sol·liciti a l'usuari/ària
		 * que introdueixi dos nombres enters per teclat
		 * i mostri per pantalla el major dels dos.
		 */
		
		int num1;
		int num2;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce dos números enteros");
		System.out.println("Primer número:");

		num1 = sc.nextInt();

		System.out.println("Segundo número:");

		num2 = sc.nextInt();

		sc.close();

		if (num1 > num2) {
			System.out.println("El número más grande es:" + num1);
		} else if (num1 < num2) {
			System.out.println("El número más grande es:" + num2);
		} else {
			System.out.println("Los dos números son iguales");
		}

	}

}
