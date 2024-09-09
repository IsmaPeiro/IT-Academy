package n2Exercise1.factory;

import n2Exercise1.address.Address;
import n2Exercise1.address.SpanishAddress;
import n2Exercise1.contact.Contact;
import n2Exercise1.contact.SpanishContact;
import n2Exercise1.phone.Phone;
import n2Exercise1.phone.SpanishPhone;

public class SpanishContactFactory implements ContactAbstractFactory {
    @Override
    public Contact createContact(String name, String surname, Address adress, Phone phone) {
        return new SpanishContact(name, surname, adress, phone);
    }
    
    @Override
    public Address createAddress(String street, String number, String flat, String door, String city, String postalCode) {
        return new SpanishAddress(street, number, flat, door, city, postalCode);
    }
    
    @Override
    public Phone createPhone(String number) {
        return new SpanishPhone(number);
    }
}