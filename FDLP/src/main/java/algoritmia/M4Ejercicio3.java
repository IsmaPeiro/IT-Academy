package algoritmia;

import java.util.Scanner;

public class M4Ejercicio3 {

	public static void main(String[] args) {
		/* Els estudis lingüístics moderns diuen que les paraules
		 * més boniques de diccionari són aquelles que contenen 9 lletres
		 * i comencen per la lletra 'H', o bé ,
		 * contenen 5 lletres i comencen per la lletra 'P'.
		 * Fes un programa que demani una paraula i determini
		 * si és bonica o no (segons el patró explicat prèviament).
		 * El mètode charAt() segur que et pot ajudar en aquest exercici.
		 */
		String palabra;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce una palabra:");
		palabra = sc.nextLine();

		sc.close();

		if (palabra.length() == 5 && palabra.toLowerCase().charAt(0) == 'p') {
			System.out.println(palabra + " forma parte de las palabras bonitas");
		} else if (palabra.length() == 9 && palabra.toLowerCase().charAt(0) == 'h') {
			System.out.println(palabra + " forma parte de las palabras bonitas");
		} else {
			System.out.println(palabra + " no forma parte de las palabras bonitas");
		}
	}
}
