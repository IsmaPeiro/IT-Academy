package observermitocode.observer;

public class PesoMEXObservador extends Observador {
    private double valorCambio=19.07;
    
    public PesoMEXObservador(Subject sujeto) {
        this.sujeto=sujeto;
        this.sujeto.agregar(this);
    }
    
    @Override
    public void actualizar() {
        System.out.println("MEX: "+(sujeto.getEstado() * valorCambio));
    }
}
