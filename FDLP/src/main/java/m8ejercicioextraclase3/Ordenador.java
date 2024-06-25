package m8ejercicioextraclase3;

public class Ordenador {
	/*
	 * Clase Ordenador, además de la clase Main
	 * El ordenador tendrá: marca, modelo, procesador, ram y disco duro
	 * en el main creáis 5 ordenadores
	 */
	
	private String marca;
	private String modelo;
	private String procesador;
	private int ram;
	private int hd;
	
	public Ordenador(String marca, String modelo, String procesador, int ram, int hd) {		
		this.marca = marca;
		this.modelo = modelo;
		this.procesador = procesador;
		this.ram = ram;
		this.hd = hd;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getProcesador() {
		return procesador;
	}

	public int getRam() {
		return ram;
	}

	public int getHd() {
		return hd;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	@Override
	public String toString() {
		return "Ordenador [marca=" + marca + ", modelo=" + modelo + ", procesador=" + procesador + ", ram=" + ram
				+ " MB, hd=" + hd + " GB]";
	}	
}
