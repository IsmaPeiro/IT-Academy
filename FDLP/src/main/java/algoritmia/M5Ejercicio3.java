package algoritmia;

import java.util.Scanner;

public class M5Ejercicio3 {

	public static void main(String[] args) {
		/*
		 * Aquesta línia de codi:
		 * Math.ceil((Math.random() * 10));
		 * Retorna un número entre el 1 i el 10 de forma aleatòria.
		 * L’exercici consisteix a què l’usuari/ària ha d'endevinar el número escollit aleatòriament pel programa.
		 * El programa, demana números a l’usuari/ària fins que aquest encerti el número aleatori generat pel programa.
		 * Un cop l’usuari/ària ha endevinat el número, es mostrarà per pantalla el següent missatge: “Enhorabona, el número era X”
		 */
		int numAleatorio;
		int numUser;
		int intentos;
		final int LIMITE=3;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Adivina el número entre 1 y 10 que se ha generado");
		
		numAleatorio=(int) Math.ceil((Math.random() * 10));
										
		System.out.println("introduce un número:");
		numUser=sc.nextInt();
		intentos=1;
		while (numUser!=numAleatorio&&intentos!=LIMITE) {
			if ((numUser>=1&&numUser<=10)&&(numUser!=numAleatorio)) {
				System.out.println ((numUser>numAleatorio) ? "Has fallado, tu número es mayor que el que buscamos, sigue probando.":
															 "Has fallado, tu número es menor que el que buscamos, sigue probando.");
				intentos++;
			} else if (numUser<1||numUser>10) {
				System.out.println("No has introducido un número del 1 al 10, sigue probando.");
			}
			numUser=sc.nextInt();			
		}
				
		if (intentos<=LIMITE&&numUser==numAleatorio) {
			System.out.println("Has acertado, ¡¡¡Felicidades!!!, el número era: "+numAleatorio);
			System.out.println((intentos==1) ? "¡¡¡Has acertado a la primera!!!" : "Has necesitado "+intentos+" intentos");
		}	else {
			 System.out.println("Has llegado al límite de intentos, el número era: "+numAleatorio);			
		}
		
		sc.close();
	}

}
