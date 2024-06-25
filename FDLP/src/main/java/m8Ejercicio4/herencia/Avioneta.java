package m8Ejercicio4.herencia;

public class Avioneta extends Avion {
	private int helices;

	public Avioneta(String numVuelo, String marca, String modelo, double longitud, double carga, int helices) {
		super(numVuelo, marca, modelo, longitud, carga);
		this.helices = helices;
	}

	public int getHelices() {
		return helices;
	}

	public double calculaDistancia() {
		return helices*1000;
	}
	
	@Override
	public String toString() {
		return "Avioneta [helices=" + helices + ", numVuelo=" + numVuelo + ", marca=" + marca + ", modelo=" + modelo
				+ ", longitud=" + longitud + ", carga=" + carga + "]";
	}

	@Override
	public int limpiarAvion() {
		//tiempo en minutos para limpiar
		return (int)(longitud*10)/2;
		
	}
	
	

}
