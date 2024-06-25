package n3Exercise1;

public abstract class NewsReport {
    protected String titular;
    protected String text;
    protected int punctuation;
    protected int price;
    
    public NewsReport(String titular) {
        this.titular = titular;
        this.text = "";
    }
    
    public String getTitular() {
        return titular;
    }
    
    public String getText() {
        return text;
    }
    
    public int getPunctuation() {
        return punctuation;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "tiular=" + titular + ", text=\"\"" + text
                + ", punctuation=" + calculatePointsNew() + ", price=" + calculatePriceNew();
    }
    
    public abstract int calculatePriceNew();
    
    public abstract int calculatePointsNew();
    
    public abstract String getSport();
}
