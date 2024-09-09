package n2Exercise1.factory;

import n2Exercise1.address.Address;
import n2Exercise1.contact.Contact;
import n2Exercise1.phone.Phone;

public interface ContactAbstractFactory {
    Contact createContact(String name, String surname, Address adress, Phone phone);
    Address createAddress(String street, String number, String flat, String door, String city, String postalCode);
    Phone createPhone(String number);
}
