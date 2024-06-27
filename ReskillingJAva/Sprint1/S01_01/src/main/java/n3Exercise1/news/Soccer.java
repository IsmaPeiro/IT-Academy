package n3Exercise1.news;

public class Soccer extends NewsReport {
	private String competition;
	private String club;
	private String player;

	public Soccer(String tiular, String competition, String club, String player) {
		super(tiular);
		this.price =300;
		this.punctuation =5;
		this.competition = competition;
		this.club = club;
		this.player = player;
	}
	
	public String getSport () { return "Soccer";}
	
	public String getCompetition() {
		return competition;
	}

	public String getClub() {
		return club;
	}

	public String getPlayer() {
		return player;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return super.toString()+" Sport=Soccer, competition=" + competition + ", club=" + club + ", player=" + player;
	}

	public int calculatePriceNew() {
		int newPrice = price;
		newPrice += (competition.equalsIgnoreCase("Champions")) ? 100 : 0;
		newPrice += (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) ? 100 : 0;
		newPrice += (player.equalsIgnoreCase("Ferran Torres") || player.equalsIgnoreCase("Benzema")) ? 100 : 0;

		return newPrice;
	}

	public int calculatePointsNew() {
		int pointsNew = punctuation;

		pointsNew += (competition.equalsIgnoreCase("Champions")) ? 3 : 0;
		pointsNew += (competition.equalsIgnoreCase("La Liga")) ? 2 : 0;
		pointsNew += (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) ? 1 : 0;
		pointsNew += (player.equalsIgnoreCase("Ferran Torres") || player.equalsIgnoreCase("Benzema")) ? 1 : 0;
		
		return pointsNew;
	}
}
