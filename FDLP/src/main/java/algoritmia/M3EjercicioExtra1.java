package algoritmia;

import java.util.Scanner;

public class M3EjercicioExtra1 {

	public static void main(String[] args) {
		/* Escriu un programa Java que llegeix un nombre enter
		 * per teclat i obté i mostra per pantalla el
		 * doble i el triple d'aquest número.
		 */
		int num;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce un númeor entero para obtener valor doble y triple:");
		num=sc.nextInt();
		
		sc.close();
		
		System.out.println("El docble de " + num + " es: "+(num*2));
		System.out.println("El triple de " + num + " es: "+(num*3));

	}

}
