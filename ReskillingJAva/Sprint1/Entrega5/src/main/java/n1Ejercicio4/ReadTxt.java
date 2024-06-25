package n1Ejercicio4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import auxiliar.Utils;

public class ReadTxt {
    
    public static void init(String[] args) {
        File file=null;
        if (args.length < 1) {
            Path p = Utils.inputPath("");
            if (Files.exists(p)) file = Utils.inputFile(p, "");
            else System.out.println("Path not found");
        } else {
            file = new File(Utils.argsToString(args));
        }
        try {
            if (file!=null) readTxt(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void readTxt(File file) throws IOException {
        
        if (file.exists()&&file.getName().endsWith(".txt")) {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            bf.lines().forEach(System.out::println);
        } else if (!file.exists()){
            System.out.println("File not found.");
        } else if (file.exists()&&!file.getName().endsWith(".txt")) {
            System.out.println("Must be a .txt file.");
        }
    }
}