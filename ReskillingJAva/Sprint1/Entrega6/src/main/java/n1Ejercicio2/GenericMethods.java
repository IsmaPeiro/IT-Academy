package n1Ejercicio2;

public class GenericMethods {
    
    static <T, V, K> String genericMethod(T t, V v, K k) {
        return t+"\n"+t+"\n"+v;
    }
}
