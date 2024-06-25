package algoritmia;

import java.util.Scanner;

public class EjercicioExtraClase5 {

	public static void main(String[] args) {
		int year;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduce un año para comprobar si es bisiesto:");
			year = sc.nextInt();
		} while (!checkLeapYear(year));

	}

	public static boolean checkLeapYear(int year) {
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println("El año " + year + " es bisiesto.");
			return true;

		} else {
			System.out.println("El año " + year + " no es bisiesto.");
			return false;
		}
	}

}