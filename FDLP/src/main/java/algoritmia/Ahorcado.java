package algoritmia;

//import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ahorcado {

	public static void main(String[] args) throws InterruptedException {

		intro();
		initGame();

	}

	public static void initGame() {
		final String[] WORD = new String[] {"Palabra","Prueba","Java","Juego","Algo"};
		String word=WORD[(int) (Math.random() * WORD.length)];
		final int ATTEMPS = 10;
		int misstakes = 0;
		int LettersFounds = 0;
		char control[];
		ArrayList<Character> lettersUsed = new ArrayList<Character>();

		control = initArray(word);
		do {
			
			misstakes=showInterface(control, misstakes, ATTEMPS, lettersUsed, word);			
			

			clearScreen();

			LettersFounds = countFounds(control);

		} while (!endGame(control, ATTEMPS, misstakes, LettersFounds, word));
	}

	public static char[] initArray(String word) {
		char array[] = new char[word.length()];

		for (int i = 0; i < array.length; i++) {
			array[i] = '_';
		}

		return array;
	}

	public static int showInterface(char[] control, int misstakes, int attemps, ArrayList<Character> lettersUsed, String word) {
		System.out.println("te quedan " + (attemps - misstakes) + " intentos.");
		System.out.println("Has usado las letras: " + lettersUsed);
		showControl(control);
		System.out.println();
		drawQueco(misstakes);
		System.out.println();
		if (!inputLetter(control, word, lettersUsed)) {
			misstakes++;
		}
		return misstakes;
	}

	public static void showControl(char[] control) {
		for (int i = 0; i < control.length; i++) {
			System.out.print(control[i] + " ");
		}
	}

	public static boolean inputLetter(char[] control, String word, ArrayList<Character> lettersUsed) {
		char character;
		boolean found = false;
		Scanner sc = new Scanner(System.in);
		do {
			// System.out.println();
			System.out.println("introduce una letra:");
			character = sc.next().toUpperCase().charAt(0);

			for (int i = 0; i < word.length(); i++) {
				if (word.toUpperCase().charAt(i) == character) {
					control[i] = character;
					found = true;
				}
			}
		} while (!checkLetter(character, lettersUsed));

		return found;
	}

	public static boolean checkLetter(char character, ArrayList<Character> lettersUsed) {
		if (Character.isLetter(character) && !lettersUsed.contains(character)) {
			lettersUsed.add(character);
			return true;
		} else if (lettersUsed.contains(character)) {
			System.out.println("Ya has usado esta letra.");
			return false;
		} else {
			System.out.println("Has de introducir una letra válida.");
			return false;
		}
	}

	public static int compareArrays(int misstakes, char[] control, char[] player) {
		boolean diference = true;
		int i = 0;

		while (diference && i < control.length) {
			if (control[i] != player[i]) {
				diference = true;
			}
		}
		if (!diference) {
			misstakes++;
		}
		return misstakes;
	}

	public static int countFounds(char[] player) {
		int counter = 0;
		for (int i = 0; i < player.length; i++) {
			if (player[i] != '_') {
				counter++;
			}
		}
		return counter;
	}

	public static boolean endGame(char[] control, int attemps, int misstakes, int lettersFound, String word) {
		boolean endGame = false;
		Scanner sc = new Scanner(System.in);

		if (attemps == misstakes) {
			showControl(control);
			System.out.println();
			System.out.println("No has completado la palabra y has muerto.");
			drawQueco(misstakes);
			endGame = true;
		} else if (lettersFound == word.length()) {
			showControl(control);
			System.out.println();
			System.out.println("has completado la palabra antes de morir.");
			drawQueco(12);
			endGame = true;
		}
		if (endGame == true) {
			reStart();
		}
		return endGame;
	}

	public static void reStart() {
		String response = "";
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("¿Quieres volver a jugar? (S/N)");
			response = sc.next();
			if (response.matches("([Ss])")) {
				System.out.println("Perfecto, vamos allá.");
				initGame();
			} else if (response.matches("([Nn])")) {
				System.out.println("Muchas gracias por jugar.");
			} else {
				System.out.println("Introduce una opción válida.");
			}
		} while (!response.matches("([SsNn])"));
	}

	public static void clearScreen() {
		/*
		 * try { if (System.getProperty("os.name").contains("Windows")) new
		 * ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); else
		 * Runtime.getRuntime().exec("clear"); } catch (IOException |
		 * InterruptedException ex) {
		 * 
		 * }
		 */
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	public static void drawQueco(int misstakes) {
		String queco = "";		
		
		String queco12=  "00000000000000\n" + 
						 "00000000000000\n" +
						 "00100011100100\n" +
						 "00100011100100\n" +
						 "00001001001000\n" + 
						 "00000111110000\n" + 
						 "00000001000000\n" + 
						 "00000001000000\n" + 
						 "00000010100000\n"	+
						 "00000100010000\n" +
						 "00001000001000\n" +
						 "00000000000000\n" +
						 "00000000000000\n";
		
		String queco11 = "11111111000000\n" + 
						 "10000001000000\n" +
						 "10000011100000\n" +
						 "10000011100000\n" +
						 "10111111111100\n" + 
						 "101VAMOS00A100\n" + 
						 "101JUGAR0AL100\n" + 
						 "101AHORCADO100\n" + 
						 "10111111111100\n"	+
						 "10000100010000\n" +
						 "10001000001000\n" +
						 "10000000000000\n" +
						 "11111111111111\n";
		String queco10 = "11111111000000\n" + 
						 "10000001000000\n" +
						 "10000011100000\n" +
						 "10000011100000\n" +
						 "10000001000000\n" + 
						 "10111111111110\n" + 
						 "10000001000000\n" + 
						 "10000001000000\n" + 
						 "10000010100000\n"	+
						 "10000100010000\n" +
						 "10001000001000\n" +
						 "10000000000000\n" +
						 "11111111111111\n";

		String queco09 = "11111111000000\n" +
						 "10000001000000\n" +
						 "10000011100000\n" +
						 "10000011100000\n" +
						 "10000001000000\n" +
						 "10111111111110\n" +
						 "10000001000000\n" +
						 "10000001000000\n" +
						 "10000000100000\n"	+ 
						 "10000000010000\n" +
						 "10000000001000\n" +
						 "10000000000000\n" +
						 "11111111111111\n";

		String queco08 = "11111111000000\n" +
						 "10000001000000\n" +
					     "10000011100000\n" +
						 "10000011100000\n"	+
					     "10000001000000\n" +
						 "10111111111110\n" +
					     "10000001000000\n" +
						 "10000001000000\n" +
					     "10000000000000\n"	+
						 "10000000000000\n" +
					     "10000000000000\n" +
						 "10000000000000\n" +
					     "11111111111111\n";

		String queco07 = "11111111000000\n" +
				         "10000001000000\n" +
				         "10000011100000\n" +
				         "10000011100000\n"	+
				         "10000001000000\n" +
				         "10000001111110\n" +
				         "10000001000000\n" +
				         "10000001000000\n" +
				         "10000000000000\n"	+
				         "10000000000000\n" +
				         "10000000000000\n" +
				         "10000000000000\n" +
				         "11111111111111\n";

		String queco06 = "11111111000000\n" +
						 "10000001000000\n" +
						 "10000011100000\n" +
						 "10000011100000\n"	+
						 "10000001000000\n" +
						 "10000001000000\n" +
						 "10000001000000\n" +
						 "10000001000000\n" +
						 "10000000000000\n"	+
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "11111111111111\n";

		String queco05 = "11111111000000\n" +
						 "10000001000000\n" +
						 "10000011100000\n" +
						 "10000011100000\n" +
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n"	+
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "11111111111111\n";

		String queco04 = "11111111000000\n" +
				         "10000001000000\n" +
				         "10000000000000\n" +
				         "10000000000000\n"	+
				         "10000000000000\n" +
				         "10000000000000\n" +
				         "10000000000000\n" +
				         "10000000000000\n" +
				         "10000000000000\n" +
				         "10000000000000\n" +
				         "10000000000000\n" +
				         "10000000000000\n" +
				         "11111111111111\n";

		String queco03 = "11111111000000\n" +
						 "10000000000000\n" +
				         "10000000000000\n" +
						 "10000000000000\n"	+
				         "10000000000000\n" +
						 "10000000000000\n" + 
				         "10000000000000\n" +
						 "10000000000000\n" +
				         "10000000000000\n"	+
						 "10000000000000\n" + 
				         "10000000000000\n" +
						 "10000000000000\n" +
				         "11111111111111\n";

		String queco02 = "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n"	+
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n"	+
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "10000000000000\n" +
						 "11111111111111\n";

		String queco01 = "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n"	+
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n"	+
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "11111111111111\n";
	
		String queco00 = "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n"	+
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n"	+
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n" +
						 "00000000000000\n";

		switch (misstakes) {
		case 0:
			queco = queco00;
			break;
		case 1:
			queco = queco01;
			break;
		case 2:
			queco = queco02;
			break;
		case 3:
			queco = queco03;
			break;
		case 4:
			queco = queco04;
			break;
		case 5:
			queco = queco05;
			break;
		case 6:
			queco = queco06;
			break;
		case 7:
			queco = queco07;
			break;
		case 8:
			queco = queco08;
			break;
		case 9:
			queco = queco09;
			break;
		case 10:
			queco = queco10;
			break;
		case 11:
			queco = queco11;
			break;
		case 12:
			queco = queco12;
			break;
		}
		
		
		queco = queco.replace('1', '█');
		queco = queco.replace('0', ' ');
		System.out.println();
		System.out.print(queco);
	}
	
	public static void intro () throws InterruptedException {
		for (int i=0; i<=10; i++) {
			drawQueco (i);
			Thread.sleep(1 * 250);
			clearScreen();
		}
		drawQueco (11);
		Thread.sleep(1 * 1000);
		clearScreen();
	}
	

}