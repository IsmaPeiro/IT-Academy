package algoritmia;

public class EjercicioExtraClase10 {

	public static void main(String[] args) {
		/*
		 * Imprimir totes les hores amb els seus minuts i els seus segons per consola
		 */

		for (int horas=0;horas<24;horas++) {
			for (int minutos=0;minutos<60;minutos++) {
				for (int segundos=0;segundos<60;segundos++){
					System.out.println(String.format("%0d", horas)+":"+String.format("%02d", minutos)+":"+String.format("%02d", segundos));
				}
			}
			
		/*int segundos = 0;
		int minutos = 0;
		int horas = 0;
		String stringSegundos;
		String stringMinutos;
		String stringHoras;

		while (horas < 24) {
			if (segundos < 10) {
				stringSegundos = "0" + segundos;
			} else {
				stringSegundos = "" + segundos;
			}

			if (minutos < 10) {
				stringMinutos = "0" + minutos;
			} else {
				stringMinutos = "" + minutos;
			}

			if (horas < 10) {
				stringHoras = "0" + horas;
			} else {
				stringHoras = "" + horas;
			}

			System.out.println(stringHoras + ":" + stringMinutos + ":" + stringSegundos);

			segundos++;
			if (segundos > 59) {
				segundos = 0;
				minutos++;
			}

			if (minutos > 59) {
				minutos = 0;
				horas++;
			}
		}*/
		
		
			
		}
	}
}