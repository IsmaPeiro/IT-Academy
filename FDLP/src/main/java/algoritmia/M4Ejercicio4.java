package algoritmia;

import java.util.Scanner;

public class M4Ejercicio4 {

	public static void main(String[] args) {
		/*
		 * Crea un programa que sol·liciti a l'usuari/ària que introdueixi un número de
		 * l'1 al 10 i mostri per pantalla el seu equivalent en lletres (per exemple, 1
		 * es mostraria com "u", 2 com "dos", etc.).
		 */
		int numero;
		Scanner sc=new Scanner (System.in);
		
		System.out.println("introduce un número del 1 al 10:");
		
		numero=sc.nextInt();
				
		sc.close();
		
		switch (numero) {
		case 1:
			System.out.println("Has introducido el número uno");
			break;
		case 2:
			System.out.println("Has introducido el número dos");
			break;
		case 3:
			System.out.println("Has introducido el número tres");
			break;
		case 4:
			System.out.println("Has introducido el número cuatro");
			break;
		case 5:
			System.out.println("Has introducido el número cinco");
			break;
		case 6:
			System.out.println("Has introducido el número seis");
			break;
		case 7:
			System.out.println("Has introducido el número siete");
			break;
		case 8:
			System.out.println("Has introducido el número ocho");
			break;
		case 9:
			System.out.println("Has introducido el número nueve");
			break;
		case 10:
			System.out.println("Has introducido el número diez");
			break;
		default:
			System.out.println("No has introducido un número del 1 al 10");
			break;
		}
	}

}
