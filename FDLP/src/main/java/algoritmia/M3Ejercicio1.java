package algoritmia;

import java.util.Scanner;

public class M3Ejercicio1 {

	public static void main(String[] args) {
		/*Fer un programa que li demani a l’usuari/ària: El nom, el cognom i l’edat.
		 * Un cop l’usuari/ària hagi acabat d’introduir les dades, aquestes s’han de mostrar per pantalla.
		 */
		String nombre, apellido;
		byte edad;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce tu nombre:");
		nombre=sc.nextLine();
		
		System.out.println("Introduce tu apellido:");
		apellido=sc.nextLine();
		
		System.out.println("Introduce tu edat:");
		edad=sc.nextByte();
		
		sc.close();
		
		System.out.println("te llamas: "+nombre+" "+apellido+", y tienes "+edad+" años");

	}

}
