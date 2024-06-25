package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioExtraClase6 {

	public static void main(String[] args) {

		ArrayList<Integer> leapYears = new ArrayList<Integer>();

		inputYears(leapYears);
		showLeapYears(leapYears);

	}

	public static void inputYears(ArrayList<Integer> leapYears) {
		Scanner sc = new Scanner(System.in);
		int year1;
		int year2;
		int aux;

		System.out.println("introduzca el primer año:");
		year1 = sc.nextInt();
		System.out.println("introduzca el segundo año:");
		year2 = sc.nextInt();
		if (year1 > year2) {
			aux = year1;
			year1 = year2;
			year2 = aux;
		}
		for (int i = year1; i < year2; i++) {
			checkLeapYear(i, leapYears);
		}
	}

	public static void checkLeapYear(int year, ArrayList<Integer> leapYears) {
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			// System.out.println("El año " + year + " es bisiesto.");
			leapYears.add(year);

			/*
			 * } else { System.out.println("El año " + year + " no es bisiesto."); }
			 */
		}
	}

	public static void showLeapYears(ArrayList<Integer> leapYears) {
		System.out.println("Entre los dos años hay los siguientes años bisiestos:");
		System.out.println(leapYears);
	}
}