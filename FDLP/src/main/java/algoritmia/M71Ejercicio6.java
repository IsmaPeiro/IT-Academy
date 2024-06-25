/*L’usuari/ària introduirà un número (de l'1 al 10) per pantalla,
 * i utilitzant un bucle, el programa li mostrarà
 * la taula de multiplicar d’aquell número.
 */

package algoritmia;

import java.util.Scanner;

public class M71Ejercicio6 {

	public static void main(String[] args) {
		/*
		 * L’usuari/ària introduirà un número (de l'1 al 10) per pantalla, i utilitzant
		 * un bucle, el programa li mostrarà la taula de multiplicar d’aquell número.
		 */
				
		showTable(inputNum());
	}

	public static int inputNum () {
		Scanner sc = new Scanner(System.in);
		int num;
			System.out.print("Introduce un número del 1 al 10: ");
		do {
			num = sc.nextInt();
			} while (!check1To10(num));
		return num;
		}
	
	public static boolean check1To10(int num) {
		if (num <= 10 && num > 0) {
			return true;
		} else {
			System.out.print("El número ha de estar entre 1 y 10:");
			return false;
		}
	}	
	
	public static void showTable (int num) {
		System.out.println("La tabla de multiplicar del "+num+" es:");
		for (int i=0;i<=10;i++) {
			System.out.println(num+" * "+i+" = "+(i*num));
		}
	}
}
