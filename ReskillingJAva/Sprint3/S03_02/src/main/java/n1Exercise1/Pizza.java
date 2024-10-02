package n1Exercise1;

import java.util.List;

public class Pizza {
    private PizzaType type;
    private String size;
    private String dough;
    private List<String> toppings;
    private List<String> extraToppings;
    
    public List<String> getExtraToppings() {
        return extraToppings;
    }
    
    public void setExtraToppings(List<String> extraToppings) {
        this.extraToppings = extraToppings;
    }
    
    public PizzaType getType() {
        return type;
    }
    
    public void setType(PizzaType type) {
        this.type = type;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public String getDough() {
        return dough;
    }
    
    public void setDough(String dough) {
        this.dough = dough;
    }
    
    public List<String> getToppings() {
        return toppings;
    }
    
    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }
    
    public static PizzaBuilder builder (PizzaType type) {
        return PizzaMaster.builder(type);
    }
    
    @Override
    public String toString() {
        return "Pizza{" +
                "type=" + type +
                ", size='" + size + '\'' +
                ", dough='" + dough + '\'' +
                ", toppings=" + toppings +
                ", extra toppings=" + extraToppings +
                '}';
    }
}
