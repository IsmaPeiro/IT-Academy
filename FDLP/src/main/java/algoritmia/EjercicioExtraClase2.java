package algoritmia;

import java.util.Scanner;

public class EjercicioExtraClase2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("introducir números hasta que uno sea par");
		do {
			System.out.println("introduce un número:");
		} while (!comprobarPar(sc.nextInt()));
		
		

	}

	static boolean comprobarPar(int num) {
		return num % 2 == 0;
	}
}
