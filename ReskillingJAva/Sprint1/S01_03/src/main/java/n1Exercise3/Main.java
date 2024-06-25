package n1Exercise3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       try {
            Game game = new Game();
            game.play();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}