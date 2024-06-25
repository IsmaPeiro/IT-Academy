package algoritmia;

import java.util.ArrayList;
import java.util.Scanner;

public class M73Ejercicio5 {

	public static void main(String[] args) {
		/*
		 * Donat un arraylist de paraules introduïdes per l’usuari/ària.
		 * Digues el nombre de paraules que contenen la lletra ‘a’ i mostra-les per pantalla.
		 */
		
		ArrayList<String> words=new ArrayList<String>();
				
		inputWords (words);
		countWordsWithA2 (words);
		
	}
	public static void inputWords (ArrayList<String> words) {
		Scanner sc=new Scanner(System.in);
		String word;
		do {
			System.out.println("Introduce una palabra o fin para terminar:");
			word=sc.nextLine();
			if (!word.equalsIgnoreCase("fin")) {
				words.add(word);
			}
		} while (!word.equalsIgnoreCase("fin"));
		
	}
	
	
	public static void countWordsWithA (ArrayList<String> words) {
		boolean containsA;
		ArrayList<String> wordsWithA=new ArrayList<String>();
		int z;
		
		for (String word : words) {			
			System.out.println(word);
			containsA=false;
			z=0;
			while (!containsA&&z<word.length()) {
				if (word.charAt(z)=='a') {
					wordsWithA.add(word);
					containsA=true;
				}
				z++;
			}
		}
		
		
		System.out.println("Hay "+wordsWithA.size()+" palabras que contienen a");
		for (String word : wordsWithA) {
			System.out.println(word);
		}
	}	
	
	public static void countWordsWithA2 (ArrayList<String> words) {
		ArrayList<String> wordsWithA=new ArrayList<String>();
		
		for (String word : words) {			
			if (word.toLowerCase().contains("a")) {
				wordsWithA.add(word);
			}			
		}		
		System.out.println("Hay "+wordsWithA.size()+" palabras que contienen a");
		for (String word : wordsWithA) {
			System.out.println(word);
		}
	}
}
