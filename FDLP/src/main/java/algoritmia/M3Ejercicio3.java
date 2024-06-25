package algoritmia;

import java.util.Scanner;

public class M3Ejercicio3 {

	public static void main(String[] args) {
		/* El programa demana a l'usuari/ària que introdueixi 3 notes
		 * i el programa mostra la mitja de les 3 notes per pantalla.
		 * Nota:
		 * Les notes que introdueix l'usuari/ària són números sencers, però la mitja pot tenir decimals.
		 */
		int nota1, nota2, nota3;
		float media;
		final int NOTAS=3;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce tres notas para obtener la media.");
		
		System.out.println("Introduce la primera nota:");
		nota1=sc.nextInt();
		
		System.out.println("Introduce la segunda nota:");
		nota2=sc.nextInt();
		
		System.out.println("Introduce la tercera nota:");
		nota3=sc.nextInt();
		
		sc.close();
		
		media=(float)(nota1+nota2+nota3)/NOTAS;
				
		System.out.println("La media de las notas es: "+ media);
	}

}
