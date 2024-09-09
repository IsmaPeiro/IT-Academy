package n2Exercise1.contact;

import n2Exercise1.address.Address;
import n2Exercise1.phone.Phone;

public class UKContact extends Contact {
    public UKContact(String name, String surname, Address address, Phone phone) {
        super(name, surname, address, phone);
    }
    
    @Override
    public String returnType() {
        return "UK Contact";
    }
}
