package n2Exercise1.phone;

public class UKPhone extends Phone {
    public UKPhone(String number) {
        super(number);
        this.prefix="+44";
    }
    
    @Override
    public String returnType() {
        return "UK Phone";
    }
}
