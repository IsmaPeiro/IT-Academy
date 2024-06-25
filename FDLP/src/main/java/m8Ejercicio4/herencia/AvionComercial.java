package m8Ejercicio4.herencia;

public class AvionComercial extends Avion {
	private int pasajeros;

	public AvionComercial(String numVuelo, String marca, String modelo, double longitud, double carga, int pasajeros) {
		super(numVuelo, marca, modelo, longitud, carga);
		this.pasajeros = pasajeros;
	}

	public int getPasajeros() {
		return pasajeros;
	}

	public double calcularCosteComida() {
		return pasajeros*10;
	}
	
	@Override
	public int limpiarAvion() {
		//tiempo en minutos para limpiar
		return (int)(longitud*10)+240;
		
	}

	@Override
	public String toString() {
		return "AvionComercial [pasajeros=" + pasajeros + ", numVuelo=" + numVuelo + ", marca=" + marca + ", modelo="
				+ modelo + ", longitud=" + longitud + ", carga=" + carga + "]";
	}
	
	
}
