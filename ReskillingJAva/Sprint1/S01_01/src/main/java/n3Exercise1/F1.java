package n3Exercise1;

public class F1 extends NewsReport {
	private String team;

	public F1(String titular, String team) {
		super(titular);
		this.price =100;
		this.punctuation =4;
		this.team = team;
	}
	
	public String getSport () { return "F1";}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return super.toString()+" Sport=F1, team=" + team;
	}
	
	public int calculatePriceNew() {
		int newPrice= price;
		newPrice += (team.equalsIgnoreCase("Ferrari")|| team.equalsIgnoreCase("Mercedes")) ? 50 : 0;

		return newPrice;
	}
	
	public int calculatePointsNew() {
		int newPoints= punctuation;
		newPoints += (team.equalsIgnoreCase("Ferrari")|| team.equalsIgnoreCase("Mercedes")) ? 2 : 0;
		
		return newPoints;
	}
}
