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

import java.util.ArrayList;

public class Client {
	private String dni;
	private String nationality;
	private int age;
	private ArrayList<Flight> flights;
	
	
	public Client(String dni, String nationality, int age) {
		this.dni = dni;
		this.nationality = nationality;
		this.age = age;
		this.flights = new ArrayList<Flight>();
	}
		
	public String getDni() {
		return dni;
	}

	public String getNationality() {
		return nationality;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<Flight> getFlight() {
		return flights;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setflight(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	
	public double calculteTotalCarbonFootprint() {
		double footPrint=0;
		for (Flight flight : this.flights) {
			footPrint+=flight.getCo2emitted();
		}
		return footPrint;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nacionalidad=" + nationality + ", edad=" + age + ", vuelos=" + flights + "]";
	}	
}
