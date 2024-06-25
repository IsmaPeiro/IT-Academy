package examen.ejercicio1;

import java.util.ArrayList;

public class Eejercicio1 {
	public static void main(String[] args) {
		/*
		 * Exercici 1
		 * Ens donen dos arrays. En un hi ha productes disponibles per poder comprar i en l'altre productes que volem comprar.
		 * Productes disponibles per comprar: "xampú", "sabó", "patates", "bledes", "lletuga", "llimones", "kiwis", "alvocats", "fideus", "arròs", "cafè", "xocolata"
		 * Productes que volem comprar: "xampú", "xocolata", "alvocats", "bledes", "llimones", "llimonada"
		 * Crea un tercer array amb els productes que estan en els dos arrays a la vegada
		 */
		
		ArrayList<String> disponibles=new ArrayList<String>();
		ArrayList<String> deseados=new ArrayList<String>();
		ArrayList<String> coincidentes=new ArrayList<String>();
		boolean encontrado=false;
		
		int z=0;
		
		disponibles.add("xampú");
		disponibles.add("sabó");
		disponibles.add("patates");
		disponibles.add("bledes");
		disponibles.add("lletuga");
		disponibles.add("llimones");
		disponibles.add("kiwis");
		disponibles.add("alvocats");
		disponibles.add("fideus");
		disponibles.add("arròs");
		disponibles.add("cafè");
		disponibles.add("xocolata");
		
		deseados.add("xampú");
		deseados.add("xocolata");
		deseados.add("alvocats");
		deseados.add("bledes");
		deseados.add("llimones");
		deseados.add("llimonada");
		
		for (int i=0;i<disponibles.size();i++) {
			encontrado=false;
			z=0;
			while (!encontrado&&z<deseados.size()) {				
				if (deseados.get(z).equalsIgnoreCase(disponibles.get(i))) {
					coincidentes.add(disponibles.get(i));
					encontrado=true;
				}				
				z++;
			}
		}
		System.out.println(coincidentes);
	}			
}
