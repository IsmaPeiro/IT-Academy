package n3Exercise1;

public class Basket extends NewsReport {
	private String competition;
	private String club;
	
	public Basket(String titular, String competition, String club) {
		super(titular);
		this.price =250;
		this.punctuation =4;
		this.competition = competition;
		this.club = club;
	}	
	public String getSport () { return "Basket";}
	
	public String getCompetition() {
		return competition;
	}

	public String getClub() {
		return club;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return super.toString()+" Sport=Basket, competition=" + competition + ", club=" + club;
	}
	
	public int calculatePriceNew() {
		int newPrice= price;
		newPrice += (competition.equalsIgnoreCase("EuroLigue")) ? 75 : 0;
		newPrice += (club.equalsIgnoreCase("Barça")||club.equalsIgnoreCase("Madrid")) ? 75 : 0;
		
		return newPrice;
	}
	
	public int calculatePointsNew() {
		int newPoints= punctuation;
		newPoints += (competition.equalsIgnoreCase("EuroLigue")) ? 3 : 0;
		newPoints += (competition.equalsIgnoreCase("ACB")) ? 2 : 0;
		newPoints += (club.equalsIgnoreCase("Barça")||club.equalsIgnoreCase("Madrid")) ? 1 : 0;
		
		return newPoints;
	}
}
