package n1Ejercicio5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import auxiliar.Utils;

public class Serializate {
    static Path path = Utils.selectPath("serFiles");
    
    public static void init(String option, String[] args) {
        switch (option) {
            case "-ser" -> initSer(args);
            case "-dser" -> initdSer(args);
        }
    }
    
    public static void initSer(String[] args) {
        try {
            File file=null;
            if (args.length < 1) {
                Path p = Utils.inputPath("");
                if (Files.exists(p)) file = Utils.inputFile(p, "");
            } else {
                file = new File(Utils.argsToString(args));
            }
            if (file!=null&&file.exists()) {
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
                file = Utils.inputFile(path, "");
            } else {
                file = new File(path+"/"+Utils.argsToString(args));
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
    public static void seralize(Object o, String s) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+"/"+s + ".ser"));
        oos.writeObject(o);
        oos.close();
        System.out.println("Serialized file created serFiles directory");
    }
    
    public static void desseralize(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object o = ois.readObject();
        System.out.println(o.toString());
    }
}
