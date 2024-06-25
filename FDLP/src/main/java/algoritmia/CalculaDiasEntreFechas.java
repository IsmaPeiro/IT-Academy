package algoritmia;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class CalculaDiasEntreFechas {

	public static void main(String[] args) {
		/*
		 * Fes un programa que demani per pantalla un dia, mes i any, i calculi per
		 * pantalla el nombre de dies transcorreguts entre l'1 de gener de l'any
		 * introduït i la data introduïda. Valida la que la data sigui major a
		 * l'01/01/1900 i estigui correcta. És a dir: 30/02/2021 no és una data vàlida.
		 * Entrada: Indica una data a continuació. mes: 3 día: 12 any: 2020 Sortida:
		 * «Entre el 01/gener/2020 i el 12/març/2020 han transcorregut 72 dies».
		 */
		int dia = 12;
		int mes = 3;
		int any = 2019;
		int diasMes = 0;
		int sumaDias = 0;
		String mesFecha = "";
		String nomMes = "";
		int i=mes;
		boolean salir = false;

		if ((any == 1900 && mes == 1 && dia > 1) || (any == 1900 && mes > 1) || (any > 1900)) {
			while (i>0&&!salir) {
			//for (int i = mes; i > 0; i--) {
				switch (i) {
				case 1:
					nomMes = "Enero";
					diasMes = 31;
					break;
				case 2:
					nomMes = "Febrero";
					if (any % 4 == 0) {
						diasMes = 29;
					} else {
						diasMes = 28;
					}
					break;
				case 3:
					nomMes = "Marzo";
					diasMes = 31;
					break;
				case 4:
					nomMes = "Abril";
					diasMes = 30;
					break;
				case 5:
					nomMes = "Mayo";
					diasMes = 31;
					break;
				case 6:
					nomMes = "Junio";
					diasMes = 30;
					break;
				case 7:
					nomMes = "Julio";
					diasMes = 31;
					break;
				case 8:
					nomMes = "Agosto";
					diasMes = 31;
					break;
				case 9:
					nomMes = "Septiembre";
					diasMes = 30;
					break;
				case 10:
					nomMes = "Octubre";
					diasMes = 31;
					break;
				case 11:
					nomMes = "Noviembre";
					diasMes = 30;
					break;
				case 12:
					nomMes = "Diciembre";
					diasMes = 31;
					break;
				}		
				if (i==mes) {
					mesFecha=nomMes;
				}
				if (i==mes&&dia>diasMes) {
					salir=true;
				} else if (i!=mes) {
					sumaDias+=diasMes;
				}				
				i--;
			} 
		}
		
		
		sumaDias += dia;

		if (!salir) {
			System.out.println("Entre el 01/gener/" + any + " i el 12/" + mesFecha + "/" + any + " han pasado "
					+ sumaDias + " días.");
		} else {
			System.out.println("La fecha no es correcta");
		}

	}

}
