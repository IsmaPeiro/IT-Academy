package algoritmia;

import java.util.Scanner;

public class EjercicioExtraClase8 {

	public static void main(String[] args) {
		/*
		 * 	 Realitzeu un programa que determini els diners que rebrà un treballador per les hores
		 *   extra que fa en una empresa. Les hores extra són les que sobrepassen les 40 hores setmanals
		 *   (és a dir, a partir de la 40). Les primeres 10 es paguen al doble i la resta al triple.
		 *   Hauràs de demanar al treballador les hores totals treballades i quants diners cobra per
		 *   cada hora. El resultat haurà de ser la xifra total de diners que ha guanyat aquella setmana.
		 *   PD: és possible que treballi menys de 40 hores.
		 */
		Scanner sc=new Scanner(System.in);
		int hours;
		float money;
		float salary;
		
		System.out.println("¿Cúantas horas has trabajado esta semana?");
		hours=sc.nextInt();
		
		System.out.println("¿Cuanto cobras por hora?");
		money=sc.nextFloat();
		
		salary=calculateSalary(hours, money);
		System.out.println("Este mes cobrarás "+salary+" euros.");
	}
	
	public static float calculateSalary(int hours, float money) {
		float salary=0;		
		if (hours<=40) {
			salary=hours*money;
		} else if (hours>40&&hours<=50) {			
			salary=(40*money)+((hours-40)*(2*money));			
		} else if (hours>50) {
			salary=(40*money + (10*(2*money)) + ((hours-50)*(3*money)));
		} else {
			System.out.println("tu no has trabajado esta semana ...");
		}		
		return salary;
	}

}
