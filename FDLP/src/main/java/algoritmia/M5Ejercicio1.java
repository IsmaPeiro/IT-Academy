package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class M5Ejercicio1 {

	public static void main(String[] args) {
		/*
		 * Crea un programa que sol·liciti a l'usuari/ària quants noms desitja
		 * introduir. Una vegada tenim aquest número, demanarem a l'usuari/ària tants
		 * noms de persona com ha dit prèviament i els emmagatzemarem en un ArrayList.
		 * Després, mostrarem per pantalla només els noms que comencen per la lletra
		 * “A”.
		 */
		ArrayList<String> nombres=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		int numeroNombres;
		String nombre;
		
		System.out.println("Cuantos nombres quieres introducir?");
		numeroNombres=sc.nextInt();
		sc.nextLine();
		for (int i=0;i<numeroNombres;i++) {
			System.out.println("introduce un nombre:");
			nombres.add(sc.nextLine());
		}
		
		sc.close();
		
		System.out.println("Nombres introducidos que empiezan por a:");
		
		for (int i=0; i<nombres.size();i++) {
			nombre=nombres.get(i);
			if (nombre.toLowerCase().charAt(0)=='a') {
				System.out.println(nombre);
			}
		}
	}

}
