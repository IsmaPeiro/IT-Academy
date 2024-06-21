package n1Ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Dir {
    
    private static Path inputPath(String s) {
        Path p=null;
        Scanner sc = new Scanner(System.in);
        if (s.isEmpty()) {
            System.out.println("Input the path:");
            s=sc.nextLine();
        }
        try {
            p = Paths.get(s);
        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
        }
        return p;
    }
   
    static void init (String[] args) {
        if (args.length < 1) {
            dir("");
        } else {
            dir(argsToString(args));
        }
    }
    
    private static String argsToString (String[] args) {
        String result="";
        for (int i = 0; i < args.length; i++) {
            if (i<args.length-1) {
                result += args[i] + " ";
            } else {
                result += args[i];
            }
        }
        return result;
    }
    
    public static void dir(String s) {
        Path path=inputPath(s);
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
