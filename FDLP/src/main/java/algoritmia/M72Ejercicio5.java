package algoritmia;

import java.util.Scanner;

public class M72Ejercicio5 {

	public static void main(String[] args) {
		/*
		 * Realitzar un programa on l’usuari/ària introdueix un número
		 * i el programa crida a un mètode que retorna el factorial del número introduït.
		 * El factorial d'un nombre n (enter, no negatiu) és el producte
		 * de tots els nombres enters positius inferiors o iguals a n.
		 * 
		 */
		calculateFactorial(inputNum());
	}	
	
	public static int inputNum () {
		Scanner sc=new Scanner(System.in);
		int num;
		System.out.println("Introduce un número entero positivo:");
		do {
			num=sc.nextInt();
			if (num<=0) {
				System.out.println("Has de introducir un número entero positivo:");
			}
		} while (num<=0);
		return num;
	}
	
	public static void calculateFactorial(int num) {
		double result=1; //utilizamos un double para el resultado ya que los números factoriales enseguida alcanzan resultados altos
		System.out.print(num+"! => ");
		for (int i=num;i>=1;i--) {
			result*=i;
			System.out.print( i!=1 ? i+" * " : i+" = ");
		}
		System.out.print(result);
	}
}
