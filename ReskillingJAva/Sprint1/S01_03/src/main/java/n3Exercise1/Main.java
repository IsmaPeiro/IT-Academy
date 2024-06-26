package n3Exercise1;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        
        try {
            Menu menu=new Menu();
            menu.init();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
