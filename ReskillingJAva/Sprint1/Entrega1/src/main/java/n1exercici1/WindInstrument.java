package n1exercici1;

public class WindInstrument extends Instrument {

	public WindInstrument(String name, double price) {
		super(name, price);
		System.out.println("Instantiating WindInstrument object.");
		
	}
	{
		System.out.println("Class WindInstrument Initialization block.");
	}	
	static {
		System.out.println("Class WindInstrument is loading.");
		}
	
	public void play() {
		System.out.println("Wind instrument is playing.");
	}
	
	public static void staticMethod() {
		System.out.println("Static method of WindInstrument class.");
	}
}
