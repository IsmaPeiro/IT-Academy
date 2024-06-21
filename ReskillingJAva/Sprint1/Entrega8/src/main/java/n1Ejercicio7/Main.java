package n1Ejercicio7;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map=new HashMap<>();
        map.put(1, "Hello");
        map.put(2, "Screen");
        map.put(3, "Vulcano");
        map.put(4, "Ant");
        map.put(5, "Phaser");
        map.put(6, "No");
        map.put(7, "Yes");
        
        map.values().stream().sorted((v1,v2)->v2.length()-v1.length()).forEach(System.out::println);
        
    }
}
