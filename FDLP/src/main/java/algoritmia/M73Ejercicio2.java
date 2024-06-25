package algoritmia;

import java.util.Scanner;

public class M73Ejercicio2 {

	public static void main(String[] args) {
		/*En aquest programa l’usuari/ària ha d’introduir un string i el programa ha de mostrar l’string al revés.
		* Important
		* No es pot fer servir el mètode reverse()
		*/
		String text;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una palabra:");
		text=sc.nextLine();
		
		reverseText(text);
	}
	public static void reverseText (String word) {
		for (int i=word.length()-1;i>=0;i--) {
			System.out.print(word.charAt(i));
			
		}
	}
}
