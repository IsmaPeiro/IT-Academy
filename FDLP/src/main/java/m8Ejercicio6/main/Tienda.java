package m8Ejercicio6.main;

import m8Ejercicio6.herencia.*;
import java.util.ArrayList;

public class Tienda {
	private final int id;
	private static int contador=1;
	private String nombreTienda;
	private ArrayList<Cliente> clientesTienda;
	private ArrayList<Producto> productosTienda;	
	
	public Tienda() {
		this.id = contador++;
		this.nombreTienda="Tienda"+id;
		this.clientesTienda = new ArrayList<Cliente>();
		this.productosTienda = new ArrayList<Producto>();
	}
		
	public String getNombreTienda() {
		return nombreTienda;
	}


	public int getId() {
		return id;
	}
	public ArrayList<Cliente> getClientesTiensa() {
		return clientesTienda;
	}
	public ArrayList<Producto> getProductosTienda() {
		return productosTienda;
	}
	public void setClientesTiensa(ArrayList<Cliente> clientesTiensa) {
		this.clientesTienda = clientesTiensa;
	}
	public void setProductosTienda(ArrayList<Producto> productosTienda) {
		this.productosTienda = productosTienda;
	}
	
	@Override
	public String toString() {
		String retorno="";
		retorno="Nombre de la Tienda: "+nombreTienda+"\n";
		retorno="Id de la Tienda: "+id+"\n";
		retorno+="Clientes de la tienda:\n\n";
		for (Cliente cliente : clientesTienda) {
			retorno+=cliente+"\n";
		}
		retorno+="Productos de la tienda:\n\n";
		for (Producto producto : productosTienda) {
			retorno+=producto+"\n";
		}
		
		return retorno;
	}
	
	public void registrarCliente (Cliente cliente) {
		clientesTienda.add(cliente);		
	}
	
	public void eliminarCliente (Cliente cliente) {		
			clientesTienda.remove(cliente);			 		
	}
	
	public void registrarProducto (Producto producto) {		
			productosTienda.add(producto);			
		} 
	
	
	public void eliminarProducto (Producto producto) {		
			productosTienda.remove(producto);			
	}
	
	public Cliente buscarCliente (String dni) {
		int i=0;
		Cliente cliente=null;
		while (cliente==null&&i<clientesTienda.size()) {
			if (clientesTienda.get(i).getDni().equalsIgnoreCase(dni)) {
				cliente=clientesTienda.get(i);
			}
			i++;
		}
		return cliente;
	}
	
	public Producto buscarProducto (int id) {
		int i=0;
		Producto producto=null;
		while (producto==null&&i<productosTienda.size()) {
			if (productosTienda.get(i).getId()==id) {
				producto=productosTienda.get(i);
			}
			i++;
		}
		return producto;
	}
	
	public Producto buscarProductoPorNombre (String nombre) {
		int i=0;
		Producto producto=null;
		while (producto==null&&i<productosTienda.size()) {
			if (productosTienda.get(i).getNombre().equalsIgnoreCase(nombre)) {
				producto=productosTienda.get(i);
			}
			i++;
		}
		return producto;
	}
}
