package n2Exercise2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       TreeSet<Restaurant> restaurantTreeSet = getRestaurants();
       
       restaurantTreeSet.forEach(System.out::println);
    }
    
    private static TreeSet<Restaurant> getRestaurants() {
        
        TreeSet<Restaurant> restaurantTreeSet = new TreeSet<>();
        
        Restaurant r1 = new Restaurant("Lolo", 10);
        Restaurant r2 = new Restaurant("Paco", 7);
        Restaurant r3 = new Restaurant("casa lucio", 8);
        Restaurant r4 = new Restaurant("Gorrino", 6);
        Restaurant r5 = new Restaurant("El Gallego", 10);
        Restaurant r6 = new Restaurant("Paco", 5);
        Restaurant r7 = new Restaurant("El Gallego", 10);
        Restaurant r8 = new Restaurant("Casa Lucio", 9);
        Restaurant r9 = new Restaurant("lolo", 10);
        
        restaurantTreeSet.add(r1);
        restaurantTreeSet.add(r2);
        restaurantTreeSet.add(r3);
        restaurantTreeSet.add(r4);
        restaurantTreeSet.add(r5);
        restaurantTreeSet.add(r6);
        restaurantTreeSet.add(r7);
        restaurantTreeSet.add(r8);
        restaurantTreeSet.add(r9);
        
        return restaurantTreeSet;
    }
}
