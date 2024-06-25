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
public class Encarregat extends Treballador{
    public Encarregat(String nom, int sou, int any, int mes,int dia){
        super(nom,sou,any,mes,dia);
    }
    
    //Realitzem els atributs
    private int incentiu;
    
    //Setter
    public void setIncentiu(int extra){
        incentiu = extra;
    }
    
    //Getter que sobrescriu el metode del pare, només per aquesta classe filla
    public int getSou(){
        //El super fa referencia a que la crida va dirigida el metode del pare per obtenir el valor que retorna getSou()
        int souCap = super.getSou();
        return souCap + incentiu;
    }
       
}
