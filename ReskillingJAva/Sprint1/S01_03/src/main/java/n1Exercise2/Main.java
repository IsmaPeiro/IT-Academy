package n1Exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("\nA List of Integers is created and filled with numbers from 0 to 9");
        List<Integer> list1 = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        
        list1.forEach(System.out::println);
        
        System.out.println("\nA second List of Integers is created and through a ListIterator the values " +
                           "of the previous List are passed to it in reverse order");
        
        List<Integer> list2 = new ArrayList<>();
        
        ListIterator<Integer> lista1Iterator = list1.listIterator(list1.size());
        
        lista1Iterator.previousIndex();
        
        while (lista1Iterator.hasPrevious()) {
            list2.add(lista1Iterator.previous());
           
        }
        list2.forEach(System.out::println);
    }
}
