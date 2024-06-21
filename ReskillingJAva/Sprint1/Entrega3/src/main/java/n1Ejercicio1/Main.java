package n1Ejercicio1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<>();
        Month january = new Month("January");
        Month february = new Month("February");
        Month march = new Month("March");
        Month april = new Month("April");
        Month may = new Month("May");
        Month june = new Month("June");
        Month july = new Month("July");
        Month september = new Month("September");
        Month october = new Month("October");
        Month november = new Month("November");
        Month december = new Month("December");

        months.add(january);
        months.add(february);
        months.add(march);
        months.add(april);
        months.add(may);
        months.add(june);
        months.add(july);
        months.add(september);
        months.add(october);
        months.add(november);
        months.add(december);
        
        System.out.println("The ArrayList of months is created");
        months.forEach(System.out::println);
        
        System.out.println("\nAugust is added in its position");
        months.add(7, new Month("August"));
        months.forEach(System.out::println);
        
        System.out.println("\nA LinkedHashSet is created with the data from the ArrayList");
        LinkedHashSet<Month> monthLinkedHashSet = new LinkedHashSet<>(months);
        
        System.out.println("\nAn attempt is made to add January to the LinkedHashSet with a negative result");
        System.out.println(monthLinkedHashSet.add(january));
        monthLinkedHashSet.forEach(System.out::println);
        
        System.out.println("\nA ListIterator is created to loop through the LinkedHashSet");
        ListIterator<Month> lm = monthLinkedHashSet.stream().toList().listIterator();
        System.out.println("\nAnd it is used to print the months");
        while (lm.hasNext()) {
            System.out.println(lm.next().getName());
        }
    }
}