package n1Exercise1;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("product1", 15);
        Product p2 = new Product("product2", 5.5);
        Product p3 = new Product("product3", 20);
        Product p4 = new Product("product4", 10.3);
        Sale s1 = new Sale();
        s1.addProduct(p1);
        s1.addProduct(p2);
        s1.addProduct(p3);
        s1.addProduct(p4);

        System.out.println("calculateTotal result with a list with products:");
        try {
            System.out.println(s1.calculateTotal());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        Sale s2 = new Sale();
        System.out.println("calculateTotal result with a list without products:");
        try {
            System.out.println(s2.calculateTotal());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        int[] array = new int[5];
        try {
            array[6] = 6;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }
}
