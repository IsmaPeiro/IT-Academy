package n1Exercise1;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<Product> sales;
    private double totalPrice;

    public Sale() {
        this.sales = new ArrayList<>();
    }

    public List<Product> getSales() {
        return sales;
    }

    public void addProduct (Product p) {
        sales.add(p);
    }

    public double calculateTotal() throws EmptySaleException {
        if (!sales.isEmpty()) {
            totalPrice = (sales.stream().mapToDouble((o -> o.getPrice())).sum());
            return totalPrice;
        } else {
            throw new EmptySaleException();
        }


    }
}
