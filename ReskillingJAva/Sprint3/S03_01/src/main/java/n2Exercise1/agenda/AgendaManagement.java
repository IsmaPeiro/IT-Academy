package n2Exercise1.agenda;

import n2Exercise1.address.Address;
import n2Exercise1.factory.ContactAbstractFactory;
import n2Exercise1.factory.SpanishContactFactory;
import n2Exercise1.factory.UKContactFactory;
import n2Exercise1.phone.Phone;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AgendaManagement {
    
    public void init() {
        
        Agenda agenda = new Agenda();
        
        boolean exit = false;
        
        do {
            switch (menu()) {
                case 1 -> addContact(agenda);
                case 2 -> listContacts(agenda);
                case 0 -> {
                    System.out.println("thanks.");
                    exit = true;
                }
            }
        } while (!exit);
    }
    
    public byte menu() {
        Scanner sc = new Scanner(System.in);
        byte option = -1;
        final byte MINIMUM = 0;
        final byte MAXIMUM = 3;
        
        do {
            System.out.println("\nMENú PRINCIPAL");
            System.out.println("1. Add Contact.");
            System.out.println("2. List Contacts.");
            System.out.println("0. Exit.\n");
            if (sc.hasNextByte()) option = sc.nextByte();
            sc.nextLine();
            if (option < MINIMUM || option > MAXIMUM) {
                System.out.println("Chose a valid option.");
            }
        } while (option < MINIMUM || option > MAXIMUM);
        return option;
    }
    
    public void addContact(Agenda agenda) {
        String name, surname, street, number, floor, door, city, postalCode, phoneNumber;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What country is the contact from?");
        ContactAbstractFactory factory = choseCountry();
        System.out.println("Name:");
        name = sc.nextLine();
        System.out.println("Surname:");
        surname = sc.nextLine();
        System.out.println("City:");
        city = sc.nextLine();
        System.out.println("Postal Code:");
        postalCode = sc.nextLine();
        System.out.println("Street:");
        street = sc.nextLine();
        System.out.println("Number:");
        number = sc.nextLine();
        System.out.println("Floor:");
        floor = sc.nextLine();
        System.out.println("Door:");
        door = sc.nextLine();
        System.out.println("Phone:");
        phoneNumber = sc.nextLine();
        
        Address address = factory.createAddress(street, number, floor, door, city, postalCode);
        Phone phone = factory.createPhone(phoneNumber);
        
        agenda.addContact(factory.createContact(name, surname, address, phone));
        System.out.println("Contact added");
    }
    
    public void listContacts(Agenda agenda) {
        agenda.showAllcontacts();
    }
    
    public ContactAbstractFactory choseCountry() {
        Scanner sc = new Scanner(System.in);
        byte option = -1;
        final int MINIMUM = 1;
        final int MAXIMUM = Country.values().length;
        
        do {
            
            AtomicInteger index = new AtomicInteger(1);
            Arrays.stream(Country.values()).forEach(c -> System.out.println(index.getAndIncrement() + ". " + c));
            
            if (sc.hasNextByte()) option = sc.nextByte();
            sc.nextLine();
            if (option < MINIMUM || option > MAXIMUM) {
                System.out.println("Chose a valid option.");
            }
        } while (option < MINIMUM || option > MAXIMUM);
        
        Country country = Country.values()[option - 1];
        
        switch (country) {
            case SPAIN -> {
                return new SpanishContactFactory();
            }
            case UK -> {
                return new UKContactFactory();
            }
        }
        return null;
    }
}
