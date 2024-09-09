package n2Exercise1.address;

public class UKAdress extends Address {
    public UKAdress(String street, String number, String flat, String door, String city, String postalCode) {
        super(street, number, flat, door, city, postalCode);
        this.country="UK";
    }
    
    @Override
    public String returnType() {
        return "UK Address";
    }
}
