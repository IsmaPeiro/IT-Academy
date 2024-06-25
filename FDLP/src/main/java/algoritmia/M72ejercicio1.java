package algoritmia;

import java.util.Scanner;

public class M72ejercicio1 {

	public static void main(String[] args) {
		/*Sabries dir que fa el programa adjunt?
		 * Per fer-ho segurament hauries de posar algun punt
		 * de trencament (breakpoint) i avaluar el valor 
		 * de les variables on es prenen decisions.
		 * 
		 * PROGRAMA ORIGINAL
		 * package debugger;

			import java.util.Scanner;
			
			public class Debugger {
			
				public static void main(String[] args) {
					Scanner sc = new Scanner(System.in);
					boolean p = false;
			
					System.out.println("Escoge un número: ");
					int n = sc.nextInt();
					
					if (n > 1) { //poner breakpoint
						p = ep(n);
					}
			
					System.out.println(p);
				}
			
				public static boolean ep(int n) { //poner breakpoint
					boolean p = true;
					int i = 2;
					while (p && i < n) {
						if (n % i == 0) {
							p = false;
						}
						i++;
					}
					return p;
				}
			}
		 */
		//PROGRAMA REFACTORIZADO
		/*
		 * Hay que poner breakpoints en las tomas de decisiones
		 * y debugar, el programa muestra true al introducir
		 * un número primo
		 */
		Scanner sc = new Scanner(System.in);
		boolean esPrimo = false;

		System.out.println("Escoge un número: ");
		int numero = sc.nextInt();
		
		if (numero > 1) { //poner breakpoint
			esPrimo = comprobarPrimo(numero);
		}

		System.out.println(esPrimo);
	}

	public static boolean comprobarPrimo(int numero) { //poner breakpoint
		boolean primo = true;
		int divisor = 2;
		while (primo && divisor < numero) {
			if (numero % divisor == 0) {
				primo = false;
			}
			divisor++;
		}
		return primo;
	}
}
