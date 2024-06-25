package examen_revisited_toni_jimenez;

import java.util.ArrayList;

public class Curs {
	
	//Atributs
    private String nom;
    private ArrayList<Alumne> alumnes;

    //Constructor
    public Curs(String nom) {
        this.nom = nom;
        this.alumnes = new ArrayList<Alumne>();
    }
    
    //Getters
    public String getNom() {
        return this.nom;
    }
    public ArrayList<Alumne> getAlumnes() {
        return this.alumnes;
    }
    
    //Setters
    public void setNom(String nom) {
    	this.nom = nom;
    }

	//GESTIÓ D'ALUMNES
    
    //Generar ID
    public int generarId() {
    	int id = 1;
        int i = 0;
        boolean trobat = false;

        while (!trobat && i < alumnes.size()) {
            if (alumnes.get(i).getId() == id) {
            	trobat = false;
            	id++;
                i = 0;
            } else {
                i++;
            }
        }
        return id;	
    }
	//Afegir alumne
    public void insertaAlumne(int id, String nom, String identificacio) {
    char primerCaracter = identificacio.charAt(0);
    Alumne alumne;
    
    if (primerCaracter >= '0' && primerCaracter <= '9') {
    	alumne = new AlumneNacional(id, nom, identificacio);
    } else {
    	alumne = new AlumneInternacional(id, nom, identificacio);
    }
    alumnes.add(alumne);	
    }
	//Cercar Alumne pel nom
	public String buscaAlumneNom(String nom) {
		String resultat = "";
		for (int i = 0; i < alumnes.size(); i++) {
			if (alumnes.get(i).getNom().equals(nom)) {
				resultat = alumnes.get(i).toString() ;
			}
		}
		return resultat;
	}
	//Cercar Alumne per l'ID
	public String cercarAlumneId(int id) {
		String resultat = "";
		for (int i = 0; i < alumnes.size(); i++) {
			if (alumnes.get(i).getId() == id) {
				resultat = alumnes.get(i).toString() ;
			}
		}
		return resultat;
	}
	//Trobar el nom de l'alumne per l'ID
	public String cercarNomAmbId(int idAlumne) {
	    int i = 0;
	    boolean trobat = false;
	    String nomAlumne = "";
	    
	    while (i < alumnes.size() && !trobat) {
	        if (alumnes.get(i).getId() == idAlumne) {
	            nomAlumne = alumnes.get(i).getNom();
	            trobat = true;
	        }
	        i++;
	    }
	    return nomAlumne;
	}
	// Eliminar Alumne
	public String eliminarAlumne(int idAlumne) {
	    boolean trobat = false;
	    int i = 0;
	    String nomAlumne = cercarNomAmbId(idAlumne); 
	    while (i < alumnes.size() && !trobat) {
	        if (alumnes.get(i).getNom().equals(nomAlumne)) {
	            alumnes.remove(i);
	            trobat = true;
	        }
	        i++;
	    }
	    
	    if (trobat) {
	        return "S'ha eliminat l'alumne amb nom: " + nomAlumne + ".\n";
	    } else {
	        return "No s'ha trobat cap alumne amb el nom: " + nomAlumne + ".\n";
	    }
	}
	
