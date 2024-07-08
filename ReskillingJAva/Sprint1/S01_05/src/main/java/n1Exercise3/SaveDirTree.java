package n1Exercise3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.stream.Stream;
import auxiliar.Utils;

public class SaveDirTree {
    
    static int count = 0;
    static boolean exists=true;
    static File file;
    static BufferedWriter bf;
    static FileWriter fw;
    
    static {
        try {
            file = new File(Utils.selectPath("output").toString() , "dirTree.txt");
            fw = new FileWriter(file);
            bf = new BufferedWriter(fw);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void init(String[] args) {
        if (args.length < 1) {
            dirTree("");
        } else {
            dirTree(Utils.argsToString(args));
        }
        try {
            if (exists) {
                bf.flush();
                bf.close();
                System.out.println("Log saved.");
            } else {
                System.out.println("Log not saved.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void dirTree(String s) {
        try {
            Path path = Utils.inputPath(s);
            if (Files.exists(path)) {
                generateTreeDir(path);
            } else {
                System.out.println("the directory does not exist");
                exists=false;
            }
        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void generateTreeDir(Path path) {
        try (Stream<Path> pathList = Files.list(path).sorted(Comparator.comparing(Files::isDirectory))) {
            pathList.forEach(file -> {
                try {
                    writeNext(file);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void writeNext(Path file) throws IOException {
        String name = file.getParent().getFileName() + "\\" + file.getFileName();
        String date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(file.toFile().lastModified());
        if (!Files.isDirectory(file)) {
            bf.write("\t".repeat(count) + "[F]" + name + " " + date + "\n");
        } else {
            bf.write("\t".repeat(count) + "[D]" + name + " " + date + "\n");
            count++;
            dirTree(file.toString());
            count--;
        }
    }
}