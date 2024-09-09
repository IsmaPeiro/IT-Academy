package n2Exercise1.phone;

public class SpanishPhone extends Phone {
    public SpanishPhone(String number) {
        super(number);
        this.prefix = "+034";
    }
    
    @Override
    public String returnType() {
        return "Spanish Phone";
    }
}