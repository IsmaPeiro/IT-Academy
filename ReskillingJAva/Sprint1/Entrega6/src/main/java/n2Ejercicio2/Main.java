package n2Ejercicio2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person yuri=new Person("Yuri", "Gagaring", 45);
        
        Arrays.stream(GenericMethods.genericMethod(1,2,3,yuri)).toList().forEach(System.out::println);
    }
}
