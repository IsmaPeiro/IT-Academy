package n1Ejercicio5;

public class Main {
    public static void main(String[] args) {
        
        Pi pi=()->3.1415d;
        
        System.out.println(pi.getPiValue());
    }
    
    @FunctionalInterface
    public interface Pi {
        Double getPiValue();
    }
    
    
}
