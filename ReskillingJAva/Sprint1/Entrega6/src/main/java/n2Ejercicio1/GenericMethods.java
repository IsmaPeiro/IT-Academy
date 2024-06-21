package n2Ejercicio1;

public class GenericMethods {
    
    static <T, V> String genericMethod(String s, T t, V v) {
        return s+"\n"+t+"\n"+v;
    }
}
