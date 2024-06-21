package n2Ejercicio1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerialJson {
    static void serialize (Object o, String name)  {
        
        Class<?> objectClass=o.getClass();
        
        ObjectMapper objectMapper=new ObjectMapper();
        
        try {
            if (objectClass.isAnnotationPresent(JsonPath.class)) {
                String path=objectClass.getAnnotation(JsonPath.class).path();
                
                if (!Files.exists(Paths.get(path))) {
                    Files.createDirectory(Paths.get(path));
                }
                objectMapper.writeValue(new File (path,name+".json"), o);
                
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
