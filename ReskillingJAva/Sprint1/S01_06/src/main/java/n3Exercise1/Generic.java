package n3Exercise1;

public class Generic {
    static <T extends Phone> void genericMethodPhone(T t) {
        t.call();
    }
    
    static <T extends Smartphone> void genericMethodSmartPhone(T t) {
        t.shootPhoto();
        t.call();
    }
}
