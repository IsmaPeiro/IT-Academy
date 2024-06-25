package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class M72Ejercicio8 {

	public static void main(String[] args) {
		/*
		 * L’usuari/ària introdueix un nombre per teclat i el programa crida a un mètode
		 * que ha de mostrar la successió de Fibonacci. Exemple: Si l’usuari/ària
		 * introdueix el 10, el resultat ha de ser: 0,1,1,2,3,5,8,13,21,34
		 */

		showFibonacci(inputNum());
	}

	public static int inputNum() {
		int num;
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Cuantas cifras de la sucesión de Fibonacci quieres ver?");
		do {
			num = sc.nextInt();
			if (num <= 0) {
				System.out.println("Has de introducir un número mayor que 0:");
			}
		} while (num <= 0);
		return num;
	}

	public static void showFibonacci(int num) {
		int size;
		ArrayList<Integer> fibonacci = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			if (i == 0 || i == 1) {
				fibonacci.add(i);
			} else {
				fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
			}
		}
		size = fibonacci.size();
		for (int i = 0; i < size; i++) {
			System.out.print((i != num - 1) ? fibonacci.get(i) + ", " : fibonacci.get(i) + ".");
		}
	}
	
	//MÉTODO ALTERNATIVO CON TRES VARIABLES
	/*public static void showFibonacci (int num) {
		int actual=0;
		int anterior=0;
		int aux=1;
		
		for (int i=0;i<num;i++) {
			System.out.print( i!=num-1 ? actual+", " : actual+".");
			anterior=actual;
			actual=aux;
			aux=anterior+actual;
		}
		
	}*/
}