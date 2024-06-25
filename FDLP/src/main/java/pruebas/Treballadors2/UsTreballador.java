/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.Treballadors2;


/**
 *
 * @author Oriol
 */
public class UsTreballador {
    public static void main(String[] Args){
        Encarregat capRRHH = new Encarregat("Jordi",28000,2018,06,12);
        capRRHH.setIncentiu(2570);
        Treballador[] treballadors = new Treballador[4];
        treballadors[0] = new Treballador("Josep",27000,2018,12,03);
        treballadors[1] = capRRHH;//Funciona el polimorfisme, perque crida el getSou() de Encarregat
        treballadors[2] = new Treballador("Anna",32000,2020,12,03);
        treballadors[3] = new Encarregat("Joan",52000,2020,12,03);
        Encarregat capContabilitat = (Encarregat)treballadors[3]; //Refundicio o Cast d'un objecte
        //
        //Encarregat capCompres = (Encarregat)treballadors[2]; //Refundicio o Cast d'un objecte
        //Donara error perque per el funcionament de l'herencia que hem definit, un cap es un treballador, pero un treballador no sempre es un cap.
        for(Treballador j: treballadors){
            j.setSou(5);
        }
        for(Treballador j: treballadors){
            System.out.println("Nom: " + j.getNom() + "Sou: " + j.getSou() + " Data de alta: " + j.getData());
        }
        /*Treballador treballador1 = new Treballador("Josep",27000,2018,12,03);
        System.out.println("Treballador " + treballador1.getSou());
        
        treballador1.setSou(5);
        
        System.out.println("Treballador " + treballador1.getSou());
        System.out.println(treballador1.getInfoUser());
        
        //treballador1.idUser++;
        //treballador1.idUser=treballador1.idUser+1;
        Treballador treballador2 = new Treballador("Anna",32000,2020,12,03);
        treballador2.setSou(5);
        
        System.out.println("Treballador " + treballador2.getSou());
        System.out.println(treballador2.getInfoUser());*/
    }
}
