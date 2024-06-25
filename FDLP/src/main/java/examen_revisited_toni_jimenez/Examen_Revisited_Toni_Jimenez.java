package examen_revisited_toni_jimenez;

import java.util.ArrayList;
import java.util.Scanner;

public class Examen_Revisited_Toni_Jimenez {

	static ArrayList<Curs> cursos = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcio = -1, numCurs = 0, id = 0, nota = 0;
		String nom = "", documentIdentitat = "", resposta = "", nomCurs = "";
		// boolean erasmus = false;

		Scanner entrada = new Scanner(System.in);

/////////////////////////////TEST		
		// Afegeixo curs (punt 1: OK)
		afegirCurs("Fonaments de la programació");
		afegirCurs("Aprèn GO creant la teva pròpia aplicació executable");
		afegirCurs("Cuina tradicional xinesa");

		// Mostro cursos
		System.out.println(mostraCursos());
		
		// Canviar el nom del curs
		System.out.println(modificaCurs(2, "Introducció a Go!"));

		// Mostro cursos
		System.out.println(mostraCursos());

		// Afegeixo alummnes (punts 2 a 6: OK)
		cursos.get(0).insertaAlumne(1, "Marc", "1234567A");
		cursos.get(0).insertaAlumne(2, "Laia", "98765432B");
		cursos.get(0).insertaAlumne(3, "Peter", "ABC123456");
		cursos.get(0).insertaAlumne(4, "Kate", "DEF654321");

		// Mostro noms (punt 7: OK)
		System.out.println(veureCurs("Fonaments de la programació"));

		// Canviar el nom del curs
		System.out.println(modificaCurs(1, "Introducció a la programació en Java (I)"));

		// Mostro noms (punt 7: OK)
		System.out.println(veureCurs("Introducció a la programació en Java (I)"));

		// Eliminar curs
		System.out.println(eliminaCurs(10));
		System.out.println(eliminaCurs(2));

		// Mostro cursos
		System.out.println(mostraCursos());

		// Afegeixo notes del Marc (punt 8)
		cursos.get(0).getAlumnes().get(0).afegirNota(1);
		cursos.get(0).getAlumnes().get(0).afegirNota(3);
		cursos.get(0).getAlumnes().get(0).afegirNota(5);
		cursos.get(0).getAlumnes().get(0).afegirNota(7);
		cursos.get(0).getAlumnes().get(0).afegirNota(9);

		// Afegeixo notes de la Laia (punt 9)
		cursos.get(0).getAlumnes().get(1).afegirNota(2);
		cursos.get(0).getAlumnes().get(1).afegirNota(4);
		cursos.get(0).getAlumnes().get(1).afegirNota(6);
		cursos.get(0).getAlumnes().get(1).afegirNota(8);
		cursos.get(0).getAlumnes().get(1).afegirNota(10);

		// Afegeixo notes del Peter (punt 10)
		cursos.get(0).getAlumnes().get(2).afegirNota(1);
		cursos.get(0).getAlumnes().get(2).afegirNota(2);
		cursos.get(0).getAlumnes().get(2).afegirNota(5);
		cursos.get(0).getAlumnes().get(2).afegirNota(6);
		cursos.get(0).getAlumnes().get(2).afegirNota(9);
		cursos.get(0).getAlumnes().get(2).afegirNota(10);

		// Afegeixo notes de la Kate (punt 11)
		cursos.get(0).getAlumnes().get(3).afegirNota(3);
		cursos.get(0).getAlumnes().get(3).afegirNota(4);
		cursos.get(0).getAlumnes().get(3).afegirNota(7);
		cursos.get(0).getAlumnes().get(3).afegirNota(8);

		// Calcula i imprimeix les notes finals de cada alumne juntament amb la seva
		// presentació (punt 12: OK)
		System.out.println(veureCurs("Introducció a la programació en Java (I)"));

		// Elimina l’alumne (punt 13: OK)
		System.out.println(cursos.get(0).eliminarAlumne(1));

		// Canvia el nom (punt 14: OK)
		cursos.get(0).modificarNomAlumne(3, "Jason");

