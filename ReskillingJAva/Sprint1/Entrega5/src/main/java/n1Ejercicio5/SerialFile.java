package n1Ejercicio5;

import java.io.Serializable;

public class SerialFile implements Serializable {
    private String name;
    private String path;
    private String lastModifiedDate;
    
    public SerialFile(String name, String path, String lastModifiedDate) {
        this.name = name;
        this.path = path;
        this.lastModifiedDate = lastModifiedDate;
    }
    
    @Override
    public String toString() {
        return "SerialFile{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                '}';
    }
}
