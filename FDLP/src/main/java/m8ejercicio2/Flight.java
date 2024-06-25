/*
		 * Fes un programa que permeti donar d'alta, modificar, veure i eliminar vols.
		 * La classe vol tindre els atributs: distància (en km), número de vol,
		 * companyia, nombre de passatgers, nombre de motors. També haurà de contenir un
		 * constructor complet i els getters i setters necessaris. Finalment, la classe
		 * vol tindre un mètode calculaPetjadaCarboni() que ha de calcular el CO₂ emès
		 * per l'avió tenint en compte que cada motor allibera 0,1 tones de CO₂ cada
		 * 1000 km de distància. Les funcionalitats del programa seran les següents:
		 * 
		 * Elmètode crearVol() haurà de rebre les dades per crear un vol i afegir-lo a
		 * un array de vols.
		 * 
		 * El mètode donarDeBaixaVol() haurà de rebre el número de vol que es vol donar
		 * de baixa. Si el vol està dintre de l'array, l'eliminarem i mostrarem un
		 * missatge informatiu per pantalla, si no, avisarem per pantalla que el vol no
		 * es troba a la nostra aplicació.
		 *
		 * El mètode veureVol() haurà de rebre el número de vol que es vol mostrar. Si
		 * el vol està dintre de l'array, mostrarem tots els seus atributs i també
		 * cridarem al
		 * 
		 * mètode calculaPetjadaCarboni(), si no, avisarem per pantalla que el vol no es
		 * troba a la nostra aplicació.
		 * 
		 * El mètode modificarVol() haurà de rebre el número de vol que es vol
		 * modificar. Si el vol està dintre de l'array, demanarem quin atribut es vol
		 * modificar, farem la modificació pertinent i mostrarem un missatge informatiu
		 * per pantalla. Si no, avisarem per pantalla que el vol no es troba a la nostra
		 * aplicació.
		 */
package m8ejercicio2;

public class Flight {
	private double distance;
	private String flightNumber, company;
	int passangers, engines;
	
	public Flight(String flightNumber, String company, int passangers, double distance, int engines) {
		this.flightNumber = flightNumber;
		this.company = company;
		this.engines = engines;	
		this.passangers = passangers;		
		this.distance = distance;		
	}
	
	public String getCompany() {
		return company;
	}

	public double getDistance() {
		return distance;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public int getPassangers() {
		return passangers;
	}

	public int getEngines() {
		return engines;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setPassangers(int passangers) {
		this.passangers = passangers;
	}

	public void setEngines(int engines) {
		this.engines = engines;
	}	
	
	public double carbonFootPrint () {		
		return (distance/1000)*0.1;
	}

	@Override
	public String toString() {
		return "Número de Vuelo: " + flightNumber + "\ndistancia: " + distance + "\nCompañía: " + company
				+ "\nPasajeros: " + passangers + "\nNúmero de motores: " + engines + "\nHuella de carbono: "
				+ carbonFootPrint()+" toneladas de CO2";
	}	

}
