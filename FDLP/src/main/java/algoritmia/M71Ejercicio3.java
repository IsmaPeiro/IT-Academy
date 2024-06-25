package algoritmia;

import java.util.Scanner;

public class M71Ejercicio3 {

	public static void main(String[] args) {
		/*
		 * L’usuari/ària ha d'introduir un número i el programa ha de mostrar per pantalla si el número és parell o imparell.
		*/
		int num;
		Scanner sc=new Scanner(System.in);
		
		// Introducir num, 0 es par
		System.out.println("Introduce un número para comprobar si es par o impar");
		num=sc.nextInt();
		comprobarPar(num);
		

	}
	
	static void comprobarPar (int num) {
		System.out.println ( (num%2==0) ? num+" es par." : num+" es impar");
	}
}
