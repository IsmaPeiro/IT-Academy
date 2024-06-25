/*Fes les classes Cliente i Vol, perquè responguin al diagrama de classes de la imatge.

Fes un programa que tingui programades totes les opcions del següent menú:

Sortir de l'aplicació.
Crear clienta.
Eliminar clienta.
Crear vol d'una clienta.
Compensar CO₂ d'un vol d'una clienta (per cada 100 € es compensen 0,1 tones de CO₂ emès d'aquell vol).
Calcular petjada de carboni d'una clienta (és la suma del CO₂ de tots els seus vols).
Calcular petjada de carboni mitja de totes les clientes.
A tenir en compte:

- El CO₂ emès inicial de tots els vols ha de ser d'1 tona.

- En crear una clienta, aquesta no haurà de tenir cap vol "associat".

- A l'App només volem tenir un array de clientes, no de vols. Els vols s'han de guardar dintre de les clientes.

- El diagrama UML mostrà les propietats i mètodes mínims que han de tenir les classes, però pots crear-ne més si és necessari.

┌─────────────────────────┐                           ┌─────────────────────────────────┐ 
│Cliente                  │                           │Vuelo                            │
├─────────────────────────┤ 1                +cliente ├─────────────────────────────────┤
│[-] dni : String         │<─────────────────────────>│[-] numVuelo : int               │
│[-] nacionalidad : String│ +vuelo                  * │[-] company : String             │
│[-] edad : int			  │							  │[-] distancia : int              │
└─────────────────────────┘							  │[-] cO2emitido : double          │
													  ├─────────────────────────────────┤
													  │[+] compensaCO2 (euros : integer)│
													  └─────────────────────────────────┘	
*/
package m8ejercicio3;

public class Flight {
	private int flightNumber;
	private String company;
	private int distance;
	private double co2Emitted;
	
	public Flight(int flightNumber, String company, int distance) {
		this.flightNumber = flightNumber;
		this.company = company;
		this.distance = distance;
		this.co2Emitted = 1.0;
	}

	public int getflightNumber() {
		return flightNumber;
	}

	public String getCompany() {
		return company;
	}

	public int getdistance() {
		return distance;
	}

	public double getCo2emitted() {
		return co2Emitted;
	}	

	@Override
	public String toString() {
		return "Vuelo [numVuelo=" + flightNumber + ", company=" + company + ", distancia=" + distance + ", co2emitido="
				+ co2Emitted + "]";
	}	
	
	public void compensateCO2 (int euros) {
			this.co2Emitted-=(0.001*euros);
	}		
}
