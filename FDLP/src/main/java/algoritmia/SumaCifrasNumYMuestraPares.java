/*
 * Escriu un programa que, donat un nombre enter de tipus l on g, de més de 7 xifres, digui
 * quins són i quant sumen els dígits parells. 
 * Els dígits parells s'han de mostrar en ordre, de esquerra a dreta. 
 * Exemple: 
 * Introduexi un nombre enter positiu : 94026782 
 * Dígits parells : 4 0 2 6 8 2 
 * Suma dels dígits parells: 22
 */
package algoritmia;

import java.util.ArrayList;

public class SumaCifrasNumYMuestraPares {
	public static void main(String[] args) {	
		long num = 94026782;
		int sumaPares=0;
		
		//Forma 1: usando un ArrayList para la salida de los números pares
		ArrayList<Long> pares=new ArrayList<Long>();
		
		//Forma 2: usando un string para la salida de los números pares
		String listaPares="";
		
		while (num!=0) {
			if ((num%10)%2==0) {
				sumaPares+=num%10;
				listaPares=num%10+" "+listaPares; //Forma 1
				pares.add(0, num%10); //Forma 2
			}
			num=num/10;
		}
		
		//Salida de los números pares usando un String
		System.out.println("Digitos pares: "+listaPares);
		
		//Salida de los números pares usando un ArrayList
		System.out.print("Digitos pares: ");
		for (Long par : pares) {
			System.out.print(par+" ");
		}
		System.out.println();
		
		//Salida de la suma de los pares
		System.out.println("La suma de los digitos pares es: "+sumaPares);		
		}
	}

