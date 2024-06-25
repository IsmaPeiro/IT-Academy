package cine;

import java.util.ArrayList;

public class Cine {
	private Pelicula pelicula;
	private double precio;
	private String[][] butacasSala;

	private ArrayList<String> butacasOcupadas=new ArrayList<String>();
		
	public Cine(Pelicula pelicula, double precio) {
		this.pelicula = pelicula;
		this.precio = precio;
		this.butacasSala = new String[][] {{"1A","1B","1C","1D","1E"},
										   {"2A","2B","2C","2D","2E"},
										   {"3A","3B","3C","3D","3E"}};
		}	
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public double getPrecio() {
		return precio;
	}

	public String[][] getButacasSala() {
		return butacasSala;
	}
		
	public boolean ocuparButaca(Espectador espectador) {			
		if (butacasOcupadas.size()!=(butacasSala.length*butacasSala[0].length)) {		
			System.out.println("Sentando al espectador " + espectador.getNombre() + ", de " + espectador.getEdad()
					+ " años y con " + espectador.getDinero() + "€.");
			if (espectador.getDinero() >= precio && espectador.getEdad() >= pelicula.getEdadMinima()) {
				entra(espectador);			
			} else {
				noEntra(espectador);
			}
			return false;
		} else {
			System.out.println("La sala está llena.");
			return true;
		}
	}
	
	private void entra (Espectador espectador) {
		int fila;
		int columna;
		
		boolean ocupada = true;
		do {
			fila= (int) Math.floor(Math.random() * butacasSala.length);
			columna= (int) Math.floor(Math.random() * butacasSala[fila].length);
			if (butacasOcupadas.contains(butacasSala[fila][columna])) {
				System.out.println("La butaca " + butacasSala[fila][columna] + " está ocupada, buscando otra butaca");
				ocupada = true;
			} else {
				System.out.println("Sentado en la butaca " + butacasSala[fila][columna] + ".");
				butacasOcupadas.add(butacasSala[fila][columna]);
				ocupada = false;					
			}
		} while (ocupada);
	}
	
	private void noEntra (Espectador espectador) {
		if (espectador.getDinero()>=precio&&espectador.getEdad()<pelicula.getEdadMinima()) {
			System.out.println("El espectador no tiene la edad adecuada.");
		} else if (espectador.getDinero()<precio&&espectador.getEdad()>=pelicula.getEdadMinima()) {
			System.out.println("El espectador no tiene dinero suficiente.");
		} else {
			System.out.println("El espectador no tiene la edad adecuada ni dinero suficiente.");
		}
	}
}
