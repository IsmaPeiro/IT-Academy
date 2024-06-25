package ruletarusa;

public class Jugador {
	private final int id;
	private String nombre;
	private String nickName;
	private boolean vivo;

	private static int contador = 1;

	public Jugador(String nombre) {
		this.id = contador++;
		this.nombre = nombre;
		this.nickName = nombre.concat(String.valueOf(id));
		this.vivo = true;
	}

	public boolean isVivo() {
		return vivo;
	}

	public String getNickName() {
		return nickName;
	}

	public boolean jugar(Revolver revolver) {
		if (revolver.disparar() == true) {
			vivo = false;
		} else {
			revolver.siguienteBala();			
		}
		return vivo;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", nickName=" + nickName + ", vivo=" + vivo + "]";
	}
}
