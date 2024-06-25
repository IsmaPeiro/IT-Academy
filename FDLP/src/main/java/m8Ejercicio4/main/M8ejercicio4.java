package m8Ejercicio4.main;

import java.util.ArrayList;
import java.util.Scanner;

import m8Ejercicio4.herencia.*;

public class M8ejercicio4 {

	public static void main(String[] args) {
		ArrayList<Avion> aviones = new ArrayList<Avion>();

		AvionComercial avionComercial = new AvionComercial("VL111", "Boing", "AC1", 100, 10000, 150);
		Avioneta avioneta = new Avioneta("VL111", "Cesna", "AV1", 20, 100, 1);
		JetPrivado jetPrivado = new JetPrivado("VL111", "Mustang", "JP1", 25, 1500, 10);

		aviones.add(avionComercial);
		aviones.add(avioneta);
		aviones.add(jetPrivado);

		boolean sortir = false;

		do {
			switch (menu()) {
			case 1:
				crearAvion(aviones);
				break;
			case 2:
				eliminarAvion(aviones);
				break;
			case 3:
				mostrarAvion(aviones);
				break;
			case 0:
				System.out.println("Gracias por usar la aplicación.");
				sortir = true;
				break;
			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 3;

		do {System.out.println("░░░░░░░░░░█\n"
  							  +"░░░░░░░░▄▄█▄▄\n"
							  +"░░░░▀▀▀██▀▀▀██▀▀▀\n"
							  +"▄▄▄▄▄▄▄███████▄▄▄▄▄▄▄\n"
							  +"░░█▄█░░▀██▄██▀░░█▄█");
			System.out.println("\nMENÚ PRINCIPAL");
			System.out.println("1. Dar de alta un avión.");
			System.out.println("2. Eliminar un avión.");
			System.out.println("3. Mostrar un avión.");
			System.out.println("0. Salir de la aplicación.\n");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escoge una opción válida.");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static void crearAvion(ArrayList<Avion> aviones) {
		Scanner sc = new Scanner(System.in);		
		int tipoAvion;
		String numVuelo;

		System.out.println("¿Qué tipo de avión quieres crear (1-comercial | 2-avioneta | 3-privado)?");
		tipoAvion = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el número de vuelo:");
		numVuelo = sc.nextLine();
		switch (tipoAvion) {
		case 1:
			AvionComercial avionComercial = buscarAvionComercial(aviones, numVuelo);
			if (avionComercial == null) {
				introducirAvionComercial(aviones, numVuelo);
			} else {
				System.out.println("El avión ya existe en la base de datos.");
			}
			break;
		case 2:
			Avioneta avioneta = buscarAvioneta(aviones, numVuelo);
			if (avioneta == null) {
				introducirAvioneta(aviones, numVuelo);
			} else {
				System.out.println("El avión ya existe en la base de datos.");
			}
			break;
		case 3:
			JetPrivado jetPrivado = buscarJetPrivado(aviones, numVuelo);
			if (jetPrivado == null) {
				introducirJetPrivado(aviones, numVuelo);
			} else {
				System.out.println("El avión ya existe en la base de datos.");
			}
			break;
		default:
			System.out.println("Has introducido una opción no válida.");
		}
	}

	public static void eliminarAvion(ArrayList<Avion> aviones) {
		Scanner sc = new Scanner(System.in);		
		int tipoAvion;
		String numVuelo;

		System.out.println("¿Qué tipo de avión quieres eliminar (1-comercial | 2-avioneta | 3-privado)?");
		tipoAvion = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el número de vuelo:");
		numVuelo = sc.nextLine();
		switch (tipoAvion) {
		case 1:
			AvionComercial avionComercial = buscarAvionComercial(aviones, numVuelo);
			if (avionComercial != null) {
				aviones.remove(avionComercial);
				System.out.println("Avión eliminado correctamente.");
			} else {
				System.out.println("El avión no existe en la base de datos.");
			}
			break;
		case 2:
			Avioneta avioneta = buscarAvioneta(aviones, numVuelo);
			if (avioneta != null) {
				aviones.remove(avioneta);
				System.out.println("Avión eliminado correctamente.");
			} else {
				System.out.println("El avión no existe en la base de datos.");
			}
			break;
		case 3:
			JetPrivado jetPrivado = buscarJetPrivado(aviones, numVuelo);
			if (jetPrivado != null) {
				aviones.remove(jetPrivado);
				System.out.println("Avión eliminado correctamente.");
			} else {
				System.out.println("El avión no existe en la base de datos.");
			}
			break;
		default:
			System.out.println("Has introducido una opción no válida.");
		}
	}

	public static void mostrarAvion(ArrayList<Avion> aviones) {
		Scanner sc = new Scanner(System.in);		
		int tipoAvion;
		String numVuelo;

		System.out.println("¿Qué tipo de avión quieres mostrar (1-comercial | 2-avioneta | 3-privado)?");
		tipoAvion = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el número de vuelo:");
		numVuelo = sc.nextLine();
		switch (tipoAvion) {
		case 1:
			AvionComercial avionComercial = buscarAvionComercial(aviones, numVuelo);
			if (avionComercial != null) {				
				System.out.println("Datos del avión:");
				System.out.println(avionComercial.toString());
				System.out.println("El coste de la comida en este avión es: "+avionComercial.calcularCosteComida()+" €.");
				System.out.println("El tiempo para limpiar este avión es: "+avionComercial.limpiarAvion()+" minutos.");
			} else {
				
				System.out.println("El avión no existe en la base de datos.");
				;
			}
			break;
		case 2:
			Avioneta avioneta = buscarAvioneta(aviones, numVuelo);
			if (avioneta != null) {
				System.out.println("Datos del avión:");
				System.out.println(avioneta.toString());
				System.out.println("El distancia que puede recorrer este avión es: "+avioneta.calculaDistancia()+" Km.");
				System.out.println("El tiempo para limpiar este avión es: "+avioneta.limpiarAvion()+" minutos.");
			} else {
				System.out.println("El avión no existe en la base de datos.");
			}
			break;
		case 3:
			JetPrivado jetPrivado = buscarJetPrivado(aviones, numVuelo);
			if (jetPrivado != null) {				
				System.out.println("Datos del avión:");
				System.out.println(jetPrivado.toString());
				System.out.println("El coste de la reserva de este avión es: "+jetPrivado.calcularCosteReserva()+" €.");
				System.out.println("El tiempo para limpiar este avión es: "+jetPrivado.limpiarAvion()+" minutos.");
			} else {
				System.out.println("El avión no existe en la base de datos.");
			}
			break;
		default:
			System.out.println("Has introducido una opción no válida.");
		}
	}

	public static AvionComercial buscarAvionComercial(ArrayList<Avion> aviones, String numVuelo) {
		AvionComercial avionComercial = null;
		int i = 0;
		while (avionComercial == null && i < aviones.size()) {
			if (aviones.get(i) instanceof AvionComercial && aviones.get(i).getNumVuelo().equalsIgnoreCase(numVuelo)) {
				avionComercial = (AvionComercial)aviones.get(i);
			} else {
				i++;
			}
		}
		return avionComercial;
	}

	public static Avioneta buscarAvioneta(ArrayList<Avion> aviones, String numVuelo) {
		Avioneta avioneta = null;
		int i = 0;
		while (avioneta == null && i < aviones.size()) {
			if (aviones.get(i) instanceof Avioneta && aviones.get(i).getNumVuelo().equalsIgnoreCase(numVuelo)) {
				avioneta = (Avioneta)aviones.get(i);
			} else {
				i++;
			}
		}
		return avioneta;
	}

	public static JetPrivado buscarJetPrivado(ArrayList<Avion> aviones, String numVuelo) {
		JetPrivado jetPrivado = null;
		int i = 0;
		while (jetPrivado == null && i < aviones.size()) {
			if (aviones.get(i) instanceof JetPrivado && aviones.get(i).getNumVuelo().equalsIgnoreCase(numVuelo)) {
				jetPrivado = (JetPrivado)aviones.get(i);
			} else {
				i++;
			}
		}
		return jetPrivado;
	}

	public static void introducirAvionComercial(ArrayList<Avion> aviones, String numVuelo) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la marca:");
		String marca = sc.nextLine();
		System.out.println("Introduce el módelo:");
		String modelo = sc.nextLine();
		System.out.println("Introduce la longitud:");
		double longitud = sc.nextDouble();
		System.out.println("Introduce la carga:");
		double carga = sc.nextDouble();
		System.out.println("Introduce los pasajeros:");
		int pasajeros = sc.nextInt();

		aviones.add(new AvionComercial(numVuelo, marca, modelo, longitud, carga, pasajeros));
		System.out.println("Avión creado correctamente.");
	}
	
	public static void introducirAvioneta(ArrayList<Avion> aviones, String numVuelo) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la marca:");
		String marca = sc.nextLine();
		System.out.println("Introduce el módelo:");
		String modelo = sc.nextLine();
		System.out.println("Introduce la longitud:");
		double longitud = sc.nextDouble();
		System.out.println("Introduce la carga:");
		double carga = sc.nextDouble();
		System.out.println("Introduce el número de hélices:");
		int helices = sc.nextInt();

		aviones.add(new AvionComercial(numVuelo, marca, modelo, longitud, carga, helices));
		System.out.println("Avión creado correctamente.");
	}

	public static void introducirJetPrivado(ArrayList<Avion> aviones, String numVuelo) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la marca:");
		String marca = sc.nextLine();
		System.out.println("Introduce el módelo:");
		String modelo = sc.nextLine();
		System.out.println("Introduce la longitud:");
		double longitud = sc.nextDouble();
		System.out.println("Introduce la carga:");
		double carga = sc.nextDouble();
		System.out.println("Introduce los pasajeros:");
		int pasajeros = sc.nextInt();
		if (pasajeros <= 10) {
			aviones.add(new JetPrivado(numVuelo, marca, modelo, longitud, carga, pasajeros));
			System.out.println("Avión creado correctamente.");
		} else {
			System.out.println("No podemos dar de alta el avión.");
			System.out.println("El jet solo puede tener hasta 10 pasajeros.");
		}
	}
}