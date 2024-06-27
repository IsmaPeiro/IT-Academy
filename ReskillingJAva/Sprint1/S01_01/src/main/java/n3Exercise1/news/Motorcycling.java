package n3Exercise1.news;

public class Motorcycling extends NewsReport {
	private String team;

	public Motorcycling(String titular, String team) {
		super(titular);
		this.price =100;
		this.punctuation =3;
		this.team = team;
	}
	
	public String getSport () { return "Motorcycling";}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return super.toString()+"Sport: Motorcycling, team=" + team;
	}
	
	public int calculatePriceNew() {
		int precioNoticia= price;
		precioNoticia += (team.equalsIgnoreCase("Honda")|| team.equalsIgnoreCase("Yamaha")) ? 50 : 0;
		
		return precioNoticia;
	}
	
	public int calculatePointsNew() {
		int puntosNoticia= punctuation;
		puntosNoticia += (team.equalsIgnoreCase("Honda")|| team.equalsIgnoreCase("Yamaha")) ? 3 : 0;
		
		return puntosNoticia;
	}
}
