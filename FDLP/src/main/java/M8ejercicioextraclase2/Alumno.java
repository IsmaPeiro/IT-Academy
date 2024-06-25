package M8ejercicioextraclase2;

public class Alumno {
	/* crear una claase Alumno
	 * con los atributos
	 * Nombre, apellido, edad y DNI
	 * todos los Getters y Setters menos setDni
	 * método toString y un metodo birthday que sume uno a la edad
	 */
	private String nombre;
	private String apellido;
	private int edad;
	private String dni;
	public Alumno(String nombre, String apellido, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + "]";
	}
	
	public void birthday () {
		this.edad++;
	}
}
