package algoritmia;

import java.util.Scanner;

public class M71ejercicio8 {
	/*Crea un menú que permeti canviar d’unitats:

		Passar de metres a peus.
		De peus a metres.
		De metres a iardes.
		De iardes a metres*/


	public static void main(String[] args) {
		boolean sortir = false;
	       
        do{
            switch(menu()){
                case 1: conversion("metros", 3.28084, "pies");
                        break;
                case 2: conversion("pies", 0.3048000097536,"metros");
                        break;
                case 3: conversion("metros",0.9144,"yardas");
                        break;
                case 4: conversion("yardas",1.09361,"metros");
                break;
                case 0: System.out.println("Gracias por usar la aplicación");
                		sortir = true;
                        break;
            }
        }while(!sortir);   
    }
   
    public static byte menu(){
        Scanner entrada = new Scanner(System.in);
        byte opcio;
        final byte MINIMO = 0;
        final byte MAXIMO = 4;

        do{
            System.out.println("\nMENú PRINCIPAL");
            System.out.println("1. Pasar de metros a pies.");
            System.out.println("2. Pasar de pies a metros.");
            System.out.println("3. Pasar de metros a yardas.");
            System.out.println("4. Pasar de yardas a metros.");
            System.out.println("0. Salir de la aplicación.\n");
            opcio = entrada.nextByte();
            if(opcio < MINIMO || opcio > MAXIMO){
                System.out.println("Escoge una opción válida");
            }
        }while(opcio < MINIMO || opcio > MAXIMO);
        return opcio;
    }
   
    public static void conversion(String unitIn, double conversionFactor, String unitOut){
    	
    	double amount;
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Introduce los "+unitIn+":");
    	amount=sc.nextDouble();
        System.out.println(amount+" "+unitIn+" son: "+amount*conversionFactor+" "+unitOut);
    }
}