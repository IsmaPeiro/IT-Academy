/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.Treballadors2;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Oriol
 */
public class Treballador {
    //Definir Atributs
    private String nomusu;
    private int souusu;
    private Date alta;
    private static int idUser;
    
    //Constructor
    public Treballador(){
        
    }
    public Treballador(String nomusu, int sou, int any, int mes, int dia){
        this.nomusu = nomusu;
        souusu = sou;
        GregorianCalendar calendari = new GregorianCalendar(any, (mes-1), dia);
        alta = calendari.getTime();
    }
    
    //Metodes Getter
    public String getNom(){
        return this.nomusu;
    }
    
    public int getSou(){
        return souusu;
    }
    
    public String getInfoUser(){
        return "El treballador " + this.nomusu + " te el id " + idUser + 
                " guanya un sou de " + souusu + " a l'any i es va donar d'alta el " + alta;
    }
    
    //Metodes Setter
    public void setSou(int percentatge){
        int augment = ((souusu*percentatge)/100);
        souusu +=augment;
    }

    public Date getData() {
        return alta;
    }
}
