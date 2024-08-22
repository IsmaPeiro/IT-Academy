package n2Exercise1.contact;

import n2Exercise1.address.Address;
import n2Exercise1.phone.Phone;

public class Contact {
    protected String contactType;
    protected String name;
    protected String surname;
    protected Address address;
    protected Phone phone;
    
    public Contact(String name, String surname, Address address, Phone phone) {
        this.name=name;
        this.surname=surname;
        this.address = address;
        this.phone = phone;
    }
    
    public String getContactType() {
        return contactType;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public Phone getPhone() {
        return phone;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    @Override
    public String toString() {
        return contactType +"\n"+ address +"\n"+ phone;
    }
}
