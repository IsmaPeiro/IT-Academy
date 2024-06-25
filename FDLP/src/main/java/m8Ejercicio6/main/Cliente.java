package m8Ejercicio6.main;

import java.util.ArrayList;

import m8Ejercicio6.herencia.*;

public class Cliente {
	private String nombre;
	private String dni;
	ArrayList<Producto> productosComprados;

	public Cliente(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.productosComprados = new ArrayList<Producto>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public ArrayList<Producto> getProductosComprados() {
		return productosComprados;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setProductosComprados(ArrayList<Producto> productosComprados) {
		this.productosComprados = productosComprados;
	}

	@Override
	public String toString() {
		String retorno = "";
		retorno += "Nombre del Cliente: " + nombre + "\nDNI del Cliente: " + dni + "\n\nProductosComprados:\n";
		for (Producto producto : productosComprados) {
			retorno += producto + "\n";
		}
		return retorno;
	}

	public void comprar(Producto producto, Tienda tienda) {
		if (tienda.buscarProducto(producto.getId()) != null) {
			productosComprados.add(producto);
			if (producto.reducirStoc(1)) {
				System.out.println("Producto comprado.");
			} else {
				System.out.println("No hay stoc del producto.");
			}
		} else {
			System.out.println("la tienda no tiene este producto.");
		}
	}

	public void devolver(Producto producto, Tienda tienda) {
		if (tienda.buscarProducto(producto.getId()) != null) {
			if (buscarProducto(producto.getId()) != null) {
				productosComprados.remove(producto);
				producto.aumentarStoc(1);
				System.out.println("Producto devuelto correctamente.");
			} else {
				System.out.println("El cliente no tiene este producto.");
			}
		} else {
			System.out.println("Ya no puedes devolver este producto.");
		}
	}

	public Producto buscarProducto(int id) {
		Producto producto = null;
		int i = 0;
		while (producto == null && i < productosComprados.size()) {
			if (productosComprados.get(i).getId() == id) {
				producto = productosComprados.get(i);
			}
			i++;
		}
		return producto;
	}

}
