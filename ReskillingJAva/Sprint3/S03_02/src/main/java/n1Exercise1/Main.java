package n1Exercise1;

public class Main {
    public static void main(String[] args) {
        Pizza largeHawaiianPizza = Pizza.builder(PizzaType.HAWAIIAN)
                .setSize("large")
                .setDough("thin")
                .build();
        
        Pizza largeHawaiianPizzaCostumed = Pizza.builder(PizzaType.HAWAIIAN)
                .setSize("large")
                .setDough("thin")
                .setToppings("pineapple", "ham")
                .build();
        
        Pizza smallVegetarianPizza = Pizza.builder(PizzaType.VEGETARIAN)
                .setSize("small")
                .setDough("chicago")
                .setExtraToppings("garlic", "carrot")
                .build();
        
        System.out.println(largeHawaiianPizza.toString());
        System.out.println(largeHawaiianPizzaCostumed.toString());
        System.out.println(smallVegetarianPizza.toString());
    }
}
