package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioExtraClase3 {

	public static void main(String[] args) {

		int num = 0;
		ArrayList<Integer> odds = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		boolean isPar;
		
		System.out.println("introducir números hasta que uno sea par");
		do {
			System.out.println("introduce un número:");
			num = sc.nextInt();
			isPar=comprobarPar(num);
			if (!isPar) {
				odds.add(num);
			}
		} while (!isPar);

		enumOdds (odds);
	}

	static boolean comprobarPar(int num) {
		return num % 2 == 0;
	}
	
	static void enumOdds (ArrayList<Integer> odds) {
		if (odds.size() > 0) {
			System.out.println("Has introducido " + odds.size() + " números impares.");
			System.out.println("los números impares son: " + odds);
		} else {
			System.out.println("no has introducido ningún impar");
		}
	}

}
