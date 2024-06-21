package n1ejercicio6;

import java.util.Comparator;
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
        
        map.values().stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }
}
