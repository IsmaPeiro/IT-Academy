package n2Exercise1.factory;

import n2Exercise1.address.Address;
import n2Exercise1.contact.Contact;
import n2Exercise1.phone.Phone;

public abstract class ContactAbstractFactory {
    public abstract Contact createContact(String name, String surname, Address adress, Phone phone);
    public abstract Address createAddress(String street, String number, String flat, String door, String city, String postalCode);
    public abstract Phone createPhone(String number);
}
