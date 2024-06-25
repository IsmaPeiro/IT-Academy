package ruletarusa;

public class Revolver {
	private int posicionActual;
	private int posicionBala;

	public Revolver() {
		this.posicionActual = (int) Math.floor(Math.random() * 6 + 1);
		this.posicionBala = (int) Math.floor(Math.random() * 6 + 1);
	}

	public boolean disparar() {
		return (posicionActual == posicionBala);
	}

	public void siguienteBala() {
		posicionActual++;
		if (posicionActual > 6) {
			posicionActual = 1;
		}
	}

	public void informa() {
		System.out.println(
				"La posición actual es: " + posicionActual + ", la bala está en la posición: " + posicionBala + ".");
	}
}
