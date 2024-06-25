package algoritmia;

public class M71Ejercicio5 {

	public static void main(String[] args) {
		/*
		 * Mostra per pantalla els nombres parells compresos entre el 100 i el 0 en
		 * ordre descendent.
		 */

		showPairs100To0(); // consideramos 0 como par
	}

	public static void showPairs100To0() {
		System.out.println("Los número pares entre 100 y 0 son:");
		for (int i = 100; i >= 0; i -= 2) {
			System.out.print(i != 0 ? i + ", " : i + ".");
		}
	}
}
