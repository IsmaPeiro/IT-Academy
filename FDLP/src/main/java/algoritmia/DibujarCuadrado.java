package algoritmia;

import java.util.Scanner;

public class DibujarCuadrado {

	public static void main(String[] args) {
		int num;
		char character;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("introduce la longirud de los lados:");
		num=sc.nextInt();
		sc.nextLine();
		
		System.out.print("introduce el carácter con el que dibujarlo:");
		character=sc.nextLine().charAt(0);
		
		for (int i=0;i<num;i++) {
			if (i==0||i==num-1) {
			for (int z=0; z<num;z++) {
				System.out.print(character+" ");
			}
			} else {
				System.out.print(character+" ");
				for (int z=1; z<num-1;z++) {
					System.out.print((z==num-1) ? " " : "  ");
				}
				System.out.print(character);
			}
			System.out.println();
		}
	}
}