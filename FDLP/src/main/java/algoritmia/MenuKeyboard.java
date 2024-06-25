package algoritmia;

import java.util.Scanner;


public class MenuKeyboard {

    public static void main(String[] args) {     
        
        boolean exit = false;
       
        do{
            switch(menu()){
                case 1 -> method1();
                case 2 -> method2();
                case 3 -> method3();
                case 0 -> {
                    System.out.println("gracias por usar la aplicación.");
                    exit = true;
                }
            }
        }while(!exit);
    }
   
    public static byte menu(){
        Scanner sc = new Scanner(System.in);
        byte option=-1;
        final byte MINIMUM = 0;
        final byte MAXIMUM = 3;

        do{
            System.out.println("\nMENú PRINCIPAL");
            System.out.println("1. Método 1.");
            System.out.println("2. Método 2.");
            System.out.println("3. Método 3.");
            System.out.println("0. Salir de la aplicación.\n");
            if (sc.hasNextByte()) option = sc.nextByte();
            sc.nextLine();
            if(option < MINIMUM || option > MAXIMUM){
                System.out.println("Escoge una opción válida.");
            }
        }while(option < MINIMUM || option > MAXIMUM);
        return option;
    }
   
    public static void method1(){
        System.out.println("Método 1");
    }
   
    public static void method2(){
       System.out.println("Métode 2");
    }
   
    public static void method3(){
       System.out.println("Métode 3");
    }

    
}
