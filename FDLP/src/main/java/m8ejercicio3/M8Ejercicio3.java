/*Fes les classes Cliente i Vol, perquè responguin al diagrama de classes de la imatge.

Fes un programa que tingui programades totes les opcions del següent menú:

Sortir de l'aplicació.
Crear clienta.
Eliminar clienta.
Crear vol d'una clienta.
Compensar CO₂ d'un vol d'una clienta (per cada 100 € es compensen 0,1 tones de CO₂ emès d'aquell vol).
Calcular petjada de carboni d'una clienta (és la suma del CO₂ de tots els seus vols).
Calcular petjada de carboni mitja de totes les clientes.
A tenir en compte:

- El CO₂ emès inicial de tots els vols ha de ser d'1 tona.

- En crear una clienta, aquesta no haurà de tenir cap vol "associat".

- A l'App només volem tenir un array de clientes, no de vols. Els vols s'han de guardar dintre de les clientes.

- El diagrama UML mostrà les propietats i mètodes mínims que han de tenir les classes, però pots crear-ne més si és necessari.

┌─────────────────────────┐                           ┌─────────────────────────────────┐ 
│Cliente                  │                           │Vuelo                            │
├─────────────────────────┤ 1                +cliente ├─────────────────────────────────┤
│[-] dni : String         │<─────────────────────────>│[-] numVuelo : int               │
│[-] nacionalidad : String│ +vuelo                  * │[-] company : String             │
│[-] edad : int			  │							  │[-] distancia : int              │
└─────────────────────────┘							  │[-] cO2emitido : double          │
													  ├─────────────────────────────────┤
													  │[+] compensaCO2 (euros : integer)│
													  └─────────────────────────────────┘	
*/
package m8ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class M8Ejercicio3 {

	public static void main(String[] args) {
		ArrayList<Client> clients = new ArrayList<Client>();
		boolean exit = false;

		Client client1 = new Client("11111111A", "Española", 18);
		Client client2 = new Client("22222222B", "Francesa", 35);
		Client client3 = new Client("33333333C", "Portuguesa", 23);

		Flight flight1 = new Flight(1, "Iberia", 600);
		Flight flight2 = new Flight(2, "Vueling", 1000);
		Flight flight3 = new Flight(3, "TWA", 800);

		client3.getFlight().add(flight1);
		client3.getFlight().add(flight2);
		client3.getFlight().add(flight3);

		clients.add(client1);
		clients.add(client2);
		clients.add(client3);

		do {
			switch (menu()) {
			case 1:
				createClient(clients);
				break;
			case 2:
				deleteClient(clients);
				break;
			case 3:
				createFlight(clients);
				break;
			case 4:
				compensateCO2Client(clients);
				break;
			case 5:
				calculateCO2Client(clients);
				break;
			case 6:
				calculateCO2Median(clients);
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
		byte option;
		final byte MINIMUM = 0;
		final byte MAXIMUM = 6;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("1. Crear Cliente.");
			System.out.println("2. Eliminar Cliente.");
			System.out.println("3. Crear vuelo de un cliente.");
			System.out.println("4. Compensar CO2 de un vuelo de un cliente.");
			System.out.println("5. Calcular huella de Carbono de un cliente.");
			System.out.println("6. Calcular huella de Carbono media.");
			System.out.println("0. Salir.");

			option = sc.nextByte();
			if (option < MINIMUM || option > MAXIMUM) {
				System.out.println("Escull una opció vàlida");
			}
		} while (option < MINIMUM || option > MAXIMUM);
		return option;
	}

	public static void createClient(ArrayList<Client> clients) {
		Scanner sc = new Scanner(System.in);
		Client duplicatedClient = null;
		String dni;
		String nationality;
		int age;

		System.out.println("Introduce los datos del cliente:");
		System.out.println("Introduce el DNI del cliente:");
		dni = sc.nextLine();
		duplicatedClient = seekClient(clients, dni);
		if (duplicatedClient == null) {
			System.out.println("Introduce la nacionalidad del cliente:");
			nationality = sc.nextLine();
			System.out.println("Introduce la edad del cliente:");
			age = sc.nextInt();
			clients.add(new Client(dni, nationality, age));
			System.out.println("Cliente creado correctamente.");
		} else {
			System.out.println("El cliente ya existe.");
		}
	}

	public static void deleteClient(ArrayList<Client> clients) {
		Scanner sc = new Scanner(System.in);
		String dni;
		Client client = null;

		System.out.println("Introduce el DNI del cliente:");
		dni = sc.nextLine();
		client = seekClient(clients, dni);
		if (client == null) {
			System.out.println("El cliente no existe.");
		} else {
			clients.remove(client);
			System.out.println("Clinte eliminado correctamente.");
		}
	}

	public static void createFlight(ArrayList<Client> clients) {
		Scanner sc = new Scanner(System.in);
		String dni, company;
		int flightNumber, distance;
		double co2;
		Client client = null;

		System.out.println("Introduce el DNI del cliente:");
		dni = sc.nextLine();
		client = seekClient(clients, dni);
		if (client != null) {
			System.out.println("Introduce el número de vuelo:");
			flightNumber = sc.nextInt();
			sc.nextLine();
			if (seekFlight(client.getFlight(), flightNumber) == null) {
				System.out.println("Introduce la compañía:");
				company = sc.nextLine();

				System.out.println("Introduce la distancia del vuelo");
				distance = sc.nextInt();

				Flight vuelo = new Flight(flightNumber, company, distance);

				client.getFlight().add(vuelo);
				System.out.println("Vuelo creado correctamente.");
			} else {
				System.out.println("El cliente ya tiene este vuelo.");
			}
		} else {
			System.out.println("El cliente no existe.");
		}
	}

	public static void compensateCO2Client(ArrayList<Client> clients) {
		Scanner sc = new Scanner(System.in);
		String dni;
		int flightNumber, euros;
		Client client = null;
		Flight flight = null;

		System.out.println("Introduce el dni del cliente:");
		dni = sc.nextLine();
		client = seekClient(clients, dni);
		if (client != null) {
			System.out.println("Introduce el número de vuelo para compensar:");
			flightNumber = sc.nextInt();
			flight = seekFlight(client.getFlight(), flightNumber);
			if (flight != null) {
				if (flight.getCo2emitted() > 0) {
					System.out.println("Introduce la cantidad a compensar:");
					euros = sc.nextInt();
					if (euros % 100 == 0) {
						flight.compensateCO2(euros);
						System.out.println("Vuelo compensado correctamente");
					} else {
						System.out.println("La cantidad ha de ser multiplo de 100.");
					}
				} else {
					System.out.println("El vuelo ya está compensado completamente.");
				}
			} else {
				System.out.println("El cliente no tiene este vuelo.");
			}
		} else {
			System.out.println("El cliente no existe.");
		}
	}

	public static void calculateCO2Client(ArrayList<Client> clients) {
		Scanner sc = new Scanner(System.in);
		Client client = null;
		String dni;		

		System.out.println("Introduce el DNI del cliente:");
		dni = sc.nextLine();
		client = seekClient(clients, dni);
		if (client != null) {
			System.out.println("El total de la huella de carbono de este cliente es: "
					+ client.calculteTotalCarbonFootprint() + " toneladas de CO2");
		} else {
			System.out.println("El cliente no existe.");
		}
	}

	public static void calculateCO2Median(ArrayList<Client> clients) {
		double medianCO2 = 0;

		for (Client cliente : clients) {
			medianCO2 += cliente.calculteTotalCarbonFootprint();
		}
		medianCO2 /= clients.size();
		System.out.println("La media de hualla de CO2 de todos los clientes es: " + String.format("%.2f", medianCO2)
				+ " toneladas de CO2");
	}

	public static Client seekClient(ArrayList<Client> clients, String dni) {
		Client client = null;
		int i = 0;
		while (client == null && i < clients.size()) {
			if (clients.get(i).getDni().equalsIgnoreCase(dni)) {
				client = clients.get(i);
			} else {
				i++;
			}
		}
		return client;
	}

	public static Flight seekFlight(ArrayList<Flight> flights, int flightNumber) {
		Flight flight = null;
		int i = 0;

		while (flight == null && i < flights.size()) {
			if (flightNumber == flights.get(i).getflightNumber()) {
				flight = flights.get(i);
			} else {
				i++;
			}
		}
		return flight;
		}
	}