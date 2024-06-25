package algoritmia;

import java.util.Scanner;

public class M3Ejercicio2 {
	public static void main(String[] args) {
		/*
		 * Fer un programa que li demani dos números sencers a l’usuari/ària. Al final,
		 * el programa imprimeix per pantalla el següent missatge: El resultat de la
		 * suma és: “valor” El resultat de la resta és: “valor” El resultat de la
		 * multiplicació és: “valor” El resultat de la divisió és: “valor”.
		 */
		
		float num1, num2;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce el primer número:");
		num1=sc.nextFloat();
		
		System.out.println("Introduce el segundo número:");
		num2=sc.nextFloat();
		
		sc.close();
	
		System.out.println("El resultado de la suma es: "+(num1+num2));
		System.out.println("El resultado de la resta es: "+(num1-num2));
		System.out.println("El resultado de la multiuplicación es: "+(num1*num2));
		System.out.println("El resultado de la división es: "+(num1/num2));
	}
}
