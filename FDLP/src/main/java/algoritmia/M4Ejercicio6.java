package algoritmia;

import java.util.Scanner;

public class M4Ejercicio6 {

	public static void main(String[] args) {
		/*
		 * Crea un programa per a un restaurant o tenen tres plats
		 * (carn, pasta “amb gluten” i risotto "amb lactosa").
		 * El programa ha de demanar el plat que vol l'usuari/ària,
		 * però també ha de demanar si té cap preferència
		 * o intolerància (vegà, intolerància al gluten o intolerància a la lactosa).
		 * Si la persona demana un plat "que pot menjar" mostrarem per
		 * consola el missatge "perfecte, comanda correcta",
		 * si no, es mostrarà el missatge "vostè no pot menjar aquest plat"..
		 */
		Scanner sc = new Scanner(System.in);
		int meal, preference;
		
		System.out.println("introduce el plato que quieres comer:");
		System.out.println("1 - Carne.");
		System.out.println("2 - Pasta (con gluten).");
		System.out.println("3 - Risotto (con lactosa).");
		System.out.println("4 - Ninguno, gracias.");
		
		meal=sc.nextInt();
		
		if (meal <= 0 || meal > 4) {
			System.out.println("Haas de introducir un plato de la carta.");
		} else if (meal==4) {
			System.out.println("Esperamos que otro día tengamos algo de tu agrado, gracias.");
		} else {
			System.out.println("¿Tienes alguna preferencia o intolerancia?");
			System.out.println("1 - Soy Vegano.");
			System.out.println("2 - Soy glucémico.");
			System.out.println("3 - Intolerancia a la lactosa.");
			System.out.println("4 - Ninguna, gracias.");
			preference=sc.nextInt();
			
			switch (preference) {
				case 1:
					System.out.println((meal==1) 
							? "No puedes comer el plato que has elegido"
							: "Perfecto, pedido en marcha");
					break;
				case 2:
					System.out.println((meal==2) 
							? "No puedes comer el plato que has elegido"
							: "Perfecto, pedido en marcha");
					break;
				case 3:
					System.out.println((meal==3) 
							? "No puedes comer el plato que has elegido"
							: "Perfecto, pedido en marcha");
					break;
				case 4:
					System.out.println("Perfecto, pedido en marcha");
					break;
			}
		}
		
	}
}