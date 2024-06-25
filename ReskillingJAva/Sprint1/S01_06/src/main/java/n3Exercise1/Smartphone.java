package n3Exercise1;

public class Smartphone implements Phone {
    public void shootPhoto() {
        System.out.println("Shooting photo.");
    }
    
    @Override
    public void call() {
        System.out.println("Calling");
    }
}
