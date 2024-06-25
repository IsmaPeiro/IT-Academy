package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class M5Ejercicio5 {

	public static void main(String[] args) {		
		/*
		 * Els estudis lingüístics moderns diuen que les paraules més boniques de
		 * diccionari són aquelles que contenen 9 lletres i comencen per la lletra 'H',
		 * o bé , contenen 5 lletres i comencen per la lletra 'P'. Fes un programa que
		 * demani una paraula i determini si és bonica o no (segons el patró explicat
		 * prèviament). El mètode charAt() segur que et pot ajudar en aquest exercici.
		 * Modifica l'exercici 3 del Mòdul 4. Has de demanar paraules fins que tinguis
		 * tres boniques. Has d'anar guardant les paraules boniques en un array i quan
		 * tinguis les tres, imprimir-les.
		 */
		String palabraIntroducida;
		ArrayList<String> palabras = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduce una palabra:");
			palabraIntroducida = sc.nextLine();

			if ((palabraIntroducida.length() == 5 && palabraIntroducida.toLowerCase().charAt(0) == 'p')
					|| (palabraIntroducida.length() == 9 && palabraIntroducida.toLowerCase().charAt(0) == 'h')) {
				System.out.println(palabraIntroducida + " forma parte de las palabras bonitas");
				palabras.add(palabraIntroducida);
			} else {
				System.out.println(palabraIntroducida + " no forma parte de las palabras bonitas");
			}
		} while (palabras.size() < 3);
		sc.close();

		System.out.println("Las palabras bonitas que has introducido son:");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
	}
}