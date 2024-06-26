package n2Exercise2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Restaurant> restaurantsList = getRestaurants();
        
        restaurantsList.sort(Comparator.comparing(Restaurant::getName).
                thenComparing((rest1,rest2)->rest2.getPunctuation()-rest1.getPunctuation()));
        
        LinkedHashSet<Restaurant> restaurantHash = new LinkedHashSet<>(restaurantsList);
        
        restaurantHash.forEach(System.out::println);
    }
    
    private static ArrayList<Restaurant> getRestaurants() {
        ArrayList<Restaurant> restaurantsList = new ArrayList<>();
        
        Restaurant r1 = new Restaurant("Lolo", 10);
        Restaurant r2 = new Restaurant("Paco", 7);
        Restaurant r3 = new Restaurant("Casa Lucio", 8);
        Restaurant r4 = new Restaurant("Gorrino", 6);
        Restaurant r5 = new Restaurant("El Gallego", 10);
        Restaurant r6 = new Restaurant("Paco", 5);
        Restaurant r7 = new Restaurant("El Gallego", 10);
        Restaurant r8 = new Restaurant("Casa Lucio", 9);
        Restaurant r9 = new Restaurant("Lolo", 10);
        
        restaurantsList.add(r1);
        restaurantsList.add(r2);
        restaurantsList.add(r3);
        restaurantsList.add(r4);
        restaurantsList.add(r5);
        restaurantsList.add(r6);
        restaurantsList.add(r7);
        restaurantsList.add(r8);
        restaurantsList.add(r9);
        
        return restaurantsList;
    }
}
