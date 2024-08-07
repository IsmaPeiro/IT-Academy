package n2Exercise1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Properties;
import java.util.stream.Stream;
import auxiliar.Utils;

public class SaveDirTree {
    static int count = 0;
    static boolean exists = true;
    static final Properties properties = new Properties();
    static File confFile;
    static File file;
    static FileWriter fw;
    static BufferedWriter bf;
    
    static {
        try {
            confFile = new File(Utils.selectPath("properties") + "/conf.properties");
            properties.load(new FileInputStream(confFile));
            Path p=Utils.selectPath(properties.get("OUTPUTPATH").toString());
            String fileName= properties.get("TXTFILE").toString();
            file = new File(p.toString(),fileName);
            fw = new FileWriter(file);
            bf = new BufferedWriter(fw);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void init() {
        
        try {
            dirTree(properties.get("DIRPATH").toString());
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
            Path path = Paths.get(s);
            if (Files.exists(path)) {
                generateTreeDir(path);
            } else {
                System.out.println("the directory does not exist");
                exists = false;
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void writeNext(Path file) throws IOException {
        String name = file.getParent().getFileName() + "\\" + file.getFileName();
        String date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(file.toFile().lastModified());
        if (!Files.isDirectory(file)) {
            //System.out.println(file);
            bf.write("\t".repeat(count) + "[F]" + name + " " + date + "\n");
        } else {
            //System.out.println(file);
            bf.write("\t".repeat(count) + "[D]" + name + " " + date + "\n");
            count++;
            dirTree(file.toString());
            count--;
        }
    }
}