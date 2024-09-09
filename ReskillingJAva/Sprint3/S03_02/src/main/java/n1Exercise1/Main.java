package n1Exercise1;

public class Main {
    public static void main(String[] args) {
        PizzaMaster master = new PizzaMaster();
        
        HawaiianPizzaBuilder HawaiianBuilder = new HawaiianPizzaBuilder();
        master.makeHawaiianPizza(HawaiianBuilder);
        
        Pizza HawaiianPizza = HawaiianBuilder.getResult();
        System.out.println(HawaiianPizza);
        
        VegetarianPizzaBuilder vegetarianBuilder = new VegetarianPizzaBuilder();
        
        master.makeVegetarianPizza(vegetarianBuilder);
        Pizza vegetarianPizza = vegetarianBuilder.getResult();
        System.out.println(vegetarianPizza);
    }
}