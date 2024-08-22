package n2Exercise1.agenda;

import n2Exercise1.contact.Contact;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contact> contacts=new ArrayList<>();
    
    public void addContact (Contact contact) {
        contacts.add(contact);
    }
    
    public void showAllcontacts () {
        contacts.forEach(System.out::println);
    }
    
}
