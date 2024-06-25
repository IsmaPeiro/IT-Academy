package examen_revisited_toni_jimenez;

import java.util.ArrayList;

public class AlumneInternacional extends Alumne {
	// Atributs
	private String passaport;

	// Constructors
	public AlumneInternacional(int id, String nom, String passaport) {
		super(id, nom);
		this.passaport = passaport;
	}

	public AlumneInternacional(int id, String nom, String passaport, ArrayList<Integer> llistatNotes) {
		super(id, nom, llistatNotes);
		this.passaport = passaport;
	}

	// Getters
	public String getPassaport() {
		return passaport;
	}

	// Setters
	public void setPassaport(String passaport) {
		this.passaport = passaport;
	}

	// Mètodes
	/*
	 * totes les notes que són pars, es multipliquen per 2 i les senars es
	 * divideixen entre 2. Amb totes aquestes notes tractades, s’ha de fer la mitja.
	 */
	@Override
	public String calcularNotaFinal() {
		double sumaNotes = 0d;
		double notaMitjana = 0d;
		int totalNotes = super.getLlistatNotes().size();
		int j = 0;

		for (int i = 0; i < totalNotes; i++) {
			int nota = super.getLlistatNotes().get(i);

			if (nota % 2 == 0) {
				sumaNotes += nota * 2;
				j++;
			} else {
				sumaNotes += nota / 2.0;
				j++;
			}
		}

		if (j == 0) {
			return "aviat tindré notes per treure la nota mitjana.";
		}

		notaMitjana = sumaNotes / j;
		return "una nota mitja de " + notaMitjana + ".";
	}

	@Override
	public String toString() {
		return "* Em dic " + super.getNom() + " i sóc l'alumne número " + super.getId() + " amb passaport "
				+ this.getPassaport() + " i " + calcularNotaFinal();
	}
	

	@Override
	public void setDocumentIdentitat(String passaport) {
		this.passaport = passaport;
	}

	@Override
	public double notaFinal() {
		double sumaNotes = 0d;
		double notaMitjana = 0d;
		int totalNotes = super.getLlistatNotes().size();
		int j = 0;

		for (int i = 0; i < totalNotes; i++) {
			int nota = super.getLlistatNotes().get(i);

			if (nota % 2 == 0) {
				sumaNotes += nota * 2;
				j++;
			} else {
				sumaNotes += nota / 2.0;
				j++;
			}
		}
		if (j == 0) {
			notaMitjana = 0.0;
		}else {
			notaMitjana = Math.round((sumaNotes / j) * 100.0) / 100.0;
		}
		return notaMitjana;
	}
	
	
}
