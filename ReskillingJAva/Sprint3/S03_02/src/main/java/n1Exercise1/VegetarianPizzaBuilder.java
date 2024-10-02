package n1Exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VegetarianPizzaBuilder implements PizzaBuilder {
    private PizzaType type = PizzaType.VEGETARIAN;
    private String size;
    private String dough;
    private List<String> toppings = Arrays.asList("cherry tomatoes", "artichoke", "bell pepper", "olives", "red onion");
    private List<String> extraToppings = new ArrayList<>();
    
    public PizzaType getType() {
        return type;
    }
    
    public String getSize() {
        return size;
    }
    
    public String getDough() {
        return dough;
    }
    
    public List<String> getToppings() {
        return toppings;
    }
    
    public List<String> getExtraToppings() {
        return extraToppings;
    }
    
    @Override
    public PizzaBuilder setSize(String size) {
        this.size = size;
        return this;
    }
    
    @Override
    public PizzaBuilder setDough(String dough) {
        this.dough = dough;
        return this;
    }
    
    @Override
    public PizzaBuilder setToppings(String... toppings) {
        if (toppings!=null) {
            this.toppings=Arrays.asList(toppings);
        }
        return this;
    }
    
    @Override
    public PizzaBuilder setExtraToppings(String... extraToppings) {
        this.extraToppings = Arrays.asList(extraToppings);
        return this;
    }
    
    @Override
    public Pizza build() {
        Pizza pizza = new Pizza();
        pizza.setType(getType());
        pizza.setToppings(getToppings());
        pizza.setSize(getSize());
        pizza.setDough(getDough());
        pizza.setExtraToppings(getExtraToppings());
        return pizza;
    }
}