package n2exercici1;

public interface Camara {
    default void shootPhoto() {
        System.out.println("Shooting photo.");
    }
}
