package n1Ejercicio4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> months= Arrays.asList(
                "January", "February", "March", "April", "June", "July", "August", "October", "November", "December");
        
        months.forEach(System.out::println);
    }
}
