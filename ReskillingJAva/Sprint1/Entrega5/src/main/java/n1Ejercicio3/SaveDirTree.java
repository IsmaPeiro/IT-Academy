package n1Ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class SaveDirTree {
    
    static int count = 0;
    static boolean exists=true;
    static final File FILE;
    static final BufferedWriter BF;
    static final FileWriter FW;
    
    static {
        try {
            FILE = new File(selectPath().toString() , "dirTree.txt");
            FW = new FileWriter(FILE);
            BF = new BufferedWriter(FW);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    private static Path selectPath() {
        if (System.getProperty("java.class.path").equals(".")) {
            Path p=Paths.get("../output/");
            if (Files.notExists (p)) {
                File directory=new File(p.toString());
                directory.mkdir();
            }
            return p;
        } else {
            Path p=Paths.get(System.getProperty("java.class.path")).getParent().getParent().resolve(Paths.get("src/main/java/output"));
           
            if (Files.notExists (p)) {
                File directory=new File(p.toString());
                directory.mkdir();
            }
            return p;
        }
    }
    
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
        try {
            if (exists) {
                BF.flush();
                BF.close();
                System.out.println("Log saved.");
            } else {
                System.out.println("Log not saved.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
            BF.write("\t".repeat(count) + "[F]" + name + " " + date + "\n");
        } else {
            BF.write("\t".repeat(count) + "[D]" + name + " " + date + "\n");
            count++;
            dirTree(file.toString());
            count--;
        }
    }
}