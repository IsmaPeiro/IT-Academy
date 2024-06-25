package m8ejercicio5;

import java.util.Objects;

public class Circulo {
	private Punto centro;
	private int radio;

	public Circulo(Punto centro, int radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public Punto getCentro() {
		return centro;
	}

	public int getRadio() {
		return radio;
	}

	public double distanciaCentros(Circulo circulo) {
		int distanciaX;
		int distanciaY;
		double distancia;
		distanciaX = Math.abs(centro.getPosicionX() - circulo.getCentro().getPosicionX());
		distanciaY = Math.abs(centro.getPosicionY() - circulo.getCentro().getPosicionY());
		distancia = Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
		return distancia;
	}

	public boolean equals(Circulo circulo) {
		if (centro.equals(circulo.getCentro())&& radio == circulo.getRadio()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean sonConcentricos(Circulo circulo) {
		if (centro.equals(circulo.getCentro())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean tienenIgualRadio(Circulo circulo) {
		if (radio == circulo.getRadio()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean sonTangentes(Circulo circulo) {
		if ((radio + circulo.getRadio() == distanciaCentros(circulo)||
			Math.abs(radio - circulo.getRadio()) == distanciaCentros(circulo))&&
			distanciaCentros(circulo)!=0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean sonSecantes(Circulo circulo) {
		if (distanciaCentros(circulo)<radio+circulo.getRadio()&&distanciaCentros(circulo)>Math.abs(radio-circulo.getRadio())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean noSeTocan(Circulo circulo) {
		if (!sonTangentes(circulo) && !sonSecantes(circulo) && !equals(circulo)) {
			return true;
		} else {
			return false;
		}
	}

	

}
