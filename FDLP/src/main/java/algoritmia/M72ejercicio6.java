package algoritmia;

import java.util.Scanner;

public class M72ejercicio6 {

	public static void main(String[] args) {
		/*
		 * L’usuari/ària ha d’introduir números fins que introdueixi un nombre primer.
		 * En el moment que l’usuari/ària introdueixi un nombre primer,
		 * el programa ha de treure per pantalla el següent missatge:
		 * "Exacte, el número “x” és primer!"
		 *  Nota
		 *  Utilitzar el mètode creat a l'exercici: (M7.2.) Exercici 1.	}
		 */
		
	inputPrime();		
			
	}	
	
	public static void inputPrime () {
		int num;
		boolean prime=false;
		Scanner sc=new Scanner(System.in);
		System.out.println("Intorduce números hasta que uno sea primo:");
		do {			
			num=sc.nextInt();
			if (checkPrime(num)&&num!=1) {
				System.out.println("Exacto, "+num+" es un número primo.");
				prime=true;
			} else {
				System.out.println("error, vuelve a probar:");
			}
		} while (!prime||num==1);
	}
	
	public static boolean checkPrime(int num) { 
		boolean prime = true;
		int divisor = 2;
		while (prime && divisor < num) {
			if (num % divisor == 0) {
				prime = false;
			}
			divisor++;
		}
		return prime;
	}
}
