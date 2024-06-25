package m8Ejercicio6.herencia;

public class ProductoRopa  extends Producto {
	private int talla;

	public ProductoRopa(String nombre, int stoc, double precio, int talla) {
		super(nombre, stoc, precio);
		this.talla=talla;
		// TODO Auto-generated constructor stub
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}
	
	@Override
	public String toString() {		
		return "Tipo de Producto: Ropa\ntalla: " + talla + "\nID: " + id + "\nNombre: " + nombre + "\nStoc: " + stoc
				+ "\nprecio=" + precio+"\n";
	}
	
}
