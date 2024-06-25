package n2Exercise1;

public class Main {
    public static void main(String[] args) {
        try {
            SaveDirTree.init();
        } catch (ExceptionInInitializerError e) {
            System.out.println("Configuration file not found.");
        }
    }
}