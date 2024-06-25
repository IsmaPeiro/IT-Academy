package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class M71Ejercicio1 {
	public static void main(String[] args) {
		/*
		 * Crea un programa que sol·liciti a l'usuari/ària que introdueixi tres nombres
		 * enters per teclat i mostri per pantalla el major dels tres, el menor dels
		 * tres, o si els tres números són iguals.
		 */
	
		ArrayList<Integer> nums=new ArrayList<Integer>();
		
		//introducir 3 numeros
		introNums(nums);
		
		//comparar numeros		
		compareNums (nums);
	}
	
	public static void introNums (ArrayList<Integer> nums) {
		Scanner sc=new Scanner (System.in);
		System.out.println("Introduce el primer número");
		nums.add(sc.nextInt());
		System.out.println("Introduce el segundo número");
		nums.add(sc.nextInt());
		System.out.println("Introduce el tercer número");
		nums.add(sc.nextInt());
	}
	
	public static void compareNums (ArrayList<Integer> nums) {
		int major=nums.get(0), minor=nums.get(0);
		for (int i=1;i<nums.size();i++) {
			if (nums.get(i)>major) {
				major=nums.get(i);
			} else if (nums.get(i)<minor) {
				minor=nums.get(i);
			}
		}
		System.out.println( (minor==major) ? "Los tres números son iguales" : "El número mayor es: "+major+", y el menor: "+minor);
	}
}