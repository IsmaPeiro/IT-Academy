package n1Exercise1v2;

import java.util.List;

public interface PizzaBuilder {
    PizzaBuilder setSize (String size);
    PizzaBuilder setDough (String dough);
    Pizza build();
}