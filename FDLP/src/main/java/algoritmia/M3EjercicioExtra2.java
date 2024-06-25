package algoritmia;

import java.util.Scanner;

public class M3EjercicioExtra2 {

	public static void main(String[] args) {
		/*  NOTA
		 * Per aquest exercici es necessiten alguns coneixements del següent mòdul (Estructures condicionals).
		 * Escriu un programa Java que sol·liciti per pantalla un nombre enter,
		 * i si és menor que 10, ho assigni a una variable de tipus int, anomenada varInt.
		 * Si no ho és, llavors li assignarà a la variable varInt el número 1.
		 * (Utilitza per a això l'operador condicional ? :)
		 * Després, imprimeix la taula de multiplicar d'aquesta variable.
		 */
		int numIntroducido;
		int varint;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce un númeor entero menor de 10:");
		numIntroducido = sc.nextInt();
		
		sc.close();
		
		varint=numIntroducido<10 ? numIntroducido : 1;
		
		System.out.println("La tabla de multiplicar de " + varint + " es:");
		
		for (int i=0; i<=10; i++) {
			System.out.println(varint + "*" + i + "="+ varint*i);
		}
	}

}
