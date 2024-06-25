/*Fes un programa que tingui una classe anomenada Clienta, a més a més de la classe que conté el main.

Aquesta classe Clienta tindrà com a atributs el DNI, l'edat, la nacionalitat i nombre de vols agafats.

L'aplicació ha de poder generar Clientes de dues maneres:

• Només a partir del DNI i la Nacionalitat (l'edat per defecte serà 18 anys i el nombre de vols agafats per defecte serà 10).
• Indicant tots els atributs.

La classe Clienta ha de disposar dels següents mètodes:

• mètodes que permetin consultar cadascun dels atributs.
• mètodes que permetin modificar la nacionalitat i l'edat.

• un mètode que calcula la petjada de carboni (multiplicant els viatges per 0,5 tones de CO₂).

• un mètode que retornarà una descripció completa de la clienta (toString()).

Al main del projecte, crea dues clientes de les 2 maneres possibles i
 comprova que els mètodes creats funcionen correctament. És a dir, crida a tots els mètodes amb les dues clientes.
*/
package m8ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class M8Ejercicio1 {

	public static void main(String[] args) {

		ArrayList<Clienta> clientas = new ArrayList<Clienta>();

		Clienta clienta1 = new Clienta("11111111A", 25, "Española", 5);
		Clienta clienta2 = new Clienta("22222222B", "Portuguesa");

		clientas.add(clienta1);
		clientas.add(clienta2);

		introClientas(clientas);

		Clienta clienta = buscarPorDni(clientas);

		if (clienta != null) {
			System.out.println("La huella de carbono de la clienta con dni " + clienta.getDni() + " es: "
					+ clienta.carbonFootprint() + " toneladas de CO2");
		} else {
			System.out.println("No se ha encontrado la clienta.");
		}
	}

	public static void introClientas(ArrayList<Clienta> clientas) {
		Scanner sc = new Scanner(System.in);
		int numClientas;

		System.out.println("¿Cuantas clientas quieres introducir?");
		numClientas = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= numClientas; i++) {
			System.out.println("Introduce los datos de la clienta nº " + i + ":");
			System.out.println("Introduce el DNI de la clienta nº " + i + ":");
			String dni = sc.nextLine();
			System.out.println("Introduce la edad de la clienta nº " + i + ":");
			int edad = sc.nextInt();
			sc.nextLine();
			System.out.println("Introduce la nacionalidad de la clienta nº " + i + ":");
			String nacionalidad = sc.nextLine();
			System.out.println("Introduce los vuelos de la clienta nº " + i + ":");
			int vuelos = sc.nextInt();
			sc.nextLine();
			clientas.add(new Clienta(dni, edad, nacionalidad, vuelos));
		}
	}

	public static Clienta buscarPorDni(ArrayList<Clienta> clientas) {
		String dni;
		Clienta clienta = null;
		int i = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el DNI de la clienta a buscar:");
		dni = sc.nextLine();

		while (clienta == null && i < clientas.size()) {
			if (clientas.get(i).getDni().equalsIgnoreCase(dni)) {
				clienta = clientas.get(i);
			} else {
				i++;
			}
		}

		return clienta;
	}
}
