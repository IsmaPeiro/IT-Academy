package n1Exercise1;

public interface PizzaBuilder {
    PizzaBuilder setSize (String size);
    PizzaBuilder setDough (String dough);
    PizzaBuilder setToppings (String... toppings);
    PizzaBuilder setExtraToppings (String... extraToppings);
    Pizza build();
}