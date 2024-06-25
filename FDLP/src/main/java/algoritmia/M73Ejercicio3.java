package algoritmia;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class M73Ejercicio3 {

	public static void main(String[] args) {
		/*
		 * L’usuari/ària ha d’introduir una frase i el programa ha de dir si la frase és
		 * un palíndrom.
		 */
		Scanner sc = new Scanner(System.in);
		String text;

		System.out.println("Introduce un texto para ver si es un palíndromo:");
		text = sc.nextLine();
		isPalindrome(text);
	}

	public static void isPalindrome(String text) {
		text = text.toLowerCase();
		text = text.replace(" ", "");
		int length = text.length() - 1;
		int size = text.length() / 2;
		boolean isPalindrome = true;
		int i = 0;

		while (isPalindrome && size > i) {
			if (text.charAt(i) != text.charAt(length - i)) {
				isPalindrome = false;
			}
			i++;
		}

		if (isPalindrome) {
			System.out.println("Es un palidromo");
		} else {
			System.out.println("No s un palidromo");
		}
	}

	public static void isPalindrome2(String text) {
		String reverse = "";
		String noBlanksText = "";

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != ' ') {
				noBlanksText += text.charAt(i);
			}
		}

		for (int i = noBlanksText.length() - 1; i >= 0; i--) {
			reverse += noBlanksText.charAt(i);
		}

		if (reverse.equalsIgnoreCase(noBlanksText)) {
			System.out.println("Es un palidromo");
		} else {
			System.out.println("No es un palíndromo");
		}
	}

	public static void isPalindrome3(String text) {
		text = text.replace(" ", "");
		String reverse = "";

		for (int i = text.length() - 1; i >= 0; i--) {
			reverse += text.charAt(i);
		}

		if (reverse.equalsIgnoreCase(text)) {
			System.out.println("Es un palidromo");
		} else {
			System.out.println("No es un palíndromo");
		}
	}
}