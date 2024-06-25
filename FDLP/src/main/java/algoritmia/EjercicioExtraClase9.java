package algoritmia;

import java.util.Scanner;

public class EjercicioExtraClase9 {

	public static void main(String[] args) {
		/*
		 * El programa escull a l'atzar entre: "Espada", "Hacha" i "Lanza".
		 * Llavors l'usuari/a escull una de les tres i en funció de les 
		 * premises següents hem de dir qui ha guanyat.
		 * “Espada” guanya a “Hacha”.
		 * “Hacha” guanya a “Lanza”.
		 * “Lanza” guanya a “Espada”
		 */
		
				
		boolean sortir = false;
	    int resultado=0;
	    final int GANAS=1;
		final int PIERDES=2;
		final int EMPATE=0;
		int ganadas=0;
		int perdidas=0;
		int empates=0;
		
        do{
            switch(menu()){
                case 1: resultado=juego(1);
                        break;
                case 2: resultado=juego(2);
                        break;
                case 3: resultado=juego(3);
                        break;
                case 0: finalPartida(ganadas, perdidas, empates);
                		sortir = true;
                        break;
            }
            
            if (resultado==GANAS) {
            	ganadas++;
            } else if (resultado==PIERDES) {
            	perdidas++;
            } else if (resultado==EMPATE) {
            	empates++;
            }
            
        }while(!sortir);   
    }
   
    public static byte menu(){
        Scanner entrada = new Scanner(System.in);
        byte opcio;
        final byte MINIMO = 0;
        final byte MAXIMO = 3;

        do{
            System.out.println("\nEspada-Hacha-Lanza");
            System.out.println("******************");
            System.out.println("escoge un arma:");
            System.out.println("1. Espada.");
            System.out.println("2. Hacha.");
            System.out.println("3. Lanza.");
            System.out.println("0. Salir.\n");
            opcio = entrada.nextByte();
            if(opcio < MINIMO || opcio > MAXIMO){
                System.out.println("Escoge una opción válida");
            }
        }while(opcio < MINIMO || opcio > MAXIMO);
        return opcio;
    }
   
    public static int juego (int jugadaUser){
    	System.out.println(jugadaUser);
    	final int ESPADA=1;
		final int HACHA=2;
		final int LANZA=3;		
		final int GANAS=1;
		final int PIERDES=2;
		final int EMPATE=0;
		
    	int jugadaPC = (int) (Math.random() * 3) + 1;
    	int resultado;
    	if (jugadaUser==ESPADA&&jugadaPC==HACHA || jugadaUser==HACHA&&jugadaPC==LANZA || jugadaUser==LANZA&&jugadaPC==ESPADA) {
    		System.out.println("Has ganado, has sacado "+ selectWeapon(jugadaUser) + " y yo "+selectWeapon(jugadaPC));
    		resultado=GANAS;
    	} else if (jugadaPC==ESPADA&&jugadaUser==HACHA || jugadaPC==HACHA&&jugadaUser==LANZA || jugadaPC==LANZA&&jugadaUser==ESPADA) {
    		System.out.println("Has perdido, has sacado "+ selectWeapon(jugadaUser) + " y yo "+selectWeapon(jugadaPC));
    		resultado=PIERDES;
    	} else {
    		System.out.println("Hemos empatado, has sacado "+ selectWeapon(jugadaUser) + " y yo "+selectWeapon(jugadaPC));
    		resultado=EMPATE;
    	}
    	return resultado;		
    }
   
    public static String selectWeapon(int jugada){
    	String arma="";
    	switch (jugada) {
		case 1:
			arma="Espada";
			break;
		case 2:
			arma="Hacha";
			break;
		case 3:
			arma="Lanza";
			break;
		}
    	return arma;
    }
    
    public static void finalPartida (int ganadas, int perdidas, int empates) {
    	System.out.println("Gracias por jugar.");
    	System.out.println("Hemos jugado "+(ganadas+perdidas+empates)+" partidas.");
    	System.out.println("Has ganado "+ganadas+" partidas.");
    	System.out.println("Has perdido "+perdidas+" partidas.");
    	System.out.println("Hemos empatado "+empates+" partidas.");
    }
}
   
   