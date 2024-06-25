package examen.ejercicio3.herencia;

public class Comic extends Publicacion {
	private int edad;

	public Comic(String titulo, String autor, int year, int stock, int edad) {
		super(titulo, autor, year, stock);
		this.edad=edad;
		// TODO Auto-generated constructor stub
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Libro [edad=" + edad + ", titulo=" + titulo + ", autor=" + autor + ", year=" + year + ", stock=" + stock
				+ "]";
	}
	
	
}
