package n2Ejercicio2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 23, 67, 2, 98, 35);
        System.out.println(listNums(nums));
    }
    
    public static String listNums (List<Integer> list) {
        return list.stream().map(n->{
            return (n%2==0) ? "e"+n : "o"+n;
        }).collect(Collectors.joining(","));
    }
}


