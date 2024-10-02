package n1Exercise1;


public class PizzaMaster {
    
    public static PizzaBuilder builder (PizzaType type) {
        if (type==PizzaType.HAWAIIAN)
            return new HawaiianPizzaBuilder();
        if (type==PizzaType.VEGETARIAN)
            return new VegetarianPizzaBuilder();
        else
            return null;
    }
}