package n2Exercise1.observable;

public class StockMarket {
    private String name;
    private int index = 100;
    
    public StockMarket(String name) {
        this.name = name;
    }
    
    public void movement (int value) {
        setIndex(index+value);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
}
