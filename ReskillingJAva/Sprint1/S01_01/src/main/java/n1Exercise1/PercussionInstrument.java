package n1Exercise1;

public class PercussionInstrument extends Instrument {

	public PercussionInstrument(String name, double price) {
		super(name, price);
		
	}
	{
		System.out.println("Initialization block of PercussionInstrument class..");
	}	
	static {
		System.out.println("PercussionInstrument is loading.");
		}
	
	public void play() {
		System.out.println("Percussion instrument is playing.");
	}
	
	public static void staticMethod() {
		System.out.println("Static method of PercussionInstrument Class.");
	}
}
