package n1Exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "bye", "Boot", "Rose");
        List<String> wordsWithO = containsO(words);
        wordsWithO.forEach(System.out::println);
    }
    
    public static List<String> containsO(List<String> list) {
        return list.stream().filter(e -> e.contains("o")).toList();
    }
}
