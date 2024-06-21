package n1Ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class ShowDirTree {
    static int count = 0;
    
    private static Path inputPath(String s) throws InvalidPathException {
        Path p = null;
        Scanner sc = new Scanner(System.in);
        if (s.isEmpty()) {
            System.out.println("Input the path:");
            s = sc.nextLine();
        }
        p = Paths.get(s);
        return p;
    }
    
    public static void init(String[] args) {
        if (args.length < 1) {
            dirTree("");
        } else {
            dirTree(argsToString(args));
        }
    }
    
    private static String argsToString(String[] args) {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (i < args.length - 1) {
                result += args[i] + " ";
            } else {
                result += args[i];
            }
        }
        return result;
    }
    
    public static void dirTree(String s) {
        try {
            Path path = inputPath(s);
            if (Files.exists(path)) {
                generateTreeDir(path);
            } else {
                System.out.println("the directory does not exist");
            }
        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void generateTreeDir(Path path) {
        try (Stream<Path> pathList = Files.list(path).sorted(Comparator.comparing(Files::isDirectory))) {
            pathList.forEach(file -> {
                String name = file.getParent().getFileName() + "\\" + file.getFileName();
                String date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(file.toFile().lastModified());
                if (!Files.isDirectory(file)) {
                    System.out.print("\t".repeat(count) + "[F]" + name + " " + date + "\n");
                } else {
                    System.out.print("\t".repeat(count) + "[D]" + name + " " + date + "\n");
                    count++;
                    dirTree(file.toString());
                    count--;
                }
            });
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}