		// Mostro noms (punt 15: OK)
		System.out.println(veureCurs("Introducció a la programació en Java (I)"));

/////////////////////////////APLICACIÓ
		
		do {
			System.out.println("**IT Academy**\n" + " 1. Gestió de cursos\n" + " 2. Gestió d'alumnes\n"
					+ " 3. Gestió de notes\n" + " 0. Sortir de l'aplicació\n" + "Tria la teva opció:");
			opcio = entrada.nextInt();
			switch (opcio) {
			case 0:
				resposta = "Gràcies per utilitzar la nostra aplicació.\n" + "Fins aviat!\n";
				break;
			case 1: // Cursos
				do {
					System.out.println("Gestió de cursos\n" + " 1. Afegir curs\n" + " 2. Llistar cursos\n"
							+ " 3. Consultar curs\n" + " 4. Editar nom del curs\n" + " 5. Eliminar curs\n"
							+ " 0. Tornar al menú principal\n" + "Tria la teva opció:");
					opcio = entrada.nextInt();
					entrada.nextLine();
					switch (opcio) {
					case 0:
						opcio = -1;
						resposta = "Heu sortit de la gestió de cursos.\n";
						break;
					case 1: // afegir curs
						System.out.println("Indica el nom del curs que vols afegir:");
						nomCurs = entrada.nextLine();
						resposta = afegirCurs(nomCurs);
						break;
					case 2: // veure curs i alumnes
						System.out.println(mostraCursos());
						break;
					case 3: // veure curs i alumnes
						System.out.println(mostraCursos());
						System.out.println("Indica el nom del curs que vols consultar:");
						numCurs = entrada.nextInt();
						resposta = veureCursNum(numCurs);
						break;
					case 4: // editar nom del curs
						System.out.println(mostraCursos());
						System.out.println("Indica el nombre del curs que vols editar:");
						numCurs = entrada.nextInt();
						entrada.nextLine();
						System.out.println("Indica el nou nom del curs:");
						nomCurs = entrada.nextLine();
						resposta = modificaCurs(numCurs, nomCurs);
						break;
					case 5:
						System.out.println(mostraCursos());
						System.out.println("Indica el nombre del curs que vols eliminar:");
						numCurs = entrada.nextInt();
						resposta = eliminaCurs(numCurs);
						break;
					default:
						if (opcio != -1) {
							resposta = "L'opció indicada no existeix. Torna a provar amb una del llistat facilitat.\n";
						}
						break;
					}
					System.out.println(resposta);
				} while (opcio != -1);
				break;
			case 2: // Alumnes
				do {
					System.out.println("Gestió d'alumnes\n" 
							+ " 1. Afegir alumne\n" 
							+ " 2. Llistar alumnes\n"
							+ " 3. Consultar alumne\n" 
							+ " 4. Editar nom de l'alumne\n"
							+ " 5. Editar passaport/dni de l'alumne\n" 
							+ " 6. Eliminar registre de l'alumne\n"
							+ " 0. Tornar al menú principal\n" 
							+ "Tria la teva opció:");
					opcio = entrada.nextInt();

					switch (opcio) {
					case 0:
						opcio = -1;
						resposta = "Heu sortit de la gestió d'alumnes.\n";
						break;
					case 1: // afegir alumne
						System.out.println(mostraCursos());
						System.out.println("Indica el nombre del curs:");
						numCurs = entrada.nextInt() - 1;
						id = cursos.get(numCurs).generarId();
						entrada.nextLine();
						System.out.println("Indica el teu nom:");
						nom = entrada.nextLine();
						System.out.println("Indica el teu document d'identitat:");
						documentIdentitat = entrada.nextLine();
						cursos.get(numCurs).insertaAlumne(id, nom, documentIdentitat);
						break;
					case 2: // veure llistat d'alumnes (s'ha afegit mètode d'ordenació de bombolla)
						System.out.println(mostraCursos());
						System.out.println("Indica el nom del curs que vols consultar:");
						numCurs = entrada.nextInt();
						resposta = veureCursNum(numCurs);
						break;
					case 3: // consultar alumne
						System.out.println(mostraCursos());
						System.out.println("Indica el nombre del curs que vols consultar:");
						numCurs = entrada.nextInt() - 1;
						System.out.println(cursos.get(numCurs).mostraNomAlumnes());
						if (cursos.get(numCurs).getAlumnes().size() != 0) {
							System.out.println("Indica l'ID de l'estudiant que vols consultar:");
							id = entrada.nextInt();
							resposta = cursos.get(numCurs).cercarAlumneId(id) + "\n";
						}else {
							resposta = "No hi ha cap alumne matriculat a aquest curs.\n";	
						}
						break;
					case 4: // editar nom
						System.out.println(mostraCursos());
						System.out.println("Indica el nombre del curs que vols consultar:");
						numCurs = entrada.nextInt() - 1;
						if (cursos.get(numCurs).getAlumnes().size() != 0) {
							System.out.println(cursos.get(numCurs).mostraNomAlumnes());
							System.out.println("Indica l'ID de l'estudiant que vols modificar:");
							id = entrada.nextInt();
							entrada.nextLine();
							System.out.println("Indica el nou nom:");
							nom = entrada.nextLine();
							resposta = cursos.get(numCurs).modificarNomAlumne(id, nom);
						}else {
							resposta = "No hi ha cap alumne matriculat a aquest curs.\n";	
						}
						
						break;
					case 5: // editar passaport/dni
						System.out.println(mostraCursos());
						System.out.println("Indica el nombre del curs que vols consultar:");
						numCurs = entrada.nextInt() - 1;
						if (cursos.get(numCurs).getAlumnes().size() != 0) {
							System.out.println(cursos.get(numCurs).mostraNomAlumnes());
							System.out.println("Indica l'ID de l'estudiant que vols modificar:");
							id = entrada.nextInt();
							entrada.nextLine();
							System.out.println("Indica el nou passaport/dni:");
							documentIdentitat = entrada.nextLine();
							resposta = cursos.get(numCurs).modificardocumentIdentitat(id, documentIdentitat);
						}else {
							resposta = "No hi ha cap alumne matriculat a aquest curs.\n";	
						}						
						break;
					case 6: // eliminar registre de l'alumne
						System.out.println(mostraCursos());
						System.out.println("Indica el nombre del curs que vols consultar:");
						numCurs = entrada.nextInt() - 1;
						if (cursos.get(numCurs).getAlumnes().size() != 0) {
							System.out.println(cursos.get(numCurs).mostraNomAlumnes());
							System.out.println("Indica l'ID de l'estudiant que vols eliminar:");
							id = entrada.nextInt();
							resposta = cursos.get(numCurs).eliminarAlumne(id);
						}else {
							resposta = "No hi ha cap alumne matriculat a aquest curs.";	
						}
						break;
					default:
						if (opcio != -1) {
							resposta = "L'opció indicada no existeix. Torna a provar amb una del llistat facilitat.\n";
						}
					}
					System.out.println(resposta);
				} while (opcio != -1);
				break;
			case 3: // Notes
				do {
					System.out.println("Gestió de notes\n" 
							+ " 1. Afegir notes\n" 
							+ " 2. Llistar notes de la classe\n"
							+ " 3. Veure nota mitjana del curs\n" 
							+ " 4. Consultar notes del alumne\n"
							+ " 0. Tornar al menú principal\n"
							+ "Tria la teva opció:");
					opcio = entrada.nextInt();

					switch (opcio) {
					case 0:
						opcio = -1;
						resposta = "Heu sortit de la gestió d'alumnes.\n";
						break;
					case 1: //afegir nota
						System.out.println(mostraCursos());
						System.out.println("Indica el nombre del curs que vols consultar:");
						numCurs = entrada.nextInt() -1 ;
						System.out.println(cursos.get(numCurs).mostraNomAlumnes());
						System.out.println("Indica l'ID de l'estudiant que vols puntuar:");
						id = entrada.nextInt();
						id = cursos.get(numCurs).possicioReal(id);
						System.out.println("Indica la nota a afegir:");
						nota = entrada.nextInt();
						cursos.get(numCurs).getAlumnes().get(id).afegirNota(nota);
						break;
					case 2: //llistar notes de la classe
						System.out.println(mostraCursos());
						System.out.println("Indica el nombre del curs que vols consultar:");
						numCurs = entrada.nextInt() -1;
						resposta = cursos.get(numCurs).notesCurs();
						break;
					case 3: //veure nota mitjana del curs
						System.out.println(mostraCursos());
					    System.out.println("Indica el nombre del curs que vols consultar:");
					    numCurs = entrada.nextInt() - 1;
					    System.out.println(cursos.get(numCurs).mitjanaCurs());
						break;
					case 4: //llistar notes de l'alumne
						System.out.println(mostraCursos());
					    System.out.println("Indica el nombre del curs que vols consultar:");
					    numCurs = entrada.nextInt() - 1;
					    entrada.nextLine();
					    System.out.println(cursos.get(numCurs).mostraNomAlumnes());
					    System.out.println("Indica el nombre de l'estudiant que vols consultar:");
					    id = entrada.nextInt();
					    id = cursos.get(numCurs).possicioReal(id);
					    resposta = cursos.get(numCurs).getAlumnes().get(id).veureNotes();
					    break;
					default:
						if (opcio != -1) {
							resposta = "L'opció indicada no existeix. Torna a provar amb una del llistat facilitat.\n";
						}
						break;
					}
					System.out.println(resposta);
				} while (opcio != -1);
				break;
			default:
				if (opcio != -1) {
					resposta = "L'opció indicada no existeix. Torna a provar amb una del llistat facilitat.\n";
				}
				break;
			}
		} while (opcio != 0);
		entrada.close();
	}
	// GESTIÓ DE CURSOS

	// Afegir curs
	public static String afegirCurs(String nomCurs) {
		cursos.add(new Curs(nomCurs));
		return "S'ha creat el curs: " + nomCurs + ".\n";
	}

	// Veure curs per nom
	public static String veureCurs(String nomCurs) {
		String resultat = "";
		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getNom().equals(nomCurs)) {
				resultat += "Alumnes del curs: " + cursos.get(i).getNom() + ".\n";
				resultat += cursos.get(i).veureAlumnes();
			}
		}
		return resultat;
	}

	// Veure curs per num
	public static String veureCursNum(int numCurs) {
		String resultat = "";
		for (int i = 0; i < cursos.size(); i++) {
			if (i == numCurs - 1) {
				resultat += "Alumnes del curs: " + cursos.get(i).getNom() + ".\n";
				resultat += cursos.get(i).veureAlumnes();
			}
		}
		return resultat;
	}

	// Veure cursos
	public static String mostraCursos() {
		String resultat = "";
		for (int i = 0; i < cursos.size(); i++) {
			resultat += " " + (i + 1) + ". " + cursos.get(i).getNom() + "\n";
		}
		resultat = "Els nostres cursos:\n" + resultat;
		return resultat;
	}

	// Modifica curs
	public static String modificaCurs(int numCurs, String nomCurs) {
		int i = 0;
		boolean trobat = false;
		while (i < cursos.size() && !trobat) {
			if (i == numCurs - 1) {
				cursos.get(i).setNom(nomCurs);
				trobat = true;
			}
			i++;
		}
		if (trobat) {
			return "El nom del curs s'ha modificat a: " + nomCurs + "\n";
		} else {
			return "El curs indicat no és pas registrat.\n";
		}
	}

	// Eliminar curs
	public static String eliminaCurs(int numCurs) {
		int i = 0;
		String nomCurs = "";
		boolean trobat = false;
		while (i < cursos.size() && !trobat) {
			if (i == numCurs - 1) {
				nomCurs = cursos.get(i).getNom();
				cursos.remove(i);
				trobat = true;
			}
			i++;
		}
		if (trobat) {
			return "S'ha eliminat el curs: " + nomCurs + ".\n";
		} else {
			return "El curs indicat no és pas registrat.\n";
		}
	}
	//Possició real del ID del curs
	/*public static int possicioRealCurs(int id) {
		int possicio = 0;
	    boolean trobat = false;
	    int i = 0;
	    while (i < cursos.size() && !trobat) {
	        if (cursos.get(i).getId() == id) {
	            possicio = i;
	            trobat = true;
	        }
	        i++;
	    }
	    return possicio;
	}*/
}