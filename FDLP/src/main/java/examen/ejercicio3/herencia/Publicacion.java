package examen.ejercicio3.herencia;

public class Publicacion {
	protected String titulo;
	protected String autor;
	protected int year;
	protected int stock;
	
	public Publicacion(String titulo, String autor, int year, int stock) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.year = year;
		this.stock = stock;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Publicacion [titulo=" + titulo + ", autor=" + autor + ", year=" + year + ", stock=" + stock + "]";
	}
	
	public boolean aumentarStock (int cantidad) {
		if (cantidad<0) {
			return false;
		} else {
			stock+=cantidad;
			return true;
		}
	}
	
	public boolean reducirStock (int cantidad) {
		if (cantidad>stock) {
			return false;
		} else {
			stock-=cantidad;
			return true;
		}
	}
}
