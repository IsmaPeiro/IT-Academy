package n1Exercise1;


import java.util.Arrays;

public class PizzaMaster {
    
    public void makeHawaiianPizza(PizzaBuilder builder) {
        builder.setSize("Median");
        builder.setDough("thin");
        builder.setToppings(Arrays.asList("pineapple", "cheese", "ham"));
    }
    
    public void makeVegetarianPizza(PizzaBuilder builder) {
        builder.setSize("Median");
        builder.setDough("thin");
        builder.setToppings(Arrays.asList("cherry tomatoes", "artichoke", "bell pepper", "olives", "red onion"));
    }
}
