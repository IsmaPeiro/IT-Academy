package algoritmia;

import java.util.Scanner;

public class M73Ejercicio4 {

	public static void main(String[] args) {
		/*
		 * L’usuari/ària ha d’introduir un DNI i el programa 
		 * ha de dir si la lletra és correcte o no amb el nombre de DNI.
		 * Si la lletra no és correcta, ha de dir quina lletra és la correcta.
		 * Per calcular la lletra DNI has de prendre el número de DNI
		 * a verificar i dividir-lo entre 23. El residu es reemplaça
		 * per una lletra que ja està assignada a aquest nombre mitjançant la taula adjunta:
		 * Taula lletra DNI:
		 * Rest	:0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22
		 * Letra:T R W A G M Y F P D X  B  N  J  Z  S  Q  V  H  L  C  K  E
		 */
		
		Scanner sc=new Scanner(System.in);
		String dni;
		
		do {
			System.out.println("Introduce el DNI para ver si es correcto:");
			dni=sc.nextLine();
		} while (!checkFormatDni (dni));
		
		checkLetterDni (dni);
		
	}

	public static boolean checkFormatDni(String dni) {
		if (dni.matches("([0-9]{8}[a-zA-Z])")) {
			return true;
		} else {
			System.out.println("El formato del dni ha de tener 8 números y una letra.");
			return false;
		}
	}

	public static void checkLetterDni(String dni) {
		int num;
		char letter;
		char[] letters = new char[] { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
				'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
		
		num = Integer.parseInt(dni.substring(0, 8));
		letter =dni.substring(8).toUpperCase().charAt(0);
		
		if (letters[num%23]==letter) {
			System.out.println("El DNI es correcto.");
		} else {
			System.out.println("El número o la letra del DNI no son correctos.");
			System.out.println("La letra correcta para este número es: "+ letters[num%23]);			
		}

	}
}