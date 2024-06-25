package m8ejercicio5;

import java.util.Objects;

public class Punto {
	private int posicionX;
	private int posicionY;
	
	public Punto(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}
	
	public boolean equals (Punto punto) {
		if (posicionX==punto.getPosicionX()&&posicionY==punto.getPosicionY()) {
			return true;
		} else {
			return false;
		}
	}	
}
