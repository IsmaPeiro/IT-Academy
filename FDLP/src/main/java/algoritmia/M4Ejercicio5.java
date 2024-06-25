package algoritmia;

import java.util.Scanner;

public class M4Ejercicio5 {

	public static void main(String[] args) {
		/*
		 * Fer un programa que demani dos números i un operador(+,-,*,/).
		 * Al final, el programa ha d'imprimir per pantalla el resultat
		 * de fer l’operació que contingui la variable operador.
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
			System.out.println("El resultado de "+num1+operador+num2+" es: "+(num1+num2));
			break;
		case '-':
			System.out.println("El resultado de "+num1+operador+num2+" es: "+(num1-num2));
			break;
		case '*':
			System.out.println("El resultado de "+num1+operador+num2+" es: "+(num1*num2));
			break;
		case '/':
			System.out.println((num2!=0) 
					? "El resultado de "+num1+operador+num2+" es: "+(num1/num2)
					: "No se puede dividir por 0");
			break;
		default:
			System.out.println("los datos introiducidos no son validos");
			break;
		}

	}

}
