package n2Exercise1.observers;

public abstract class StockAgency {
    protected String name;
    
    public StockAgency() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}