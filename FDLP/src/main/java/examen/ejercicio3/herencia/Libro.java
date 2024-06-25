package examen.ejercicio3.herencia;

public class Libro extends Publicacion {
	private String genero;

	public Libro(String titulo, String autor, int year, int stock, String genero) {
		super(titulo, autor, year, stock);
		this.genero=genero;
		// TODO Auto-generated constructor stub
	}

	
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Comic [genero=" + genero + ", titulo=" + titulo + ", autor=" + autor + ", year=" + year + ", stock="
				+ stock + "]";
	}
}
