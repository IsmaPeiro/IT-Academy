package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioExtraClase7 {
	public static void main(String[] args) {
		/*
		 * L’usuari/ària introdueix un nombres per teclat fins
		 * eur introdueixi un que forma part de la seucessió de fibonacci
		 * 
		 */

		inputNum();
	}

	public static void inputNum() {
		int num;
		Scanner sc = new Scanner(System.in);
		boolean found=false;
		System.out.println("Introduce números hasta que uno forme parte de la sucesión de Fibonacci");
		do {
			num = sc.nextInt();
			found=checkFibonacci(num);
			if (found) {
				System.out.println(num+" forma parte de la sucesión de Fibonacci");
			}
			else {
				System.out.println(num+" no forma parte de la sucesión de Fibonacci");
			}
		} while (!found);		
	}

	public static boolean checkFibonacci(int num) {
		
		int i=0;
		boolean stop=false;	
		boolean found=false;	
		ArrayList<Integer> fibonacci = new ArrayList<Integer>();
		
		while (!stop) {			
			if (i == 0 || i == 1) {
				fibonacci.add(i);
				
			} else {
				fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));				
			}
			if (fibonacci.get(i)>num) {found=false;stop=true;}
			if (fibonacci.get(i)==num) {found=true;stop=true;}
			i++;
		}
		return found;
	}
}