package n1Exercise1v2;

public class Main {
    public static void main(String[] args) {
        Pizza largeHawaiianPizza = Pizza.builder(PizzaType.HAWAIIAN)
                .setSize("large")
                .setDough("thin")
                .build();
        
        Pizza smallVegetarianPizza = Pizza.builder(PizzaType.VEGETARIAN)
                .setSize("small")
                .setDough("chicago")
                .build();
        
        System.out.println(largeHawaiianPizza.toString());
        System.out.println(smallVegetarianPizza.toString());
    }
}
