package n2Ejercicio1;

import java.util.Objects;

public class Restaurant {
    private String name;
    private int punctuation;
    
    public Restaurant(String name, int punctuation) {
        this.name = name;
        this.punctuation = punctuation;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPunctuation() {
        return punctuation;
    }
    
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", punctuation=" + punctuation +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return getPunctuation() == that.getPunctuation() && Objects.equals(getName(), that.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPunctuation());
    }
}
