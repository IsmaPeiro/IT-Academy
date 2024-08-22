package n2Exercise1.factory;

import n2Exercise1.address.Address;
import n2Exercise1.address.UKAdress;
import n2Exercise1.contact.Contact;
import n2Exercise1.contact.UKContact;
import n2Exercise1.phone.Phone;
import n2Exercise1.phone.UKPhone;

public class UKContactFactory extends ContactAbstractFactory {
    @Override
    public Contact createContact(String name, String surname, Address adress, Phone phone) {
        return new UKContact(name, surname, adress, phone);
    }
    
    @Override
    public Address createAddress(String street, String number, String flat, String door, String city, String postalCode) {
        return new UKAdress(street, number, flat, door, city, postalCode);
    }
    
    @Override
    public Phone createPhone(String number) {
        return new UKPhone(number);
    }
}