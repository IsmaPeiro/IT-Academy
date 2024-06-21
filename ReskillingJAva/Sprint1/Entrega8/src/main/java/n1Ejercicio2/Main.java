package n1Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("hello", "bye", "Boot", "Rose", "Megalodon");
        List<String> wordsWithO=containsO(words);
        wordsWithO.forEach(System.out::println);
    }
    
    public static List<String> containsO (List<String> list) {
        List<String> result=new ArrayList<>();
        list.forEach(word->{if (word.contains("o")&&word.length()>5) result.add(word);});
        return result;
    }
}
