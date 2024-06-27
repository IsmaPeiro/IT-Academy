package n3Exercise1.news;

public class Tennis extends NewsReport {
	private String competition;
	private String player;
	
	public Tennis(String titular, String competition, String player) {
		super(titular);
		this.price =150;
		this.punctuation =4;
		this.competition = competition;
		this.player = player;
	}
	
	public String getSport () { return "Tennis";}
	
	public String getCompetition() {
		return competition;
	}

	public String getPlayer() {
		return player;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public void setPlayer(String tenistas) {
		this.player = tenistas;
	}

	@Override
	public String toString() {
		return super.toString()+" Sport=Tennis, competition=" + competition + ", player=" + player;
	}
	
	public int calculatePriceNew() {
		int newPrice= price;
		newPrice += (player.equalsIgnoreCase("Federer")|| player.equalsIgnoreCase("Nadal")|| player.equalsIgnoreCase("Djokovic")) ? 100 : 0;
		
		return newPrice;
	}
	
	public int calculatePointsNew() {
		int newPoints= punctuation;
		newPoints += (player.equalsIgnoreCase("Federer")|| player.equalsIgnoreCase("Nadal")|| player.equalsIgnoreCase("Djokovic")) ? 3 : 0;
		
		return newPoints;
	}
}
