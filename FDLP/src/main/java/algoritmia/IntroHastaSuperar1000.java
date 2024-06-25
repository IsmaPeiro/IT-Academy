package algoritmia;

import java.util.Scanner;

public class IntroHastaSuperar1000 {

	public static void main(String[] args) {
		/*
		 * Escriu un programa que permeti anar introduint una sèrie indeterminada de nombres 
		 * mentre la seva suma no superi el valor 10000. Quan això últim passi, s'ha de mostrar el total 
		 * acumulat, el comptador dels nombres introduïts i la mitjana
		 */
		Scanner sc=new Scanner(System.in);
		int num=0, suma=0, contador=0;
		
		while (suma<=1000) {
			System.out.println("Introduce un número:");			
			num=sc.nextInt();
			contador++;
			suma+=num;			
		}
		
		System.out.println("El total acumulado es: "+suma);
		System.out.println("Has introducido "+contador+" números");
		System.out.println("La media es: "+suma/contador);		
	}

}
