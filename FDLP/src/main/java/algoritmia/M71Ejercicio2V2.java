package algoritmia;

import java.util.Scanner;
import java.util.ArrayList;

public class M71Ejercicio2V2 {

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
		
		ArrayList<Float> marks=new ArrayList<Float>();
		int numMarks;
		float median;
		
		//Pedir número de notas
		numMarks=inputNumMarks();
		//Pedir notas
			//comprobar que estén entre 0 y 10
		inputMarks (numMarks, marks);
		
		//calcular media
		median=calculateMedian (marks);
		
		//mostrar resultados
		showResults(median);
	}
	public static int inputNumMarks () {
		Scanner sc=new Scanner(System.in);
		System.out.println("¿Cuantas notas quieres introducir?");
		return sc.nextInt();
	}
	
	public static void inputMarks (int numMarks, ArrayList<Float> marks) {
		Scanner sc=new Scanner(System.in);
		float mark;
		System.out.println("introduce las notas.");
		for (int i=0;i<numMarks;i++) {
			do {
				System.out.println("introduce la nota número "+(i+1)+":");
				mark=sc.nextFloat();				
			} while (!checkMark(mark));
			marks.add(mark);
		}
	}
	
	public static boolean checkMark(float mark) {
		if (mark<=10&&mark>=0) {
			return true;
		} else {
			System.out.println("La nota ha de estar entre 0 y 10.");
			return false;
		}
	}
	
	public static float calculateMedian (ArrayList<Float> marks) {
		float sumMarks=0;
		for (float mark : marks) {
			sumMarks+=mark;
		}
		return sumMarks/marks.size();
	}
	
	public static void showResults (float median) {
		System.out.println("La nota media de la clase es: "+median+".");
		if (median<5) {
			System.out.println("La classe está suspendida. "
					+ "Los alumnos han de preguntar sus dudas y trabajar más.");
		} else if (median>=5&&median<7) {
			System.out.println("La nota media de la classe es buena, "
					+ "pero los alumnos han de mejorar el trabajo personal");
		} else {
			System.out.println("La nota media refleja el esfuerzo realizado. ¡Felicidades!");
		}
	}
}