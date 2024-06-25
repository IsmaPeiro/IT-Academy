package algoritmia;

import java.util.Scanner;

public class M4EjercicioExtra2 {

	public static void main(String[] args) {
		/*Demana a l'usuari/ària un número entre 0 i 99 i mostra'l
		 *  escrit en lletres (pots fer-ho en català o castellà).
		 *  Exemple: 56 (cinquanta-sis) o 56 (cincuenta y seis
		 */
		
		int numero;
		int decimales;
		int unidades;
		String stringDecimales="";
		String stringUnidades="";
		String stringNumero;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un número del 0 al 99:");
		numero = sc.nextInt();

		sc.close();

		decimales = numero / 10;
		unidades = numero - (decimales * 10);

		switch (decimales) {
		case 1:
			stringDecimales = (unidades == 0) ? "diez" : "dieci";
			break;
		case 2:
			stringDecimales = (unidades == 0) ? "veinte" : "veinti";
			break;
		case 3:
			stringDecimales = (unidades == 0) ? "treinta" : "treinta y ";
			break;
		case 4:
			stringDecimales = (unidades == 0) ? "cuarenta" : "cuarenta y ";
			break;
		case 5:
			stringDecimales = (unidades == 0) ? "cincuenta" : "cincuenta y ";
			break;
		case 6:
			stringDecimales = (unidades == 0) ? "sesenta" : "sesenta y ";
			break;
		case 7:
			stringDecimales = (unidades == 0) ? "setenta" : "setenta y ";
			break;
		case 8:
			stringDecimales = (unidades == 0) ? "ochenta" : "ochenta y ";
			break;
		case 9:
			stringDecimales = (unidades == 0) ? "noventa" : "noventa y ";
			break;
		}

		switch (unidades) {
		case 1:
			stringUnidades = "uno";
			break;
		case 2:
			stringUnidades = "dos";
			break;
		case 3:
			stringUnidades = "tres";
			break;
		case 4:
			stringUnidades = "cuatro";
			break;
		case 5:
			stringUnidades = "cinco";
			break;
		case 6:
			stringUnidades = (decimales == 1 || decimales == 2) ? "séis" : "seis";
			break;
		case 7:
			stringUnidades = "siete";
			break;
		case 8:
			stringUnidades = "ocho";
			break;
		case 9:
			stringUnidades = "nueve";
			break;
		}

		stringNumero = stringDecimales + stringUnidades;

		// EXCEPCIONES
		switch (numero) {
		case 0:
			stringNumero = "cero";
			break;
		case 11:
			stringNumero = "once";
			break;
		case 12:
			stringNumero = "doce";
			break;
		case 13:
			stringNumero = "trece";
			break;
		case 14:
			stringNumero = "catorce";
			break;
		case 15:
			stringNumero = "quince";
			break;
		}
		if (numero <= 99 && numero >= 0) {
			System.out.println("Has introducido el número " + "\"" + stringNumero + "\"");
		} else {
			System.out.println("No has introducido un número entre 0 y 99");
		}

	}
}
