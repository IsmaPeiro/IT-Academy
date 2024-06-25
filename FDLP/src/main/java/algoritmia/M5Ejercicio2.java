package algoritmia;

import java.util.Scanner;

public class M5Ejercicio2 {

	public static void main(String[] args) {
		/*
		 * El programa demana dos números enters i llavors calcula la suma dels valors
		 * compresos entre els dos números, inclosos. Exemple: 4 i 10 --> resultat = 4 +
		 * 5 + 6 + 7 + 8 + 9 + 10 = 49
		 */

		Scanner sc = new Scanner(System.in);
		int num1, num2, aux, suma = 0;

		System.out.println("introduce el primer número:");
		num1 = sc.nextInt();

		System.out.println("introduce el segundo número:");
		num2 = sc.nextInt();

		if (num1 > num2) {
			aux = num1;
			num1 = num2;
			num2 = aux;
		}

		if (num1 != num2) {
			for (int i = num1; i <= num2; i++) {
				System.out.print((i != num2) ? i + " + " : i + " = ");
				suma += i;
			}
			System.out.print(suma);
		} else {
			System.out.println("los números no forman un intérvalo.");
		}
	}
}
