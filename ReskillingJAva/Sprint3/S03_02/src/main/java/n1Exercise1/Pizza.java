package n1Exercise1;

import java.util.List;

public class Pizza {
    private String size;
    private String dough;
    private List<String> toppings;
    
    public Pizza(String size, String dough, List<String> toppings) {
        this.size = size;
        this.dough = dough;
        this.toppings = toppings;
    }
    
    public String getSize() {
        return size;
    }
    
    public Pizza setSize(String size) {
        this.size = size;
        return this;
    }
    
    public String getDough() {
        return dough;
    }
    
    public Pizza setDough(String dough) {
        this.dough = dough;
        return this;
    }
    
    public List<String> getToppings() {
        return toppings;
    }
    
    public Pizza setToppings(List<String> toppings) {
        this.toppings = toppings;
        return this;
    }
    
    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", dough='" + dough + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
