package n3Exercise1;

public class Main {
    public static void main(String[] args) {
        Person persona=new Person("Enrico", "Fermi", 53);
        
        SerialJson.serialize(persona, persona.getName());
    }
}
