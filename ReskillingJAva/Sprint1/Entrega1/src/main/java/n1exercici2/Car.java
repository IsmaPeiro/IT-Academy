package n1exercici2;

public class Car {
	private static final String BRAND ="Seat";
	/*
	 * No se pude inicializar desde el constructor, solo al cargar la clase
	 * y una vez inicializado no puede cambiar de valor.
	 */
	
	private static String model;
	/* 
	 * Se pude (pero no se debería) inicializar desde el constructor ya que al instanciar un objeto nuevo.
	 * Puede ser inicilizado al cargar la clase y dependiendo del modificador de acceso,
	 * también podría ser inicializado o modificado mediante un método, o mediante una llamada al atributo,
	 * pero este cambio afectará a todos los objetos instanciados.
	 */
	
	private final int power;
	/* 
	 * Se puede inicializar desde el constructor, una vez inicializado no puede cambiar su valor para el objeto instanciado.
	 */
	
	public Car(int power) {
		this.power =power;
	}
	
	public void setModel(String model) {
		Car.model =model;
	}
	
	@Override
	public String toString() {
		return "Car [BRAND=" + BRAND + " MODEL=" + model +" POWER=" + power + "]";
	}
	
	public static void BreakDown() {
		System.out.println("The car is breaking down.");
	}
	
	public void speedUp() {
		System.out.println("The car is accelerating.");
	}
}
