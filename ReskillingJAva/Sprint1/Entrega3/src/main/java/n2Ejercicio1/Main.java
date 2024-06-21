package n2Ejercicio1;

import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Restaurant> restaurants = new HashSet<>();
        
        
        Restaurant r1 = new Restaurant("Lolo", 10);
        Restaurant r2 = new Restaurant("Paco", 7);
        Restaurant r3 = new Restaurant("Casa Lucio", 8);
        Restaurant r4 = new Restaurant("Gorrino", 6);
        Restaurant r5 = new Restaurant("El Gallego", 3);
        Restaurant r6 = new Restaurant("Paco", 5);
        Restaurant r7 = new Restaurant("Lolo", 10);
        
        restaurants.add(r1);
        restaurants.add(r2);
        restaurants.add(r3);
        restaurants.add(r4);
        restaurants.add(r5);
        restaurants.add(r6);
        restaurants.add(r7);
        
        Comparator<Restaurant> comparator = (rest1, rest2) -> rest2.getPunctuation() - rest1.getPunctuation();
        
        restaurants.stream().sorted(comparator).forEach(System.out::println);
        
        
    }
}
