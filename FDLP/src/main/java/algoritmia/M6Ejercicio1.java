package algoritmia;

import java.util.Scanner;

public class M6Ejercicio1 {

	
	public static void main(String[] args) {
		/*
		 * Fer un programa que demani dos números i un operador(+,-,*,/).
		 * Al final, el programa ha d'imprimir per pantalla el resultat
		 * de fer l’operació que contingui la variable operador.
		 * Modificar la calculadora arcaica (M4 Exercici 5).
		 * El programa demana a l’usuari/ària que introdueixi dos números i l’operació que desitja realitzar.
		 * Cada operació (suma, resta, multiplicació, divisió i mòdul) estarà programada en un mètode diferent.
		 */
		char operador;
		float num1;
		float num2;		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce dos números y un operador (+, -, * o /:)");
		
		System.out.println("introduce el primer número:");
		num1=sc.nextFloat();
				
		System.out.println("introduce el segundo número:");		
		num2=sc.nextFloat();
		
		System.out.println("introduce el operador:");
		operador=sc.next().charAt(0);
		
		sc.close();
		
		switch (operador) {
		case '+':
			System.out.println("El resultado de "+num1+operador+num2+" es: "+suma(num1,num2));
			break;
		case '-':
			System.out.println("El resultado de "+num1+operador+num2+" es: "+resta(num1,num2));
			break;
		case '*':
			System.out.println("El resultado de "+num1+operador+num2+" es: "+multiplicacion(num1,num2));
			break;
		case '/':
			System.out.println("El resultado de "+num1+operador+num2+" es: "+division(num1,num2));
			break;
		default:
			System.out.println("los datos introiducidos no son validos");
			break;
		}

	}
	
	static float suma (float num1, float num2) {
		float resultado;
		resultado=num1+num2;
		return resultado;
	}
	
	static float resta (float num1, float num2) {
		float resultado;
		resultado=num1-num2;
		return resultado;
	}
	
	static float multiplicacion (float num1, float num2) {
		float resultado;
		resultado=num1*num2;
		return resultado;
	}
	
	static float division (float num1, float num2) {
		float resultado;
		resultado=num1/num2;
		return resultado;
	}

}
