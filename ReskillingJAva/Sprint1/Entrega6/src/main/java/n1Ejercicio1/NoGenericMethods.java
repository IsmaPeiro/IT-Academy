package n1Ejercicio1;

public class NoGenericMethods {
    private String first;
    private String second;
    private String third;
    
    public NoGenericMethods(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public String getFirst() {
        return first;
    }
    
    public String getSecond() {
        return second;
    }
    
    public String getThird() {
        return third;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }
    
    public void setSecond(String second) {
        this.second = second;
    }
    
    public void setThird(String third) {
        this.third = third;
    }
    
    public void set(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    @Override
    public String toString() {
        return "["+first+", "+second+", "+third+"]";
    }
}
