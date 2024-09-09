package n1Exercise1;

import java.util.List;

public interface PizzaBuilder {
    void setSize (String size);
    void setDough (String dough);
    void setToppings (List<String> toppings);
}