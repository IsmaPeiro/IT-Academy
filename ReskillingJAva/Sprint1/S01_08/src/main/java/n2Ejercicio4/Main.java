package n2Ejercicio4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       List<String> list= Arrays.asList("Word", "2", "paint", "45", "Ink", "740", "Aquarell", "34", "enterprise");
        
        System.out.println("Sorted by first Character");
        list.sort(Comparator.comparingInt(s ->s.toUpperCase().charAt(0)));
        System.out.println(list);
        
        System.out.println("Sorted first contains e");
        list.sort(Comparator.comparing((String s)->
                !s.toUpperCase().contains("E")).thenComparing((String s)->s.toUpperCase()));
        System.out.println(list);
        
        System.out.println("Change a for 4");
        list.replaceAll(s->s.replace("a", "4"));
        System.out.println(list);
        
        System.out.println("Print only numbers");
        System.out.println(list.stream().filter(s->s.matches("\\d+")).collect(Collectors.joining(",")));
        
    }
}
