package n2exercici1;

public class Phone {
	protected String brand;
	protected String model;
	
	public Phone(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	public void llamar (String numero) {
		System.out.println("Calling number " + numero);
	}
}
