package observermitocode;

import observermitocode.observer.PesoARGObservador;
import observermitocode.observer.PesoMEXObservador;
import observermitocode.observer.SolObservador;
import observermitocode.observer.Subject;

public class Main {
    public static void main(String[] args) {
        Subject subject=new Subject();
        
        new SolObservador(subject);
        new PesoMEXObservador(subject);
        new PesoARGObservador(subject);
        
        System.out.println("Si desea cambiar 10 dólares obtendrá:");
        subject.setEstado(10);
        System.out.println("--------------------------------------");
        System.out.println("Si desea cambiar 100 dólares obtendrá:");
        subject.setEstado(100);
    }
}
