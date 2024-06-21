package n1exercici2;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("All Car class objects are instantiated with the static final atribute seted as \"Seat\"");
		System.out.println("And this attribute can't change his value");
		
		Car car1 =new Car(150);
		System.out.println(car1);
		
		Car car2 =new Car(200);
		System.out.println(car2);
		System.out.println();
		
		System.out.println("Setting up the static attribute model to \"Ibiza\" in one object.");
		car1.setModel("Ibiza");
		System.out.println("This affects all the objects instantiated");
		System.out.println(car1);
		System.out.println(car2);
		System.out.println();
		
		System.out.println("Calling the static methods of class car.");
		Car.BreakDown();
		car1.speedUp();

	}

}
