package m8Ejercicio6.herencia;

public class Producto {
	protected final int id;
	protected static int contador=1;
	protected String nombre;
	protected int stoc;
	protected double precio;
	
	public Producto(String nombre, int stoc, double precio) {
		this.id = contador++;
		this.nombre = nombre;
		this.stoc = stoc;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public static int getContador() {
		return contador;
	}

	public String getNombre() {
		return nombre;
	}

	public int getStoc() {
		return stoc;
	}

	public double getPrecio() {
		return precio;
	}

	public static void setContador(int contador) {
		Producto.contador = contador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setStoc(int stoc) {
		this.stoc = stoc;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {		
		return "ID: " + id + "\nNombre: " + nombre + "\nStoc: " + stoc + "\nprecio=" + precio+"\n";
	}
	
	public boolean aumentarStoc (int cantidad) {
		if (cantidad<0) {
			return false;
		} else {
			stoc+=cantidad;
			return true;
		}
	}
	
	public boolean reducirStoc (int cantidad) {
		if (cantidad>stoc) {
			return false;
		} else {
			stoc-=cantidad;
			return true;
		}
	}
}
