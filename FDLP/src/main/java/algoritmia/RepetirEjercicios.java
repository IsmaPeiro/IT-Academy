package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class RepetirEjercicios {

	public static void main(String[] args) {
		/* 
		 * Donat un array de números, el programa ha de mostrar
		 * la suma de tots els nombres parells i la suma de tots els números imparells.
		 */
		
		int[] nums=new int[] {1,2,3};
		
		System.out.println("La suma de los números pares del array es: "+ sumaPares(nums));
		System.out.println("La suma de los números impares del array es: "+ sumaImpares(nums));
	}
	
	public static int sumaPares (int[] nums) {
		int suma=0;
		
		for (int num : nums) {
			if (num%2==0) {
				suma+=num;
			}
		}
		return suma;
	}
	public static int sumaImpares (int[] nums) {
		int suma=0;
		
		for (int num : nums) {
			if (num%2!=0) {
				suma+=num;
			}
		}
		return suma;
	}
}