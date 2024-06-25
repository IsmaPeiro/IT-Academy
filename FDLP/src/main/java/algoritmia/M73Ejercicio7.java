package algoritmia;

import java.util.Scanner;

public class M73Ejercicio7 {

	public static void main(String[] args) {
		/*
		 * Escriu un programa per una botiga de surf on se li exposarà un menú als
		 * usuaris i usuàries amb les següents opcions:
		 * 
		 * Calcular material taula (crida a un mètode que rep un boolean que representi
		 * si la persona té experiència o no) si té, retornarà el missatge
		 * "taula de fibra", si no retornarà el missatge "taula d'espuma". (demanem per
		 * consola si l'usuari/ària si té experiència o no)
		 * 
		 * Imprimir forecast (crida a un mètode que rep l'alçada de l'onada en metres).
		 * Si l'alçada és més de 2 metres, imprimirà "onades grans", si no imprimirà
		 * "onades petites". (Introduïm l'alçada de les onades per consola, simulant que
		 * les rebem d'una aplicació externa)
		 * 
		 * Calcula el cost per reserva (crida a un mètode que rep els minuts de reserva
		 * i el tipus de taula reservada i retorna el cost de la reserva). (demanem per
		 * consola els minuts i el tipus) Taula tipus iniciació: 20 € cada 60 min. Taula
		 * tipus intermig: 35 € cada 60 min.
		 * 
		 * Sortir del programa.
		 * 
		 * Fins que la persona no escrigui un 4, el programa ha de continuar mostrant el
		 * menú i donar la possibilitat de fer accions.
		 */

		boolean sortir = false;
		Scanner sc = new Scanner(System.in);
		float waves;
		float time;
		String table;

		do {
			switch (menu()) {
			case 1:
				System.out.println("Tienes experiencia (S/N)?");
				System.out.println(calculateMaterial(yesOrNo()));
				break;
			case 2:
				System.out.println("Cual es la altura de las olas?");
				waves = sc.nextFloat();
				printForecast(waves);
				break;
			case 3:
				table = tableType();
				System.out.println("Cuanto tiempo estarás (en minutos)?");
				time = sc.nextFloat();
				System.out.println(bookingCost(table, time));
				break;
			case 4:
				System.out.println("Garcias por usar la aplicación.");
				sortir = true;
				break;
			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 1;
		final byte MAXIMO = 4;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("1. Calcular Material.");
			System.out.println("2. Imprimir Forecast.");
			System.out.println("3. Precio Reserva.");
			System.out.println("4. Salir de la aplicación.\n");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escoge una opción válida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static String calculateMaterial(boolean experience) {
		return experience ? "Tabla de Fibra." : "Tabla de espuma.";
	}

	public static void printForecast(float waves) {
		System.out.println(waves > 2 ? "Olas grandes" : "Olas pequeñas");
	}

	public static String bookingCost(String table, float time) {
		String booking = "";
		if (table.equalsIgnoreCase("espuma")) {
			booking = "El coste de la reserva es: " + 20 * (time / 60) + " euros.";
		} else if (table.equalsIgnoreCase("fibra")) {
			booking = "El coste de la reserva es: " + 35 * (time / 60) + " euros.";
		}
		return booking;
	}

	public static boolean yesOrNo() {
		Scanner sc = new Scanner(System.in);
		boolean experience = false;
		String yesNo;
		
		do {
			yesNo = sc.nextLine();
			if (yesNo.equalsIgnoreCase("S")) {
				experience = true;
			} else if (yesNo.equalsIgnoreCase("N")) {
				experience = false;
			} else {
				System.out.println("Has de introducir una opción válida");
			}
		} while (!yesNo.equalsIgnoreCase("S") && !yesNo.equalsIgnoreCase("N"));
		return experience;
	}

	public static String tableType() {
		String table;
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("¿Qué tipo de tabla usarás (Fibra/Espuma)?");
			table = sc.nextLine();
			if (table.equalsIgnoreCase("fibra") || table.equalsIgnoreCase("espuma")) {
				exit = true;
			} else {
				System.out.println("Has de introducir una opción válida.");
				exit = false;
			}
		} while (!exit);
		return table;
	}
}
