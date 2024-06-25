package m8Ejercicio6.herencia;

public class ProductoElectronico extends Producto {
	private int consumoKW;

	public ProductoElectronico(String nombre, int stoc, double precio, int consumoKW) {
		super(nombre, stoc, precio);
		this.consumoKW=consumoKW;
		// TODO Auto-generated constructor stub
	}

	public int getConsumoKW() {
		return consumoKW;
	}

	public void setConsumoKW(int consumoKW) {
		this.consumoKW = consumoKW;
	}

	@Override
	public String toString() {
		return "Tipo de Producto: Electronico\nConsumo en KW: " + consumoKW + "\nID: " + id + "\nNombre: " + nombre + "\nStoc: " + stoc
				+ "\nprecio=" + precio+"\n";
	}
}
