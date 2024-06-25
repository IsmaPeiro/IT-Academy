package algoritmia;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class M71Ejercicio7 {

	public static void main(String[] args) {
		/*
		 * Fer un programa on l’usuari/ària introdueix per pantalla un caràcter i un
		 * número. El programa imprimeix per pantalla un quadrat amb la mida i el
		 * caràcter introduïts per l’usuari/ària.
		 */
		int side;
		char character;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Introduce el lado del cuadrado: ");
			side = sc.nextInt();
			} while (!checkSide(side));

		System.out.print("Introduce el símbolo con el que formar el cuadrado: ");
		character = sc.next().charAt(0);

		showSquare(side, character);
	}
	
	public static boolean checkSide(int side) {
		if (side <= 0) {
			System.out.println("El lado ha de ser mayor que 0.");
		}
		return side > 0;
	}
	
	public static void showSquare (int side, char character) {
		for (int i=0; i<side; i++) {
			for (int z=0; z<side; z++) {
				System.out.print(character+" ");
			}
			System.out.println();
		}
	}
}
