package algoritmia;

import java.util.Scanner;

public class M73Ejercicio1 {

	public static void main(String[] args) {
		/*
		 * Realitzar un programa que tingui un menú on se li mostraran 4 opcions a
		 * l’usuari/ària per pantalla: 1.- Quadrat 2.- Triangle 3.- Rectangle 4.- Cercle
		 * 0.- Sortir del programa
		 * 
		 * Segons l’opció escollida haurà d’introduir unes dades o altres perquè el
		 * programa mostri per pantalla l’àrea (el valor) del polígon escollit.
		 * 
		 */
		boolean sortir = false;

		do {
			switch (menu()) {
			case 1:
				squareArea();
				break;
			case 2:
				triangleArea();
				break;
			case 3:
				rectangleArea();
				break;
			case 4:
				circleArea();
				break;
			case 0:
				System.out.println("Gracias por usar la aplicación.");
				sortir = true;
				break;
			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner sc = new Scanner(System.in);
		byte option;
		final byte MINIMUM = 0;
		final byte MAXIMUM = 4;

		do {
			System.out.println("\nCALCULA EL AREA DE UN:");
			System.out.println("1. Cuadrado.");
			System.out.println("2. Triángulo.");
			System.out.println("3. Rectángulo.");
			System.out.println("4. Círculo.");
			System.out.println("0. Salir de la aplicación.\n");
			option = sc.nextByte();
			if (option < MINIMUM || option > MAXIMUM) {
				System.out.println("Escull una opció vàlida");
			}
		} while (option < MINIMUM || option > MAXIMUM);
		return option;
	}

	public static void squareArea() {
		float side;
		
		System.out.println("Introduce el lado del cuadrado");
		side = checkPositive();
		System.out.println("El área de un cuadrado con lado " + side + " és: " + String.format("%.2f",Math.pow(side, 2)));
	}

	public static void triangleArea() {
		float base;
		float height;
		
		System.out.println("Introduce la base del Triángulo");
		base = checkPositive();
		System.out.println("Introduce la altura del Triángulo");
		height = checkPositive();
		System.out.println(
				"El área de un triángulo con base " + base + " y altura " + height + " és: " + String.format("%.2f",(base * height) / 2));
	}

	public static void rectangleArea() {
		float base;
		float height;
		
		System.out.println("Introduce la base del Rectángulo");
		base = checkPositive();
		System.out.println("Introduce la altura del Rectángulo");
		height = checkPositive();
		System.out.println("El área de un rectángulo con base " + base + " y altura " + height + " és: " + String.format("%.2f",base * height));
	}

	public static void circleArea() {
		float radius;		
				
		System.out.println("Introduce el radio del círculo");
		radius = checkPositive();		
		System.out.println("El área de un cuadrado con lado " + radius + " és: " + String.format("%.2f", Math.pow(radius, 2) * Math.PI));
	}

	public static float checkPositive() {
		Scanner sc = new Scanner(System.in);
		float num;
		do {
			num = sc.nextFloat();
			if (num <= 0) {
				System.out.println("Has de introducir un valor positivo:");
			}
		} while (num <= 0);
		return num;
	}

}
