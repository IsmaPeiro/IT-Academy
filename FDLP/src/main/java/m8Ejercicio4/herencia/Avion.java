package m8Ejercicio4.herencia;

public abstract class Avion {
	protected String numVuelo;
	protected String marca;
	protected String modelo;
	protected double longitud; //en metros
	protected double carga; // emn Kg

	public Avion(String numVuelo, String marca, String modelo, double longitud, double carga) {
		this.numVuelo = numVuelo;
		this.marca = marca;
		this.modelo = modelo;
		this.longitud = longitud;
		this.carga = carga;
	}

	public String getNumVuelo() {
		return numVuelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public double getLongitud() {
		return longitud;
	}

	public double getCarga() {
		return carga;
	}

	@Override
	public String toString() {
		return "Avion [numVuelo=" + numVuelo + ", marca=" + marca + ", modelo=" + modelo + ", longitud=" + longitud
				+ ", carga=" + carga + "]";
	}

	public abstract int limpiarAvion();

	public double consumo() {
		//consumo en litros
		return longitud * carga;
	}

}
