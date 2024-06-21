package n3Ejercicio1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu=new Menu();
        try {
            menu.init();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
