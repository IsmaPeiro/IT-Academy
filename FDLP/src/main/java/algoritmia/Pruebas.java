package algoritmia;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.time.*;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Pruebas {
	
	
	
	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int a = 0;
		String error="";

		System.out.println("dime un número entero:");		
		if (sc.hasNextInt()) {
			a = sc.nextInt();
			System.out.println(a);
		} else {
			error=sc.nextLine();
			System.out.println(error+" no es un número entero");
		}*/
		
		/*
		 * Component unComponentPare = null; Icon unIcono = null; int seleccio =
		 * JOptionPane.showOptionDialog( unComponentPare, "Seleccioni una opció",
		 * "Selector d’opcions", JOptionPane.YES_NO_CANCEL_OPTION,
		 * JOptionPane.QUESTION_MESSAGE, unIcono, // null per icona per defecte. new
		 * Object[] { "opció 1", "opció 2", "opció 3" }, // null per a YES, NO i CANCEL
		 * "opció 1");
		 * 
		 * if (seleccio !=-1) System.out.println("Ha seleccionat l’opció " + (seleccio+
		 * 1));
		 * 
		 * 
		 * System.out.println ("Introdueix un caràcter ..."); int num = 0; try { num =
		 * System.in.read (); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } // L’usuari indica a System.out.println
		 * ("Has indicat:" + (char)num); //Has indicat: 97
		 * 
		 * System.out.println(5%3);
		 */
		// Import the ArrayList class and the Iterator class

		// Make a collection
		/*ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");

		// Get the iterator
		Iterator<String> it = cars.iterator();

		// Print the first item
		System.out.println(it.next());
		
		while(it.hasNext()) {
			  System.out.println(it.next());
			}
		for (String car : cars) {
			System.out.println(car);
		}*/
		
		// System.out.println(Math.ceil((Math.random() * 10)) );
		
		
		
		//saludarPersona("Laura");
		//System.out.println(mesActual ());
		
		/*int num=2;
		System.out.println(
				esPar(num) ? num+ " es par" : num + " es impar" 
				);
		
		num=3;
		System.out.println(
				esPar(num) ? num+ " es par" : num + " es impar" 
				);*/
		
		
		
	/*}
	static void saludarPersona (String nombre) {
		System.out.println("Hola " + nombre);
	}
	
	static String mesActual () {
		String mes="";
		LocalDate fecha = LocalDate.now();
		int mesNumero = fecha.getMonthValue();
		switch (mesNumero) {
			case 1: mes="Enero"; 
			break;
			case 2: mes="Febrero"; 
			break;
			case 3: mes="Marzo"; 
			break;
			case 4: mes="Abril"; 
			break;
			case 5: mes="Mayo"; 
			break;
			case 6: mes="Junio"; 
			break;
			case 7: mes="Julio"; 
			break;
			case 8: mes="Agosto"; 
			break;
			case 9: mes="Septiembre"; 
			break;
			case 10: mes="Octubre"; 
			break;
			case 11: mes="Noviembre"; 
			break;
			case 12: mes="Diciembre"; 
			break;
		}
		return mes;
	}
	
	static boolean esPar (int num) {
		boolean resultado;
		resultado = (num%2==0) ? true : false; 
		return resultado;
	}*/
		String text = "Hi";
		String message = text;
		String s1 = text.toUpperCase();
		String s2 = text.toUpperCase();
		System.out.println(text == message);
		System.out.println(text == s1);
		System.out.println(s1 == s2);
	
	}
}
