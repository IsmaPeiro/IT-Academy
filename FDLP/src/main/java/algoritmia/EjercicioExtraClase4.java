package algoritmia;

import java.util.Scanner;

public class EjercicioExtraClase4 {

	public static void main(String[] args) {
		int num1;
		int num2;
		String result;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("introduce un número:");
		num1=sc.nextInt();
		
		System.out.print("introduce el segundo número:");
		num2=sc.nextInt();
		
		result=showPairs(num1, num2);
		
		System.out.println(result);
		
	}

	static String showPairs (int num1, int num2) {
		int major=0;
		int minor=0;		
		String result="";
				
		if (num1!=num2) {
			if (num1>num2) {
				major=num1; minor=num2;
			} else {
				major=num2; minor=num1;
			}
			System.out.println("estos son los números pares que hay entre "+major+" y "+minor+".");
			for (int i = major; i >= minor; i--) {
				if (i%2==0) {
					result+=(i==minor||i==minor+1) ? i+"." : i+", ";
				}
			}
			return result;
		} else {
			return "Los dos números son iguales";
		}
	}
}
