package m8Ejercicio4.herencia;

public class JetPrivado extends Avion {
	private int pasajeros;

	public JetPrivado(String numVuelo, String marca, String modelo, double longitud, double carga, int pasajeros) {
		super(numVuelo, marca, modelo, longitud, carga);
		this.pasajeros = pasajeros;
	}

	public int getPasajeros() {
		return pasajeros;
	}	
	
	public double calcularCosteReserva () {
		return 1000*pasajeros;		
	}
	
	@Override
	public int limpiarAvion() {
		//tiempo en minutos para limpiar
		return (int)((longitud*10)/2)+100;		
	}

	@Override
	public String toString() {
		return "JetPrivado [pasajeros=" + pasajeros + ", numVuelo=" + numVuelo + ", marca=" + marca + ", modelo="
				+ modelo + ", longitud=" + longitud + ", carga=" + carga + "]";
	}	

}
