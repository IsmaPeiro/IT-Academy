package algoritmia;

import java.util.Scanner;

public class M5EjercicioExtra2 {

	public static void main(String[] args) {		
		/*
		 * Realitza un programa que pinti la lletra L per pantalla feta amb asteriscs.
		 * El programa demanarà l'altura.
		 * El pal horitzontal de la L tindrà una longitud de la meitat (divisió entera entre 2)
		 * de l'altura més un. (Recordar println i print)
		 * Exemple:
		 * Introdueix l'alçada de la L: 5
		 * La base serà la divisió del nombre entre 2: (5 / 2) + 1 = 3
		 * *
		 * *
		 * *
		 * *
		 * * * *
		 */
		Scanner sc=new Scanner(System.in);
		int altura;
		int ancho;
		
		System.out.println("Introduce la altura de la L:");
		altura=sc.nextInt();
		sc.close();
		
		ancho=(altura/2)+1;
		
		for (int i=1; i<altura; i++) {
			System.out.println("*");
		}
		
		for (int i=1; i<=ancho; i++) {
			System.out.print("* "); //Le he dado un espacio para que quede mejor estéticamente
		}

	}

}
