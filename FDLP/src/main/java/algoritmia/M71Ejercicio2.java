package algoritmia;

import java.util.Scanner;
import java.util.ArrayList;

public class M71Ejercicio2 {

	public static void main(String[] args) {
		/*
		 * Un/a professor/a vol calcular les mitges de les notes de tota la classe.
		 * Crea una aplicació on l'usuari/ària introduirà un número per pantalla
		 * (el número correspon al nombre de notes que vol introduir)
		 * i el programa li demanarà que introdueixi les notes de tots els/les alumnes.
		 * Un cop les notes han sigut introduïdes, el programa retorna el següent:
		 * Si la nota mitjana és menor que 5: "La nota mitjana de la classe està suspesa.
		 * Els/les alumnes haurien de preguntar els seus dubtes i treballar més".
		 * Si la nota és inferior a 7: "La nota mitjana de la classe és bona, però els/les alumnes haurien de millorar el treball personal".
		 * Per la resta de casos, el missatge ha de ser: "Enhorabona! La nota mitjana de la classe es correspon amb l'esforç realitzat".
		* Les notes han d'estar compreses entre 0 i 10.
		*/
		
		final int STUDENTS = 5;
		int numOfMarks = inputNumber();
		ArrayList<float[]> marks = inputMarks(numOfMarks, STUDENTS);
		float median = calculateMedian(marks, STUDENTS);
		showResults(median);

		
	}

	static int inputNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantas notas por alumno hay?");
		return sc.nextInt();
	}

	static ArrayList<float[]> inputMarks(int number, int students) {
		Scanner sc = new Scanner(System.in);
		ArrayList<float[]> marks = new ArrayList<float[]>();
		for (int i = 0; i < students; i++) {
			float[] temp = new float[number];
			System.out.println("Introduce las notas del alumno " + (i + 1) + ":");
			for (int y = 0; y < number; y++) {
				System.out.println("Introduce la nota nº " + (y + 1) + ":");
				temp[y] = isMark0To10(y);
			}
			marks.add(temp);
		}
		return marks;
	}

	static float calculateMedian(ArrayList<float[]> marks, int students) {
		float sumMarksClass = 0;		
		for (float[] marksArray : marks) {
			float sumMarksStudent = 0;
			for (int i = 0; i < marksArray.length; i++) {
				sumMarksStudent += marksArray[i];
			}
			sumMarksClass += (sumMarksStudent / marksArray.length);
		}
		return sumMarksClass / students;
	}

	static void showResults(float median) {
		System.out.println("La nota media de la clase es: " + median);
		if (median < 5) {
			System.out.println("La nota media de la clase está suspendida. El/los alumnos"
					+ " tendrían que preguntar sus dudas y trabajar más");
		} else if (median >= 5 && median < 7) {
			System.out.println(
					"La nota media de la clase es buena, pero los/las alumnes tendrían que mejorar el trabajo personal");
		} else {
			System.out.println("¡Enhorabuena! La nota media de la clase se corresponde con el esfuerzo realizado");
		}
	}

	static float isMark0To10(int y) {
		Scanner sc = new Scanner(System.in);
		float mark = sc.nextFloat();
		while (mark > 10 || mark < 0) {
			System.out.println("has de introducir una nota entre 0 y 10");
			System.out.println("Introduce la nota nº " + (y + 1) + ":");
			mark = sc.nextFloat();
		}
		return mark;
	}
	
	
}





