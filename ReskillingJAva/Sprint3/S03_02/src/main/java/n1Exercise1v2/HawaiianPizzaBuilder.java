package n1Exercise1v2;

import java.util.Arrays;
import java.util.List;

public class HawaiianPizzaBuilder implements PizzaBuilder {
    private PizzaType type=PizzaType.HAWAIIAN;
    private String size;
    private String dough;
    private List<String> toppings= Arrays.asList("pineapple", "cheese", "ham");
    
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
    public Pizza build() {
        Pizza pizza = new Pizza();
        pizza.setType(getType());
        pizza.setToppings(getToppings());
        pizza.setSize(getSize());
        pizza.setDough(getDough());
        return pizza;
    }
}