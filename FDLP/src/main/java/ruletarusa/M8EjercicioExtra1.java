package ruletarusa;

import java.util.ArrayList;
import java.util.Scanner;

public class M8EjercicioExtra1 {

	public static void main(String[] args) {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

		// Jugadores de prueba
		Jugador jugador1 = new Jugador("Pepe");
		Jugador jugador2 = new Jugador("Juan");
		Jugador jugador3 = new Jugador("López");
		Jugador jugador4 = new Jugador("Pedro");

		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);

		// introJugadores(jugadores);
		Juego juego = new Juego(jugadores);

		while (juego.finDelJuego() == false) {
			juego.ronda();
		}
	}

	public static void introJugadores(ArrayList<Jugador> jugadores) {
		Scanner sc = new Scanner(System.in);
		int numJugadores;
		String nombre;
		System.out.println("¿Cuantos jugadores tendremos?");
		numJugadores = sc.nextInt();
		sc.nextLine();
		if (numJugadores > 6) {
			System.out.println("El máximo de jugadores es seis, jugaremos con esa cantidad de jugadores.");
			numJugadores = 6;
		}

		for (int i = 1; i <= numJugadores; i++) {
			System.out.println("Introduce el nombre del jugador nº " + i + ":");
			nombre = sc.nextLine();
			jugadores.add(new Jugador(nombre));
		}
	}
}
