package ruletarusa;

import java.util.ArrayList;

public class Juego {
	private ArrayList<Jugador> jugadores;
	private Revolver revolver;

	public Juego(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.revolver = new Revolver();
	}

	public boolean finDelJuego() {
		boolean gameOver = false;
		int i = 0;
		while (!gameOver && i < jugadores.size()) {
			if (!jugadores.get(i).isVivo()) {
				gameOver = true;
			} else {
				i++;
			}
		}
		return gameOver;
	}

	public void ronda() {
		int i = 0;
		boolean muerto = false;
		while (!muerto && i < jugadores.size()) {
			revolver.informa();
			if (jugadores.get(i).jugar(revolver)) {
				System.out.println(
						"El jugador " + jugadores.get(i).getNickName() + " se dispara y no ha muerto en esta ronda.");
				i++;
			} else {
				System.out
						.println("El jugador " + jugadores.get(i).getNickName() + " se dispara y muere en esta ronda.");
				System.out.println("Se acabó el juego.");
				muerto = true;
			}
		}
	}
}
