package m8Ejercicio6.herencia;

public class ProductoAlimentario  extends Producto {
	private int calorias;

	public ProductoAlimentario(String nombre, int stoc, double precio, int calorias) {
		super(nombre, stoc, precio);
		this.calorias=calorias;
		// TODO Auto-generated constructor stub
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	@Override
	public String toString() {		
		return "Tipo de Producto: Alimentario\nCalorias: " + calorias + "\nID: " + id + "\nNombre: " + nombre + "\nStoc: " + stoc
				+ "\nprecio=" + precio+"\n";
	}
	
	
	
}
