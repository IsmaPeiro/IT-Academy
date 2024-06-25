package examen.ejercicio3.main;

import java.util.ArrayList;

import examen.ejercicio3.herencia.*;

public class Biblioteca {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Publicacion> fondo;
	
	public Biblioteca() {
		super();
		this.usuarios = new ArrayList<Usuario>();
		this.fondo = new ArrayList<Publicacion>();
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Publicacion> getPublicaciones() {
		return fondo;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.fondo = publicaciones;
	}

	@Override
	public String toString() {
		return "Biblioteca [usuarios=" + usuarios + ", publicaciones=" + fondo + "]";
	}
	
	public void agregarUsuario (Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void eliminarPUsuario (Usuario usuario) {
		usuarios.remove(usuario);
	}
	
	public void agregarPublicacion (Publicacion publicacion) {
		fondo.add(publicacion);
	}
	
	public void eliminarPublicacion (Publicacion publicacion) {
		fondo.remove(publicacion);
	}
	
	public Publicacion buscarPublicacion (String titulo) {
		int i=0;
		Publicacion publicacion=null;
		
		while (publicacion==null&&i<fondo.size()) {
			if (fondo.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				publicacion=fondo.get(i);				
			}
			i++;
		}
		return publicacion;
	}
	
	public Usuario buscarUsuario (String dni) {
		int i=0;
		Usuario usuario=null;
		while (usuario==null&&i<usuarios.size()) {
			if (usuarios.get(i).getDni().equalsIgnoreCase(dni)) {
				
				usuario=usuarios.get(i);				
			}
			i++;
		}
		return usuario;
	}
}
