package n2Exercise1;

public class Main {
    public static void main(String[] args) {
        Person persona=new Person ("Richard", "Feynman", 69);
        
        SerialJson.serialize(persona, persona.getName());
    }
}
