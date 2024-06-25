package examen_revisited_toni_jimenez;

import java.util.ArrayList;

public abstract class Alumne {
	// Atributs
	private int id;
	private String nom;
	private ArrayList<Integer> llistatNotes;

	// Constructors
	public Alumne(int id, String nom) {
		this.id = id;
		this.nom = nom;
		this.llistatNotes = new ArrayList<>();
	}

	public Alumne(int id, String nom, ArrayList<Integer> llistatNotes) {
		this.id = id;
		this.nom = nom;
		this.llistatNotes = llistatNotes;
	}

	// Getters
	public int getId() {
		return this.id;
	}

	public String getNom() {
		return this.nom;
	}

	public ArrayList<Integer> getLlistatNotes() {
		return llistatNotes;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setLlistatNotes(ArrayList<Integer> llistatNotes) {
		this.llistatNotes = llistatNotes;
	}

	// Mètodes
	public abstract String calcularNotaFinal();
	public abstract double notaFinal();
	public abstract void setDocumentIdentitat(String documentIdentitat);
	
	//GESTIÓ NOTES
	//Afegir nota
	public void afegirNota(int nota) {
		this.getLlistatNotes().add(nota);
	}
	//Veure notes
	public String  veureNotes() {
		String resultat = "";
	    for (int i = 0; i < llistatNotes.size(); i++) {
	        resultat += " * " + llistatNotes.get(i) + "\n";
	    }
	    resultat = "\nNotes de l'alumne/a " + nom + ":\n"
	    		+ resultat + "Nota final: " + notaFinal() + "\n";
	    return resultat;
	}	
}
