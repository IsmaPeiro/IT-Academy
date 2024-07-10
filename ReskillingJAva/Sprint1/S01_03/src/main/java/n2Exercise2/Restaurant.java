package n2Exercise2;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {
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
    
    
    @Override
    public int compareTo(Restaurant o) {
        int compareByName = this.name.compareToIgnoreCase(o.name);
        if (compareByName == 0) {
            return Integer.compare(o.punctuation, this.punctuation);
        }
        return compareByName;
    }
}
