package examen_revisited_toni_jimenez;

import java.util.ArrayList;

public class AlumneNacional extends Alumne {
	// Atributs
	private String dni;

	// Constructors
	public AlumneNacional(int id, String nom, String dni) {
		super(id, nom);
		this.dni = dni;
	}

	public AlumneNacional(int id, String nom, String dni, ArrayList<Integer> llistatNotes) {
		super(id, nom, llistatNotes);
		this.dni = dni;
	}

	// Getters
	public String getDni() {
		return dni;
	}

	// Setters
	public void setDni(String dni) {
		this.dni = dni;
	}

	// Mètodes
	/*
	 * totes les notes que són >=5 s’han de dividir entre 2, la resta de notes es
	 * queden iguals. Amb totes aquestes notes tractades, s’ha de fer la mitja.
	 */
	@Override
	public String calcularNotaFinal() {
		double sumaNotes = 0d;
		double notaMitjana = 0d;
		int totalNotes = super.getLlistatNotes().size();
		int i = 0;

		for (i = 0; i < totalNotes; i++) {
			int nota = super.getLlistatNotes().get(i);

			if (nota >= 5) {
				sumaNotes += (double) nota / 2;
			} else {
				sumaNotes += (double) nota;
			}
		}

		if (i == 0) {
			return "aviat tindré notes per treure la nota mitjana.";
		} else {
			notaMitjana = sumaNotes / i;
			return "una nota mitja de " + notaMitjana + ".";
		}
	}

	@Override
	public String toString() {
		return "* Em dic " + super.getNom() + " i sóc l'alumne número " + super.getId() + " amb DNI " + this.getDni()
				+ " i " + calcularNotaFinal();
	}
	public double notaFinal() {
		double sumaNotes = 0d;
		double notaMitjana = 0d;
		int totalNotes = super.getLlistatNotes().size();
		int i = 0;

		for (i = 0; i < totalNotes; i++) {
			int nota = super.getLlistatNotes().get(i);

			if (nota >= 5) {
				sumaNotes += (double) nota / 2;
			} else {
				sumaNotes += (double) nota;
			}
		}
		if (i == 0) {
			notaMitjana = 0.0;
		} else {
			notaMitjana = Math.round((sumaNotes / i) * 100.0) / 100.0;
		}
		return notaMitjana;

	}
	public void setDocumentIdentitat(String dni) {
		this.dni = dni;
	}
}
