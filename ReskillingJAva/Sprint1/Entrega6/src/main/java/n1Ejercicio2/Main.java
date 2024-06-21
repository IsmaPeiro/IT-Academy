package n1Ejercicio2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Person yuri=new Person("Yuri", "Gagaring", 45);
        
        String result= GenericMethods.genericMethod("Yuri", yuri, new File("cosmonaut.urss"));
        
        System.out.println(result);
    }
}
