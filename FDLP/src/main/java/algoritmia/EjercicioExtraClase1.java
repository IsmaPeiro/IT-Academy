package algoritmia;

import java.util.ArrayList;
//import java.util.Arrays; <-Necesario para iniciar el ArrayList según la forma de la línea 12
import java.util.Scanner;

public class EjercicioExtraClase1 {

	public static void main(String[] args) {
		
		String marca;
		//ArrayList<String> marcas=new ArrayList<String>(Arrays.asList("Seat", "Kia", "Renault", "Mercedes", "Ferrari", "Audi")); <-Inciar un ArrayList con valores
		ArrayList<String> marcas=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		boolean encontrado=false;
		int i=0;
		
		marcas.add("Seat");
		marcas.add("Kia");
		marcas.add("Renault");
		marcas.add("Mercedes");
		marcas.add("Ferrari");
		marcas.add("Audi");
		
		System.out.println("Introduce una marca para ver si está en stock");
		marca=sc.nextLine();
		sc.close();
		
		while (i<marcas.size()&&!encontrado) {		
			if (marcas.get(i).equalsIgnoreCase(marca)) {				
				encontrado=true;
			} else {
				i++;
			}
		}
		
		System.out.println((encontrado) ? "Tenemos "+marca+" en stock" : "No tenemos "+marca+" en stock");
		
		}
	}

