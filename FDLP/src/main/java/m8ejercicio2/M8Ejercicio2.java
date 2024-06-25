/*
		 * Fes un programa que permeti donar d'alta, modificar, veure i eliminar vols.
		 * La classe vol tindre els atributs: distància (en km), número de vol,
		 * companyia, nombre de passatgers, nombre de motors. També haurà de contenir un
		 * constructor complet i els getters i setters necessaris. Finalment, la classe
		 * vol tindre un mètode calculaPetjadaCarboni() que ha de calcular el CO₂ emès
		 * per l'avió tenint en compte que cada motor allibera 0,1 tones de CO₂ cada
		 * 1000 km de distància. Les funcionalitats del programa seran les següents:
		 * 
		 * Elmètode crearVol() haurà de rebre les dades per crear un vol i afegir-lo a
		 * un array de vols.
		 * 
		 * El mètode donarDeBaixaVol() haurà de rebre el número de vol que es vol donar
		 * de baixa. Si el vol està dintre de l'array, l'eliminarem i mostrarem un
		 * missatge informatiu per pantalla, si no, avisarem per pantalla que el vol no
		 * es troba a la nostra aplicació.
		 *
		 * El mètode veureVol() haurà de rebre el número de vol que es vol mostrar. Si
		 * el vol està dintre de l'array, mostrarem tots els seus atributs i també
		 * cridarem al
		 * 
		 * mètode calculaPetjadaCarboni(), si no, avisarem per pantalla que el vol no es
		 * troba a la nostra aplicació.
		 * 
		 * El mètode modificarVol() haurà de rebre el número de vol que es vol
		 * modificar. Si el vol està dintre de l'array, demanarem quin atribut es vol
		 * modificar, farem la modificació pertinent i mostrarem un missatge informatiu
		 * per pantalla. Si no, avisarem per pantalla que el vol no es troba a la nostra
		 * aplicació.
		 */
