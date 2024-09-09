package n1Exercise1;

import java.util.List;

public class VegetarianPizzaBuilder implements PizzaBuilder {
    private String size;
    private String dough;
    private List<String> toppings;
    
    @Override
    public void setSize(String size) {
        this.size=size;
    }
    
    @Override
    public void setDough(String dough) {
        this.dough=dough;
    }
    
    @Override
    public void setToppings(List<String> toppings) {
        this.toppings=toppings;
    }
    
    public Pizza getResult() {
        return new Pizza (size, dough, toppings);
    }
}
