package algoritmia;

import java.util.Scanner;

public class M5Ejercicio4 {

	public static void main(String[] args) {
		/*
		 * Fes un programa que demani per consola quants nens i nenes volem introduir
		 * per fer una reserva d'una actuació de titelles. Un cop sabem el nombre de
		 * nens i nenes has de demanar les seves edats. Les edats només poden estar
		 * compreses entre 5 i 12 anys, per tant, si en demanar una edat, l'usuari/ària
		 * introdueix una que no està en aquest rang, li has de tornar a demanar (fins
		 * que introdueixi una correcta). Finalment, has de mostrar per pantalla la
		 * mitjana d'edats dels nens.
		 */
		
		int numNens;
		int edad;
		int sumaEdadNens=0;
		int contador=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cuantas niños y niñas irán a la actuación?");
		numNens = sc.nextInt();
		
		if (numNens > 0) {
			
			/*
			System.out.println("Introduce las edades de los niños y niñas, recuerda que tienen que estar entre 5 y 12 años");
			for (int i = 0; i < numNens; i++) {				
				System.out.println("Introduce la edad de la niña o niño "+(i+1)+":");
				edad=sc.nextInt();
				while (!(edad >= 5 && edad <= 12)) {
					System.out.println("Error, vuelve a introducir la edad:");
					edad=sc.nextInt();
				}
				sumaEdadNens+=edad;				
			}
			*/
			
			System.out.println("Introduce las edades de los niños y niñas, recuerda que tienen que estar entre 5 y 12 años");
			do {
				System.out.println("Introduce la edad de la niña o niño "+(contador+1)+":");
				edad=sc.nextInt();
				if (edad<5||edad>12) {
					System.out.println("Error, vuelve a introducir la edad.");					
				} else {
					sumaEdadNens+=edad;	
					contador++;
				}
			} while (contador!=numNens);
		}
		
		sc.close();
				
		if (numNens > 0) {
			System.out.println("La media de edad es: "+((float)sumaEdadNens/numNens));
			} else {
				System.out.println("No has inscrito a nadie para la actuación.");
			}
		
	}
}
