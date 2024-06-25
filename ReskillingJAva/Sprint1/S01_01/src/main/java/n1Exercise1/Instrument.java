package n1Exercise1;

public abstract class Instrument {
	protected String name;
	protected double price;
	
	public Instrument(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	{
		System.out.println("Initializer block of class Instrument .");
	}
	
	static {
		System.out.println("The Instrument class is loading.");
		}
	
	public abstract void play();
	
}
