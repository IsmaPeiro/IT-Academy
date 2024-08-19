package mementoprueba1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Memento memento=new Memento();
        
        /*memento.setState("State #1");
        memento.save();
        System.out.println("Save 1: "+memento);
        memento.setState("State #2");
        memento.save();
        System.out.println("Save 2: "+memento);
        memento.setState("State #3");
        memento.save();
        System.out.println("Save 3: "+memento);
        memento.setState("State #4");
        memento.save();
        System.out.println("Save 4: "+memento);
       
        System.out.println("State at position 2: "+memento.getPosition(2));
       
        memento.setPosition(2);
        System.out.println("Current State: "+memento);
        memento.back();
        System.out.println("Memento 1: "+memento);
        memento.back();
        System.out.println("Memento 2: "+memento);
        memento.forward();
        System.out.println("Redo 1: "+memento);
        
        memento.showAll().forEach(System.out::println);
        memento.removePosition(2);
        memento.showAll().forEach(System.out::println);
        System.out.println("Current State: "+memento);
        memento.removePosition(2);
        memento.showAll().forEach(System.out::println);
        System.out.println("Current State: "+memento);*/
        
        Scanner sc=new Scanner(System.in);
        System.out.println("comandos, UNDO, LIST, REMOVE, EXIT");
        boolean exit=false;
        String cmd="";
        do {
            cmd=sc.nextLine();
            switch (cmd.toUpperCase()) {
               case "EXIT"->exit=true;
               case "UNDO"->{
                   memento.back();
                   System.out.println("Current State: "+memento);
               }
               case "LIST"-> memento.showAll().forEach(System.out::println);
               case "REMOVE"->{
                   memento.removePosition();
                   System.out.println("Current State: "+memento);
               }
               default->{
                   memento.setState(cmd);
                   memento.save();
                   System.out.println("Current State: "+memento);
               }
            }
        } while (exit==false);
        
    }
}
