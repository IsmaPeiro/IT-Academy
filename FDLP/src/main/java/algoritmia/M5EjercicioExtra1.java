package algoritmia;

import java.util.Scanner;

public class M5EjercicioExtra1 {

	public static void main(String[] args) {
		/*
		 * Realitzar un joc per endevinar un nombre aleatori N, entre 1 i 500.
		 * Si la distància entre el nombre a endevinar i el de l'usuari/ària és de 50 o més, el programa haurà de dir:
		 * “Fred, fred: el teu número és més gran “ o “Fred, fred: el teu número és més petit “
		 * Si la distància entre el nombre a endevinar i el de l'usuari/ària està entre 15 i 50, el programa haurà de dir:
		 * “Tebi, Tebi: el teu número és més gran “ o “Tebi, Tebi: el teu número és més petit “
		 * I si la distància entre el nombre a endevinar i el de l'usuari/ària és menor a 15, el programa haurà de dir:
		 * “Calent, calent: el teu número és més gran “ o “Calent, calent: el teu número és més petit “
		 * El procés acaba quan l'usuari/ària encerta.
		 */
		final int N = (int) (Math.random() * 1500)+1;		
		int numUser;
		Scanner sc = new Scanner(System.in);

		System.out.println("adivina el número entre 1 y 1500.");
		System.out.println("Introduce el número:");
		numUser = sc.nextInt();
		while (numUser != N) {
			if (N - numUser >= 50) {
				System.out.println("Frío, frío, tu número es más pequeño");
			} else if (numUser - N >= 50) {
				System.out.println("Frío, frío, tu número es más grande");
			} else if (N - numUser >= 15 && N - numUser <= 49) {
				System.out.println("Tibío, Tibío, tu número es más pequeño");
			} else if (numUser - N >= 15 && numUser - N <= 49) {
				System.out.println("Tibío, Tibío, tu número es más grande");
			} else if (N - numUser >= 1 && N - numUser <= 14) {
				System.out.println("Caliente, caliente, tu número es más pequeño");
			} else if (numUser - N >= 1 && numUser - N <= 14) {
				System.out.println("Caliente, caliente, tu número es más grande");
			}
			System.out.println("Vuelve a intentarlo");
			numUser = sc.nextInt();

		}
		sc.close();
		System.out.println("¡¡¡Has acertado!!!");
	}
}
