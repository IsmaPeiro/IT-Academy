/*Fes un programa que tingui una classe anomenada Clienta, a més a més de la classe que conté el main.

Aquesta classe Clienta tindrà com a atributs el DNI, l'edat, la nacionalitat i nombre de vols agafats.

L'aplicació ha de poder generar Clientes de dues maneres:

• Només a partir del DNI i la Nacionalitat (l'edat per defecte serà 18 anys i el nombre de vols agafats per defecte serà 10).
• Indicant tots els atributs.

La classe Clienta ha de disposar dels següents mètodes:

• mètodes que permetin consultar cadascun dels atributs.
• mètodes que permetin modificar la nacionalitat i l'edat.

• un mètode que calcula la petjada de carboni (multiplicant els viatges per 0,5 tones de CO₂).

• un mètode que retornarà una descripció completa de la clienta (toString()).

Al main del projecte, crea dues clientes de les 2 maneres possibles i
 comprova que els mètodes creats funcionen correctament. És a dir, crida a tots els mètodes amb les dues clientes.
*/
package m8ejercicio1;
 
public class Clienta {
	private String dni, nationality;
	private int age, flights;
	
	public Clienta(String dni, String nationality) {		
		this.dni = dni;
		this.nationality = nationality;
		this.age = 18;
		this.flights = 10;
	}
	
	public Clienta(String dni, int age, String nationality, int flights) {
		this.dni = dni;
		this.age = age;
		this.nationality = nationality;		
		this.flights = flights;
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

	public int getFlights() {
		return flights;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public double carbonFootprint () {		
		return 0.5*flights;		
	}

	@Override
	public String toString() {
		return "Clienta [dni=" + dni + ", nacionalidad=" + nationality + ", edad=" + age + ", vuelos=" + flights + "]";
	}	
}
