package n2Exercise1.address;

public class SpanishAddress extends Address {
    public SpanishAddress(String street, String number, String flat, String door, String city, String postalCode) {
        super(street, number, flat, door, city, postalCode);
        this.country="Spain";
    }
    
    @Override
    public String returnType() {
        return "Spanish Address";
    }
}
