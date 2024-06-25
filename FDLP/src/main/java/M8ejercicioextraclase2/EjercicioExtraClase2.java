package M8ejercicioextraclase2;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioExtraClase2 {

	public static void main(String[] args) {
		/*
		 * crear una claase Alumno con los atributos Nombre, apellido, edad y DNI todos
		 * los Getters y Setters menos setDni método toString y un metodo birthday que
		 * sume uno a la edad Le pedimos al usuario cuántos alumnos quiere crear?
		 * instanciamos el número de alumnos que nos ha pedido Los guardamos en un
		 * arraylist Después los mostramos todos por consola
		 */
		Scanner sc = new Scanner(System.in);
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		int numAlumnos;
		String nombre;
		String apellido;
		int edad;
		String dni;

		System.out.println("¿Cuantos aLumnos quieres introducir?");
		numAlumnos = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numAlumnos; i++) {
			System.out.println("Introduce el nombre del alumno nº " + (i + 1) + ":");
			nombre = sc.nextLine();

			System.out.println("Introduce el apellido del alumno nº " + (i + 1) + ":");
			apellido = sc.nextLine();
			
			System.out.println("Introduce la edad del alumno nº " + (i + 1) + ":");
			edad = sc.nextInt();
			sc.nextLine();
			System.out.println("Introduce el DNI del alumno nº " + (i + 1) + ":");
			dni = sc.nextLine();

			alumnos.add(new Alumno(nombre, apellido, edad, dni));
		}

		for (Alumno alumno : alumnos) {
			System.out.println(alumno.toString());
		}
	}
}