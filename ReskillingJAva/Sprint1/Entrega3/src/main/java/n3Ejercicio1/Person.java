package n3Ejercicio1;

import java.util.Objects;

public class Person {
    private String name;
    private String lastName;
    private String dni;
    
    public Person(String name, String lastName, String dni) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getDni() {
        return dni;
    }
    
    @Override
    public String toString() {
        return String.format("%1$-10s",name)+String.format("%1$-20s",lastName)+dni;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getDni().toUpperCase(), person.getDni().toUpperCase());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getDni().toUpperCase());
    }
}
