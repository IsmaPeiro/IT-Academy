package examen.ejercicio3.main;

import java.util.Scanner;
import examen.ejercicio3.herencia.*;

public class Ejercicio3 {

	public static void main(String[] args) {
		/*
		 * Debes desarrollar un menú que permita: · Agregar un nuevo libro y cómic a la
		 * biblioteca. · Agregar un usuario. Si el usuario existe, se informa de que el
		 * usuario ya existe y si no existe, se crea el nuevo usuario. · Eliminar un
		 * usuario. Se introduce el DNI, si el usuario existe, se elimina, y si no
		 * existe se informa de que el usuario no está dado de alta. · Prestar un libro
		 * o cómic a un usuario. Se piden los datos necesarios para poder hacer el
		 * préstamo. (Para poder hacer el préstamo, tiene que existir el usuario y el
		 * libro en cuestión). Si se hace el préstamo, se reduce el número de copias
		 * disponibles del libro o cómic en una unidad. · Devolver un libro o cómic. Se
		 * piden los datos necesarios para poder hacer el préstamo. Se elimina el libro
		 * o cómic por parte del usuario y se incrementa en una unidad las copias
		 * disponibles de ese libro o cómic en la biblioteca. · Mostrar la lista de
		 * usuarios que tienen prestado un libro o cómic específico. Se introduce el
		 * título del libro o cómic y se muestran las personas que lo tienen prestado. ·
		 * Mostrar la lista de los libros y cómics que tiene prestados un usuario. Se
		 * piden los datos necesarios y se muestran los libros y cómics que tiene
		 * prestados el usuario en cuestión.
		 * 
		 */
		Biblioteca biblioteca = new Biblioteca();

		biblioteca.agregarPublicacion(new Libro("Libro1", "autorLibro1", 1999, 20, "LibroPrueba1"));
		biblioteca.agregarPublicacion(new Libro("Libro2", "autorLibro2", 2000, 10, "LibroPrueba2"));
		biblioteca.agregarPublicacion(new Libro("Libro3", "autorLibro3", 1899, 15, "LibroPrueba1"));

		biblioteca.agregarPublicacion(new Comic("Comic1", "autorComic1", 2000, 20, 18));
		biblioteca.agregarPublicacion(new Comic("Comic2", "autorComic2", 2010, 5, 16));
		biblioteca.agregarPublicacion(new Comic("Comic3", "autorComic3", 2020, 8, 13));

		biblioteca.agregarUsuario(new Usuario("Usuario1", "11111111A"));
		biblioteca.agregarUsuario(new Usuario("Usuario2", "22222222B"));
		biblioteca.agregarUsuario(new Usuario("Usuario3", "33333333C"));

		boolean sortir = false;

		do {
			switch (menu()) {
			case 1:
				agregarPublicacion(biblioteca);
				break;
			case 2:
				agregarUsuario(biblioteca);
				break;
			case 3:
				eliminarUsuario(biblioteca);
				break;
			case 4:
				prestar(biblioteca);
				break;
			case 5:
				devolver(biblioteca);
				break;
			case 6:
				mostrarPrestamosPublicacion(biblioteca);
				break;
			case 7:
				mostrarPrestamosUsuario(biblioteca);
				break;
			case 0:
				System.out.println("Gràcies per utilitzar l'aplicació");
				sortir = true;
				break;
			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 7;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("1. Agregar publicación a biblioteca.");
			System.out.println("2. Agregar un usuario.");
			System.out.println("3. Eliminar un usuario.");
			System.out.println("4. Prestar un usuario.");
			System.out.println("5. Devolver publicacion por usuario.");
			System.out.println("6. Mostrar prestamos de una publicación.");
			System.out.println("7. Mostrar prestamos de un usuario.");
			System.out.println("0. Sortir de l'aplicació.\n");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escull una opció vàlida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static void agregarPublicacion(Biblioteca biblioteca) {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Qué tipo de publicacion deseas agregar?");
		System.out.println("1. Libro | 2. Comic | 0. Ninguno");
		opcion = sc.nextInt();
		sc.nextLine();
		switch (opcion) {
		case 1:
			agregarLibro(biblioteca);
			break;
		case 2:
			agregarComic(biblioteca);
			break;
		case 0:
			System.out.println("Gracias, saliendo al menú");
			break;
		default:
			System.out.println("Opción incorrecta.");
		}
	}

	public static void agregarLibro(Biblioteca biblioteca) {
		String titulo = "", genero = "", autor = "";
		int stock = 0, year = 0;

		Publicacion publicacion = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el título del Libro:");
		titulo = sc.nextLine();
		publicacion = biblioteca.buscarPublicacion(titulo);
		if (publicacion == null) {
			System.out.println("Introduce el autor:");
			autor = sc.nextLine();
			System.out.println("Introduce el año:");
			year = sc.nextInt();
			System.out.println("Introduce el stock:");
			stock = sc.nextInt();
			sc.nextLine();
			System.out.println("Introduce el genero:");
			genero = sc.nextLine();
			biblioteca.agregarPublicacion(new Libro(titulo, autor, year, stock, genero));
			System.out.println("Libro agregado correctamente.");
		} else {
			System.out.println("El Libro ya está registrado en la Biblioteca.");
		}
	}

	public static void agregarComic(Biblioteca biblioteca) {
		String titulo = "", autor = "";
		int stock = 0, year = 0, edad = 0;

		Publicacion publicacion = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el título del Comic:");
		titulo = sc.nextLine();
		publicacion = biblioteca.buscarPublicacion(titulo);
		if (publicacion == null) {
			System.out.println("Introduce el autor:");
			autor = sc.nextLine();
			System.out.println("Introduce el año:");
			year = sc.nextInt();
			System.out.println("Introduce el stock:");
			stock = sc.nextInt();
			sc.nextLine();
			System.out.println("Introduce la edad:");
			edad = sc.nextInt();
			biblioteca.agregarPublicacion(new Comic(titulo, autor, year, stock, edad));
			System.out.println("Comic agregado correctamente.");
		} else {
			System.out.println("El Comic ya está registrado en la Biblioteca.");
		}
	}

	public static void agregarUsuario(Biblioteca biblioteca) {
		Scanner sc = new Scanner(System.in);
		String nombre = "", dni = "";
		Usuario usuario = null;

		System.out.println("Introduce el dni del usuario:");
		dni = sc.nextLine();

		usuario = biblioteca.buscarUsuario(dni);
		if (usuario == null) {
			System.out.println("Introduce el nombre del Usuario:");
			nombre = sc.nextLine();
			biblioteca.agregarUsuario(new Usuario(nombre, dni));
			System.out.println("Usuario agregado correctamente.");
		} else {
			System.out.println("El usuario ya está registrado en la biblioteca.");
		}

	}

	public static void eliminarUsuario(Biblioteca biblioteca) {
		Scanner sc = new Scanner(System.in);
		String nombre = "", dni = "";
		Usuario usuario = null;

		System.out.println("Introduce el dni del usuario:");
		dni = sc.nextLine();

		usuario = biblioteca.buscarUsuario(dni);
		if (usuario != null) {
			biblioteca.eliminarPUsuario(usuario);
			System.out.println("Usuario eliminado correctamente.");
		} else {
			System.out.println("El usuario no está registrado en la biblioteca.");
		}

	}

	public static void prestar(Biblioteca biblioteca) {
		Scanner sc = new Scanner(System.in);
		String nombrePublicacion = "", dni = "";

		Usuario usuario = null;
		Publicacion publicacion = null;

		System.out.println("Introduce el dni del usuario:");
		dni = sc.nextLine();
		usuario = biblioteca.buscarUsuario(dni);
		if (usuario != null) {
			System.out.println("Introduce el nombre de la publicación:");
			nombrePublicacion = sc.nextLine();
			publicacion = biblioteca.buscarPublicacion(nombrePublicacion);
			if (publicacion != null) {
				usuario.retirar(publicacion, biblioteca);
			} else {
				System.out.println("La publicación no existe en la biblioteca.");
			}
		} else {
			System.out.println("El usuario no está registrado en la biblioteca.");
		}

	}

	public static void devolver(Biblioteca biblioteca) {
		Scanner sc = new Scanner(System.in);
		String nombrePublicacion = "", dni = "";
		Usuario usuario = null;
		Publicacion publicacion = null;

		System.out.println("Introduce el dni del cliente:");
		dni = sc.nextLine();
		usuario = biblioteca.buscarUsuario(dni);
		if (usuario != null) {
			System.out.println("Introduce el nombre de la publicación:");
			nombrePublicacion = sc.nextLine();
			publicacion = biblioteca.buscarPublicacion(nombrePublicacion);
			if (publicacion != null) {
				usuario.devolver(publicacion, biblioteca);
			} else {
				System.out.println("La publicacion no existe en la bibloteca.");
			}
		} else {
			System.out.println("El usuario no está registrado en la biblioteca.");
		}

	}

	public static void mostrarPrestamosPublicacion(Biblioteca biblioteca) {
		Scanner sc = new Scanner(System.in);
		String nombrePublicacion = "", dni = "";

		Publicacion publicacion = null;

		System.out.println("Introduce el nombre de la publicación:");
		nombrePublicacion = sc.nextLine();
		publicacion = biblioteca.buscarPublicacion(nombrePublicacion);
		if (publicacion != null) {
			for (Usuario usuario : biblioteca.getUsuarios()) {
				if (usuario.buscarPublicacion(nombrePublicacion) != null) {
					System.out.println(usuario);
				}
			}
		} else {
			System.out.println("Ningún usuario tiene en préstamo la publicación.");
		}

	}

	public static void mostrarPrestamosUsuario(Biblioteca biblioteca) {
		Scanner sc = new Scanner(System.in);
		String dni = "";
		Usuario usuario = null;

		System.out.println("Introduce el dni del usuario:");
		dni = sc.nextLine();
		usuario = biblioteca.buscarUsuario(dni);
		if (usuario != null) {
			if (usuario.getPrestados().size()!= 0) {
				System.out.println(usuario.getPrestados());
			} else {
				System.out.println("El usuario no tiene en préstamo ninguna publicación.");
			}
		} else {
			System.out.println("El usuario no existe.");
		}

	}

}
