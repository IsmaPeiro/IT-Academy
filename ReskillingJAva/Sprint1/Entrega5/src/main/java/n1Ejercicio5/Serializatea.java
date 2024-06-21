package n1Ejercicio5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Serializatea {
    static Path path = selectPath();
    
    private static Path selectPath() {
        if (System.getProperty("java.class.path").equals(".")) {
            Path p=Paths.get("../serFiles/");
            if (Files.notExists (p)) {
                File directory=new File(p.toString());
                directory.mkdir();
            }
            return p;
        } else {
            Path p=Paths.get(System.getProperty("java.class.path")).getParent().getParent().resolve(Paths.get("src/main/java/serFiles"));
            
            if (Files.notExists (p)) {
                File directory=new File(p.toString());
                directory.mkdir();
            }
            return p;
        }
    }
    
    public static void init(String option, String[] args) {
        switch (option) {
            case "-ser" -> initSer(args);
            case "-dser" -> initdSer(args);
        }
    }
    
    public static void initSer(String[] args) {
        try {
            File file;
            if (args.length < 1) {
                Path p = inputPath("");
                file = inputFile(p, "");
            } else {
                file = new File(argsToString(args));
            }
            if (file.exists()) {
                seralize(new SerialFile(
                        file.getName(),
                        file.getAbsolutePath(),
                        new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(file.lastModified())
                ), file.getName());
            } else {
                System.out.println("File not found.");
            }
        } catch (InvalidPathException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void initdSer(String[] args) {
        try {
            File file;
            if (args.length < 1) {
                file = inputFile(path, "");
            } else {
                file = new File(path+"/"+argsToString(args));
            }
            if (file.exists()) {
                desseralize(file);
            } else {
                System.out.println("File not found.");
            }
        } catch (InvalidPathException | IOException | ClassNotFoundException e) {
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
    
    private static Path inputPath(String s) throws InvalidPathException {
        Path path;
        Scanner sc = new Scanner(System.in);
        if (s.isEmpty()) {
            System.out.println("Input the path:");
            s = sc.nextLine();
        }
        path = Paths.get(s);
        return path;
    }
    
    private static File inputFile(Path p, String s) throws InvalidPathException {
        File file;
        Scanner sc = new Scanner(System.in);
        if (s.isEmpty()) {
            System.out.println("Input the File:");
            s = sc.nextLine();
        }
        file = new File(p + "\\" + s);
        return file;
    }
    
    public static void seralize(Object o, String s) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+"/"+s + ".ser"));
        oos.writeObject(o);
        oos.close();
    }
    
    public static void desseralize(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object o = ois.readObject();
        System.out.println(o.toString());
    }
}
