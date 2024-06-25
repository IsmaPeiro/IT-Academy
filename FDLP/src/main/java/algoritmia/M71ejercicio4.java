package algoritmia;

import java.util.Scanner;

public class M71ejercicio4 {

	public static void main(String[] args) {
		/*
		 * Crea un mètode que ha de rebre com a paràmetres els costats d'un triangle. La
		 * funció ha de retornar un missatge indicant si el triangle és equilàter,
		 * isòsceles o escalè.
		 */

		float side1, side2, side3;

		side1 = inputSide("primer");
		side2 = inputSide("segundo");
		side3 = inputSide("tercer");

		checkTriangle(side1, side2, side3);
	}

	public static float inputSide(String numSide) {
		Scanner sc = new Scanner(System.in);
		float size;
		System.out.println("Introduce la longitud del " + numSide + " lado:");
		size = sc.nextFloat();
		return size;
	}

	public static void checkTriangle(float side1, float side2, float side3) {
		if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
			if (side1 == side2 && side2 == side3) {
				System.out
						.println("El triangulo con lados " + side1 + ", " + side2 + " y " + side3 + ", es equilatero.");
			} else if (side1 == side2 || side1 == side3 || side2 == side3) {
				System.out
						.println("El triangulo con lados " + side1 + ", " + side2 + " y " + side3 + ", es isosceles.");
			} else {
				System.out.println("El triangulo con lados " + side1 + ", " + side2 + " y " + side3 + ", es escaleno.");
			}
		} else {
			System.out.println(
					"Con los lados " + side1 + ", " + side2 + " y " + side3 + ", no se puede formar un triangulo.");
		}
	}
}