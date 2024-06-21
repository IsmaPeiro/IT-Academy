package n1Ejercicio3;

public class OutBound {
    private int[] array=new int[]{1,2,3};
    
    public int getOutBounds () throws  IndexOutOfBoundsException {
        return array[array.length];
    }
}
