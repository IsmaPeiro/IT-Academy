package algoritmia;

import java.util.Arrays;

public class InvertirArray {
    public static void main(String[] args) {


        int[] array=new int[] {1,2,3,4,5,6,7,8,9};

        invertArray(array);

        System.out.println(Arrays.toString(array));

    }

    private static void invertArray(int[] array) {
        for (int i = 0; i< array.length/2; i++) {
            int temp= array[i];
            array[i]= array[array.length-i-1];
            array[array.length-i-1]=temp;
        }
    }
}
