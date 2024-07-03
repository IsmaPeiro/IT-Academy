package n1Exercise2;

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
        
        return list.stream().filter(word->word.contains("o")&&word.length()>5).toList();
        
    }
}
