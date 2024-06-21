package n1Ejercicio3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> months = Arrays.asList(
                "January", "February", "March", "April", "June", "July", "August", "October", "November", "December");
        
        
        months.stream().forEach(m-> System.out.println(m));
    }
}
