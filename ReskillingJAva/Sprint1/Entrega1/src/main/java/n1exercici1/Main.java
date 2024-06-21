package n1exercici1;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Instancianting class WindInstrument Objects.");
		WindInstrument windInstrument1 =new WindInstrument("trumpet", 10);
		WindInstrument windInstrument2 =new WindInstrument("saxo", 10);
		
		
		System.out.println("Accesing to a static method of class StringInstrument.");
		StringInstrument.staticMethod();
		

	}

}
