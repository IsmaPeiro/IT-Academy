package n2Exercise1.phone;

public abstract class Phone {
    protected String prefix;
    protected String number;
    
    public Phone(String number) {
        this.number = number;
    }
    
    public abstract String returnType ();
    
    public String getPrefix() {
        return prefix;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    @Override
    public String toString() {
        return returnType() + ": " +"\n"+
                prefix + " " + number;
    }
}