package m8ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class M8Ejercicio2 {

	public static void main(String[] args) {
		
		ArrayList<Flight> flights = new ArrayList<Flight>();
		boolean exit = false;
		
		//String flightNumber, String company, int passangers, double distance, int engines
		Flight flight1 = new Flight ("111AA", "Iberia", 200, 1000, 2);
		Flight flight2 = new Flight ("222BB", "Vueling", 250, 2000, 4);
		Flight flight3 = new Flight ("333CC", "TWA", 175, 1500, 3);
		
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
		
		do {
			switch (menu()) {
			case 1:
				createFlight(flights);
				break;
			case 2:
				deleteFlight(flights);
				break;
			case 3:
				showFlight(flights);
				break;
			case 4:
				carbonFootPrint(flights);
				break;
			case 5:
				modifyFlight(flights);
				break;
			case 6:
				showAllFlights(flights);
				break;
			case 0:
				System.out.println("Gracias por usar la aplicación.");
				exit = true;
				break;
			}
		} while (!exit);
	}

	public static byte menu() {
		Scanner sc = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 6;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("1. Crear Vuelo.");
			System.out.println("2. Eliminar vuelo.");
			System.out.println("3. Ver vuelo.");
			System.out.println("4. Calcular huella de Carbono.");
			System.out.println("5. Modificar vuelo.");
			System.out.println("6. Mostrar todos los vuelos.");
			System.out.println("0. Salir de la aplicación.\n");
			opcio = sc.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escoge una opción válida.");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static void createFlight(ArrayList<Flight> flights) {
		Scanner sc = new Scanner(System.in);
		Flight duplicateFlight = null;		

		System.out.println("introduce el número de vuelo:");
		String flightNumber = sc.nextLine();
		duplicateFlight = selectFlight(flights, flightNumber);
		if (duplicateFlight == null) {
			System.out.println("Introduce la compañía:");
			String company = sc.nextLine();
			System.out.println("Introduce el número de pasajeros:");
			int passangers = sc.nextInt();			
			System.out.println("Introduce la distanciia en Km.:");
			double distance = sc.nextDouble();
			System.out.println("Introduce el número de motores.:");
			int engines = sc.nextInt();
			flights.add(new Flight(flightNumber, company, passangers, distance, engines));
			System.out.println("Vuelo creado correctamente.");
		} else {
			System.out.println("Este vuelo ya existe.");
		}		
	}

	public static void deleteFlight(ArrayList<Flight> flights) {
		Scanner sc = new Scanner(System.in);

		System.out.println("introduce el número de vuelo:");
		String flightNumber = sc.nextLine();
		Flight flight = selectFlight(flights, flightNumber);
		if (flight != null) {
			flights.remove(flight);
			System.out.println("Vuelo eliminado correctamente.");
		} else {
			System.out.println("No existe este vuelo.");
		}
	}

	public static void showFlight(ArrayList<Flight> flights) {
		Scanner sc = new Scanner(System.in);

		System.out.println("introduce el número de vuelo:");
		String flightNumber = sc.nextLine();
		Flight flight = selectFlight(flights, flightNumber);
		if (flight != null) {
			System.out.println(flight.toString());
		} else {
			System.out.println("No existe este vuelo.");
		}
	}

	public static void carbonFootPrint(ArrayList<Flight> flights) {
		Scanner sc = new Scanner(System.in);

		System.out.println("introduce el número de vuelo:");
		String flightNumber = sc.nextLine();
		Flight flight = selectFlight(flights, flightNumber);
		if (flight != null) {
			System.out.println("La huella de Carbono de este vuelo es: " + flight.carbonFootPrint() + " toneladas de CO2");
		} else {
			System.out.println("No existe este vuelo.");
		}
	}

	public static void modifyFlight(ArrayList<Flight> flights) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;

		System.out.println("introduce el número de vuelo:");
		String flightNumber = sc.nextLine();
		Flight flight = selectFlight(flights, flightNumber);

		if (flight != null) {
			do {
				switch (modifyFlightMenu()) {
				case 1:
					System.out.println("introduce el nombre de la nueva compañía:");
					flight.setCompany(sc.nextLine());
					System.out.println("Compañía modificada correctamente.");
					break;
				case 2:
					System.out.println("introduce la nueva distancia del vuelo:");
					flight.setDistance(sc.nextDouble());
					sc.nextLine();
					System.out.println("Distanciamodificada correctamente.");
					break;
				case 3:
					System.out.println("introduce el nuevo número de pasajeros:");
					flight.setPassangers(sc.nextInt());
					sc.nextLine();
					System.out.println("Pasajeros modificados correctamente.");
					break;
				case 4:
					System.out.println("introduce el nuevo número de motores:");
					flight.setEngines(sc.nextInt());
					sc.nextLine();
					System.out.println("Motores modificados correctamente.");
					break;
				case 0:
					exit = true;
					break;
				}
			} while (!exit);
		} else {
			System.out.println("No existe este vuelo.");
		}
	}

	public static byte modifyFlightMenu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 4;

		do {
			System.out.println("¿Qué quieres modificar?");
			System.out.println("1. Compañía del vuelo.");
			System.out.println("2. Distancia del vuelo.");
			System.out.println("3. Número de Pasajeros.");
			System.out.println("4. Número de motores.");
			System.out.println("0. Nada, gracias.\n");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escoge una opción válida.");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static void showAllFlights(ArrayList<Flight> flights) {
		if (flights.isEmpty()) {
			System.out.println("No hay vuelos introducidos.");
		} else {
			for (Flight flight : flights) {
				System.out.println("La huella de Carbono de este vuelo es: " + flight.carbonFootPrint() + " toneladas de CO2");
				System.out.println(flight.toString());
				if (flights.indexOf(flight) != flights.size() - 1) {
					System.out.println();
				}
			}
		}
	}

	public static Flight selectFlight(ArrayList<Flight> flights, String flightNumber) {
		int i = 0;
		Flight flight = null;

		while (i < flights.size() && flight == null) {
			if (flights.get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
				flight = flights.get(i);
			} else {
				i++;
			}
		}
		return flight;
	}
}