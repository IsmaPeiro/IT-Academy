package algoritmia;

import java.util.Scanner;

public class M72Ejercicio7 {

	public static void main(String[] args) {
		/*
		 * L’usuari/ària introdueix un any a per teclat
		 * i el programa crida a un mètode que indiqui si l’any és de traspàs o no.
		 * Año%400==0 es bisiesto
		 * Año%4==0&&Año%100!=0 es bisiesto
		 */
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce un año para comprobar si es bisiesto:");
				
		checkLeapYear(sc.nextInt());		

	}
	
	public static void checkLeapYear (int year) {
		if ((year%400==0) || (year%4==0&&year%100!=0)) {
			System.out.println("El año "+year+" es bisiesto");		
		} else {
			System.out.println ("El año "+year+" no es bisiesto");
		}		
	}
		
}