package n1Ejercicio4;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadTxt {
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
            System.out.println("Input the txt File:");
            s = sc.nextLine();
        }
        file = new File(p + "\\" + s);
        return file;
    }
    
    public static void init(String[] args) {
        File file;
        if (args.length < 1) {
            Path p = inputPath("");
            file = inputFile(p, "");
        } else {
            file = new File(argsToString(args));
        }
        try {
            readTxt(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
    
    private static void readTxt(File file) throws IOException {
        
        if (file.exists()) {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            bf.lines().forEach(System.out::println);
        } else {
            System.out.println("File not found.");
        }
    }
    
}