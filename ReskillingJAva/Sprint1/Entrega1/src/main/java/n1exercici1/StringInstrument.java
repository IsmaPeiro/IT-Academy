package n1exercici1;

public class StringInstrument extends Instrument {

    public StringInstrument(String name, double price) {
        super(name, price);
        
    }

    {
        System.out.println("Initialization block of StringInstrument class.");
    }

    static {
        System.out.println("StringInstrument class is loading.");
    }

    public void play() {
        System.out.println("String instrument is playing.");
    }

    public static void staticMethod() {
        System.out.println("Static method of class StringInstrument.");
    }
}
