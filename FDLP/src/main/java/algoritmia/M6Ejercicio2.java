package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class M6Ejercicio2 {

	public static void main(String[] args) {
		/*
		 * Crea un programa que sol·liciti a l'usuari/ària quants noms desitja
		 * introduir. Una vegada tenim aquest número, demanarem a l'usuari/ària tants
		 * noms de persona com ha dit prèviament i els emmagatzemarem en un ArrayList.
		 * Després, mostrarem per pantalla només els noms que comencen per la lletra
		 * “A”. 
		 * Modifica l'exercici 1 del mòdul 5 i ara fes-ho amb mètodes.
		 */
		
		int numero = introducirNumeroNombres();		
		ArrayList<String> nombres = introducirNombres(numero);
		comprobarNombresConA(nombres);
	}

	static int introducirNumeroNombres() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos nombres quieres introducir?");
		int numero = sc.nextInt();		
		return numero;
	}

	static ArrayList<String> introducirNombres(int numero) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nombres = new ArrayList<String>();
		for (int i = 0; i < numero; i++) {
			System.out.println("introduce el nombre " + (i + 1) + ":");
			nombres.add(sc.nextLine());
		}		
		return nombres;
	}

	static void comprobarNombresConA(ArrayList<String> nombres) {
		System.out.println("Nombres introducidos que empiezan por a:");

		for (int i = 0; i < nombres.size(); i++) {
			String nombre = nombres.get(i);
			if (nombre.toLowerCase().charAt(0) == 'a') {
				System.out.println(nombre);
			}
		}
	}
}