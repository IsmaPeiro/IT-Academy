package n2Ejercicio1;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Ana", "Ismael", "All", "apu", "Antonio", "Daniel", "alba", "Ramiro");
        
        List<String> namesWithA=returnNamesA(names);
        
        namesWithA.forEach(System.out::println);
    }
    
    public static List<String> returnNamesA (List<String> names) {
        return names.stream().filter(name->name.length()==3&&name.charAt(0)=='A').toList();
            }
}
