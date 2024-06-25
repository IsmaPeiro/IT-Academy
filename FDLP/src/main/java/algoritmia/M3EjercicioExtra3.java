package algoritmia;

import java.util.Scanner;

public class M3EjercicioExtra3 {

	public static void main(String[] args) {
		/*
		 * Escriu un programa Java que calculi els litres de pintura necessaris per a
		 * pintar una paret rectangular. Un litre de pintura cobreix aproximadament,
		 * 12 m² en una sola mà. Crea una constant anomenada coberturaLitro per a
		 * guardar la dada de cobertura de la pintura (12 m²) Hauràs de demanar a
		 * l'usuari/ària: - L'alt i ample de la paret (multiplicant sabràs l'àrea de la
		 * mateixa) - El nombre de mans a aplicar. Mostra en pantalla els litres de
		 * pintura a utilitzar.
		 */
		
		Scanner sc = new Scanner(System.in);
		final byte COBERTURALITRO = 12;
		float high, wide;
		int layers;
		float liters;
		
		System.out.println("Introduce la altura de la pared:");
		high=sc.nextFloat();
		
		System.out.println("Introduce el ancho de la pared:");
		wide=sc.nextFloat();
		
		System.out.println("Introduce el número de capas:");
		layers=sc.nextInt();	
		
		liters=((high*wide)/12)*layers;
		
		System.out.println("para pintar una pared de "+high+" metros de alto y "+wide+" de ancho, "
						 + "con "+layers+" capas, te haran falta "+liters+" litros de pintura");
	}

}