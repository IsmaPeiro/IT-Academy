package algoritmia;

import java.util.Scanner;

public class M4Ejercicio2 {

	public static void main(String[] args) {
		/* Crea un programa que sol·liciti a l'usuari que introdueixi el
		 * seu nom i el nombre d'anys que porta treballant en una empresa
		 * per teclat i mostri per pantalla el seu nivell salarial,
		 * segons la següent taula:
		 * Menys de 2 anys - 25.000 €
		 * Entre 2 i 4 anys 35.000 €
		 * Més de 4 i fins a 7 anys 50.000 €
		 * Més de 7 i fins a 10 anys 65.000 €
		 * Més de 10 anys 80.000 €
		 */

		String nombre;
		int years;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce tu nombre:");
		nombre = sc.nextLine();

		System.out.println("Introduce los años que llevas trabajando en la empresa:");
		years = sc.nextInt();

		sc.close();

		if (years < 2) {
			System.out.println(nombre + ", tu nivel salarial es de 25000 €");
		} else if (years <= 4) {
			System.out.println(nombre + ", tu nivel salarial es de 35000 €");
		} else if (years <= 7) {
			System.out.println(nombre + ", tu nivel salarial es de 50000 €");
		} else if (years <= 10) {
			System.out.println(nombre + ", tu nivel salarial es de 65000 €");
		} else {
			System.out.println(nombre + ", tu nivel salarial es de 80000 €");
		}

	}

}