	//Mostrar els noms dels alumnes()
    public String mostraNomAlumnes() {
        String resultat = "";
        
        for (int i = 0; i < alumnes.size() - 1; i++) {
            for (int j = 0; j < alumnes.size() - i - 1; j++) {
                if (alumnes.get(j).getId() > alumnes.get(j + 1).getId()) {
                    Alumne temp = alumnes.get(j);
                    alumnes.set(j, alumnes.get(j + 1));
                    alumnes.set(j + 1, temp);
                }
            }
        }
        
        for (int i = 0; i < alumnes.size(); i++) {
    		resultat += " " + alumnes.get(i).getId() + ". " +  alumnes.get(i).getNom() + "\n" ;
    	}
    	return resultat;		
    }
    //veureAlumnes()
    public String veureAlumnes() {
    	String info = "";
    	
        for (int i = 0; i < alumnes.size() - 1; i++) {
            for (int j = 0; j < alumnes.size() - i - 1; j++) {
                if (alumnes.get(j).getId() > alumnes.get(j + 1).getId()) {
                    Alumne temp = alumnes.get(j);
                    alumnes.set(j, alumnes.get(j + 1));
                    alumnes.set(j + 1, temp);
                }
            }
        }
        
    	for (int i = 0; i < alumnes.size(); i++) {
    		info += alumnes.get(i).toString() + "\n";
    	}
    return info;
    }
    //Modifica nom d'alumne
    public String modificarNomAlumne(int numAlumne, String nouNom) {
        int i = 0;
        boolean trobat = false;
        while (i < alumnes.size() && !trobat) {
            if (i == numAlumne - 1) {
            	alumnes.get(i).setNom(nouNom);
                trobat = true;
            }
            i++;
        }
        if (trobat) {
            return "El nom de l'alumne " + numAlumne + " s'ha modificat a: " + nouNom + "\n";
        } else {
            return "L'alumne indicat no és pas registrat.\n";
        }
    }
    //Modificar Document d'identitat
	public String modificardocumentIdentitat(int numAlumne, String documentIdentitat) {
    	int i = 0;
        boolean trobat = false;
        while (i < alumnes.size() && !trobat) {
            if (alumnes.get(i).getId() == numAlumne) {
                alumnes.get(i).setDocumentIdentitat(documentIdentitat);
                trobat = true;
            }
            i++;
        }
        if (trobat) {
            return "El document d'identitat de l'alumne " + numAlumne + " s'ha modificat a: " + documentIdentitat + "\n";
        } else {
            return "L'alumne amb ID " + numAlumne + " no existeix.\n";
        }
    }
    //Eliminar alumne
    public String eliminaAlumne(int numAlumne) {
        int i = 0;
        String nomAlumne = ""; 
        boolean trobat = false;
        while (i < alumnes.size() && !trobat) {
            if (i == numAlumne - 1) {
            	nomAlumne = alumnes.get(i).getNom();
            	System.out.println(nomAlumne);
                alumnes.remove(i);
                trobat = true;
            }
            i++;
        }
        if (trobat) {
            return "S'ha eliminat el registre de l'alumne " + nomAlumne + ".\n";
        } else {
            return "L'alumne " + nomAlumne + " indicat no és pas registrat.\n";
        }
    }
	//Possició real del ID del Alumne
	public int possicioReal(int id) {
		int possicio = -1;
	    for (int i = 0; i < alumnes.size(); i++) {
	        if (alumnes.get(i).getId() == id) {
	            possicio = i;
	            return possicio;
	        }
	    }
	    return possicio;
	}
	//Veure notes de tota la classe
	public String notesCurs() {
        String resultat = "";
        for (int i = 0; i < alumnes.size(); i++) {
        	resultat += alumnes.get(i).veureNotes();
        }
        return resultat;
    }
	//Calcular nota mitjana de la classe
	public String mitjanaCurs() {
		 String llista = "";
		 String resultat = "";
		 double sumaNotes = 0d;
		 double mitjanaAlumne = 0d;
		 double mitjanaClasse = 0d;
		 int totalAlumnes = alumnes.size();

		 for (int i = 0; i < totalAlumnes; i++) {
			 mitjanaAlumne = alumnes.get(i).notaFinal();
		        sumaNotes += mitjanaAlumne;
		        llista += alumnes.get(i).getNom() + ". Nota Mitjana: " + mitjanaAlumne + "\n";
		 }

		 if (totalAlumnes > 0) {
			 mitjanaClasse = Math.round((sumaNotes / totalAlumnes) * 100.0) / 100.0;
			 resultat = llista + "\n"
			 		+ "Nota Mitjana de la Classe: " + mitjanaClasse;
		 } else {
			 resultat = "No hi ha alumnes a la classe.\n";
		 }
		 return resultat;
	}
}
