package n1Exercise1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import auxiliar.Utils;

public class Dir {
    
    static void init (String[] args) {
        if (args.length < 1) {
            dir("");
        } else {
            dir(Utils.argsToString(args));
        }
    }
    
    public static void dir(String s) {
        Path path=Utils.inputPath(s);
        if (Files.exists(path)) {
            try (Stream<Path> pathStream=Files.list(path).sorted()){
                pathStream.forEach(p1 -> System.out.println(p1.getFileName()));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Path not found.");
        }
    }
}
