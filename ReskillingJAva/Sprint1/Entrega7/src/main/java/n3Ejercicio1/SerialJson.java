package n3Ejercicio1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerialJson {
    static void serialize (Object o, String name)  {
        
        Class<?> objectClass=o.getClass();
        
        Annotation[] annotations= objectClass.getAnnotations();
        
        for (Annotation a:annotations) {
            if(a instanceof JsonPath){
                JsonPath myAnnotation = (JsonPath) a;
                System.out.println("path of annotation: " + myAnnotation.path());
            }
        }
        
        ObjectMapper objectMapper=new ObjectMapper();
        
        try {
            if (objectClass.isAnnotationPresent(JsonPath.class)) {
                String path=objectClass.getAnnotation(JsonPath.class).path();
                
                if (!Files.exists(Paths.get(path))) {
                    Files.createDirectories(Paths.get(path));
                }
                objectMapper.writeValue(new File (path,name+".json"), o);
                
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
