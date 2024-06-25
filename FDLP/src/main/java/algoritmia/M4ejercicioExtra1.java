package algoritmia;

import java.util.Scanner;

public class M4ejercicioExtra1 {

	public static void main(String[] args) {
		/*
		 * Fes un programa que pregunti a l'usuari/ària dos nombres enters
		 * al qual anomenaràs dividend i divisor respectivament.
		 * El divisor haurà d'estar comprès entre 2 i 7.
		 * En cas contrari, el programa haurà de mostrar un missatge d'error.
		 * Si el divisor és correcte (2-7) mostra en pantalla si el dividend
		 * és múltiple del divisor, o no.
		 */

		int dividendo;
		int divisor;
		int modulo;
		Scanner sc=new Scanner (System.in);
		
		System.out.println("Introduce dos numeros, uno para el dividendo, otro para el divisor, que esté entre 2 y 7, y comprobaremos si el dividendo es multiple del divisor");
		System.out.println("Introduce un número entero para el dividendo:");
		dividendo=sc.nextInt();
		
		System.out.println("Introduce otro número entero para divisor:");
		divisor=sc.nextInt();
		
		sc.close();
		
		if (divisor >=2 && divisor<=7) {
			modulo=dividendo%divisor;
			System.out.println( (modulo==0) ? dividendo+" es multiple de " + divisor: dividendo+" no es multiple de "+ divisor);			
		} else {
			System.out.println("has de introducir un divisor entre 2 y 7");
		}
		

	}

}