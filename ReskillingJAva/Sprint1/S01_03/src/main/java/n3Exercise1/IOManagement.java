package n3Exercise1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IOManagement {
    private final Path path=Paths.get(System.getProperty("java.class.path")).getParent().getParent().resolve(Paths.get("src/main/java/n3Exercise1/resources"));
    private final File personsFile = checkPersonsExists();
    
    public IOManagement() throws IOException {
    }
    
    private File checkPersonsExists() throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
        File personsFile = new File(path.toString(),"persons.csv");
        if (!personsFile.exists()) {
            personsFile.createNewFile();
        }
        return personsFile;
    }
    
    public void writePerson(String name, String lastName, String dni) throws IOException {
        FileWriter personsFW = new FileWriter(personsFile, true);
        BufferedWriter personsBW = new BufferedWriter(personsFW);
        personsBW.write(name+","+lastName+","+dni);
        personsBW.newLine();
        personsBW.flush();
        personsBW.close();
    }
    
    public Stream<String> readPersons() throws FileNotFoundException {
        return new BufferedReader(new FileReader(personsFile)).lines();
    }
}
