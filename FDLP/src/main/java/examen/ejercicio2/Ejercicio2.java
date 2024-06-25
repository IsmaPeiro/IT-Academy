package examen.ejercicio2;

import java.util.ArrayList;

public class Ejercicio2 {

    public static void main(String[] args) {
		/*
		 * Donat un arrayList de paraules. Uneix les paraules de dos en dos utilitzant la notació lowerCamelCase.
Exemple: hola, món, fonaments, programació.
Sortida: holaMón, fonamentsProgramació
		 */
        String palabra2 = "";
        ArrayList<String> palabras = new ArrayList<String>();
        palabras.add("HOLA");
        palabras.add("món");
        palabras.add("fonaments");
        palabras.add("programacio");
        palabras.add("pelota");
        palabras.add("barco");
        palabras.add("barco");

        for (int i = 0; i < palabras.size(); i++) {
            if (i % 2 == 0) {
                if (i != palabras.size() - 1) {
                    palabra2 = palabras.get(i + 1);
                    palabra2 = palabra2.substring(0, 1).toUpperCase();
                    palabra2 += palabras.get(i + 1).substring(1).toLowerCase();
                    System.out.println(palabras.get(i).toLowerCase() + palabra2);
                } else {
                    System.out.println(palabras.get(i).toLowerCase());
                }
            }
        }
    }
}
