package n2Exercise1.contact;

import n2Exercise1.address.Address;
import n2Exercise1.phone.Phone;

public class SpanishContact extends Contact {
    public SpanishContact(String name, String surname, Address address, Phone phone) {
        super(name, surname, address, phone);
    }
    
    @Override
    public String returnType() {
        return "Spanish Contact";
    }
}
