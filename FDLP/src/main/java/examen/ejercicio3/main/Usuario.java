package examen.ejercicio3.main;
import java.util.ArrayList;

import examen.ejercicio3.herencia.*;

public class Usuario {
	private String nombre;
	private String dni;
	private ArrayList<Publicacion> prestados;
	public Usuario(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.prestados=new ArrayList<Publicacion>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public ArrayList<Publicacion> getPrestados() {
		return prestados;
	}
	public void setPrestados(ArrayList<Publicacion> prestados) {
		this.prestados = prestados;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", prestados=" + prestados + "]";
	}
	
	public void retirar(Publicacion publicacion, Biblioteca biblioteca) {
		if (biblioteca.buscarPublicacion(publicacion.getTitulo()) != null) {
			prestados.add(publicacion);
			if (publicacion.reducirStock(1)) {
				System.out.println("Publicación prestada.");
			} else {
				System.out.println("No hay stock de la publicación.");
			}
		} else {
			System.out.println("la biblioteca no tiene esta publicación.");
		}
	}

	public void devolver(Publicacion publicacion, Biblioteca biblioteca) {
		if (biblioteca.buscarPublicacion(publicacion.getTitulo()) != null) {
			if (buscarPublicacion(publicacion.getTitulo()) != null) {
				prestados.remove(publicacion);
				publicacion.aumentarStock(1);
				System.out.println("Publicacion devuelta correctamente.");
			} else {
				System.out.println("El usuario no tiene esta publicación.");
			}
		} else {
			System.out.println("NO puedes devolver esta publicación, ya no es de la biblioteca.");
		}
	}

	public Publicacion buscarPublicacion(String titulo) {
		Publicacion publicacion = null;
		int i = 0;
		while (publicacion == null && i < prestados.size()) {
			if (prestados.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				publicacion = prestados.get(i);
			}
			i++;
		}
		return publicacion;
	}
}
