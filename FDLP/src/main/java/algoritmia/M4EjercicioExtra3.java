package algoritmia;

import java.util.Scanner;

public class M4EjercicioExtra3 {

	public static void main(String[] args) {
		/*
		 * Aquesta línia de codi: int numRandom = (int)(Math.random() * 3) + 1; Retorna
		 * un número entre l'1 i el 3 de forma aleatòria. Escriu un programa que et
		 * permeti jugar pedra, paper o tisora ​​amb l'ordinador. Per a això l'ordinador
		 * haurà de generar un nombre aleatori entre 1 i 3 que representi pedra, paper o
		 * tisora ​​respectivament, i l'usuari/ària haurà de respondre al seu torn amb
		 * un nombre entre l'1 i el 3 després de mostrar la següent pantalla: Juguem a
		 * pedra, paper o tisora: 1. Pedra 2. Paper 3. Tisora Tria (1-3): Si
		 * l'usuari/ària indica algun nombre diferent del sol·licitat, haurà d'aparèixer
		 * el següent missatge: «Entenc que no vols jugar. Adeu» En cas contrari,
		 * indicar el guanyador/a de la següent manera: Jo xxx i tu xxx. He guanyat!, o
		 * Has guanyat! Segons sigui el cas. Exemple: «Jo paper i tu tisora. Has
		 * guanyat!» NOTA: El paper guanya la pedra perquè l’embolica; les tisores
		 * guanyen el paper perquè el tallen, i la pedra guanya les tisores perquè les
		 * espatllen.
		 */
		
		final int PIEDRA = 1;
		final int PAPEL = 2;
		final int TIJERA = 3;

		int jugadaUser;
		int jugadaPC;
		
		int partidasGanadasUser=0;
		int partidasGanadasPC=0;
		int partidasEmpatadas=0;
				
		String jugadaUserString = "";
		String jugadaPCString = "";

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vamos a jugar unas partidas a \"Piedra, Papel, Tijera\"");
		
		do {
			
			System.out.println("Escoge tu jugada:\n" + "1 - Piedra\n" + "2 - Papel\n" + "3 - Tijera\n" + "0 - Salir");

			jugadaUser = sc.nextInt();
						
			switch (jugadaUser) {
			case 1:
				jugadaUserString = "Piedra";
				break;
			case 2:
				jugadaUserString = "Papel";
				break;
			case 3:
				jugadaUserString = "Tijera";
				break;			
			}

			jugadaPC = (int) (Math.random() * 3) + 1;

			switch (jugadaPC) {
			case 1:
				jugadaPCString = "Piedra";
				break;
			case 2:
				jugadaPCString = "Papel";
				break;
			case 3:
				jugadaPCString = "Tijera";
				break;
			}

			if ((jugadaUser == PIEDRA && jugadaPC == TIJERA) || (jugadaUser == PAPEL && jugadaPC == PIEDRA)
					|| (jugadaUser == TIJERA && jugadaPC == PIEDRA)) {
				System.out.println("He sacado " + jugadaPCString + ", y tu " + jugadaUserString + ". Has ganado");
				partidasGanadasUser++;
			} else if (jugadaUser == jugadaPC) {
				System.out.println("He sacado " + jugadaPCString + ", y tu " + jugadaUserString + ". Hemos empatado");
				partidasEmpatadas++;
			} else if (jugadaUser==0){
				System.out.println("¡¡¡Hasta otra!!!");
				System.out.println("Partidas jugadas: "+(+partidasGanadasUser+partidasGanadasPC+partidasEmpatadas));
				System.out.println("Partidas ganadas por el usuario: "+partidasGanadasUser);
				System.out.println("Partidas ganadas por el PC: "+partidasGanadasPC);
				System.out.println("Partidas empatadas: "+partidasEmpatadas);				
			} else if (jugadaUser<0||jugadaUser>=4){
				System.out.println("jugada no valida");
			} else {
				System.out.println("He sacado " + jugadaPCString + ", y tu " + jugadaUserString + ". Has perdido");
				partidasGanadasPC++;
			}

		} while (jugadaUser != 0);
		sc.close();
	}
}
