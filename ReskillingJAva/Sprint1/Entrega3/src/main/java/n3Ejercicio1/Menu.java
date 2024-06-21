package n3Ejercicio1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Menu  {
    private IOManagement personsFile;
    private LinkedHashSet<Person> personHash;
    
    public Menu() throws IOException {
        this.personsFile = new IOManagement();
        this.personHash = fillHash(personsFile);
    }
    
    public void init() throws IOException {
        
        boolean exit = false;
        
        do {
            switch (menu()) {
                case 1 -> createPerson(personHash);
                case 2 -> showPersonsByNameAZ(personHash);
                case 3 -> showPersonsByNameZA(personHash);
                case 4 -> showPersonsByLastNameAZ(personHash);
                case 5 -> showPersonsByLastNameZA(personHash);
                case 6 -> showPersonsByDNI19(personHash);
                case 7 -> showPersonsByDNI91(personHash);
                case 0 -> {
                    System.out.println("Thank you for use the application.");
                    exit = true;
                }
            }
        } while (!exit);
    }
    
    public byte menu() {
        Scanner sc = new Scanner(System.in);
        byte option = -1;
        final byte MINIMUM = 0;
        final byte MAXIMUM = 7;
        
        do {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Input new person.");
            System.out.println("2. Show persons sorted by name [A-Z].");
            System.out.println("3. Show persons sorted by name [Z-A].");
            System.out.println("4. Show persons sorted by last name [A-Z].");
            System.out.println("5. Show persons sorted by last name [Z-A].");
            System.out.println("6. Show persons sorted by dni [1-9].");
            System.out.println("7. Show persons sorted by dni [9-1].");
            System.out.println("0. Exit.\n");
            if (sc.hasNextByte()) option = sc.nextByte();
            sc.nextLine();
            if (option < MINIMUM || option > MAXIMUM) System.out.println("Chose Valid Option.");
        } while (option < MINIMUM || option > MAXIMUM);
        return option;
    }
    
    private LinkedHashSet<Person> fillHash(IOManagement file) throws FileNotFoundException {
        LinkedHashSet<Person> hash = new LinkedHashSet<>();
        file.readPersons().forEach(person -> hash.add(new Person(person.split(",")[0], person.split(",")[1], person.split(",")[2])));
        return hash;
    }
    
    public void createPerson(LinkedHashSet<Person> hash) throws IOException {
        Scanner sc = new Scanner(System.in);
        String dni = "", name = "", lastName;
        boolean stay = false;
        
        do {
            do {
                System.out.println("Input DNI:");
                dni = sc.nextLine();
            } while (!checkDni(dni));
            System.out.println("Input Person's Name:");
            name = sc.nextLine();
            System.out.println("Input Person's Last Name:");
            lastName = sc.nextLine();
            if (hash.add(new Person(name, lastName, dni))) {
                personsFile.writePerson(name, lastName, dni);
                System.out.println("Person input Properly");
                stay = false;
            } else {
                System.out.println("Person with that dni already exist in the file.");
                stay = tryAgain();
            }
        } while (stay);
    }
    
    
    public void showPersonsByNameAZ(LinkedHashSet<Person> hash) {
        System.out.println(String.format("%1$-10s", "Name") + String.format("%1$-20s", "Last Name") + "dni");
        hash.stream().sorted(Comparator.comparing(person -> person.getName().toUpperCase())).forEach(System.out::println);
    }
    
    public void showPersonsByNameZA(LinkedHashSet<Person> hash) {
        System.out.println(String.format("%1$-10s", "Name") + String.format("%1$-20s", "Last Name") + "dni");
        hash.stream().sorted((person1, person2) -> person2.getName().compareTo(person1.getName())).forEach(System.out::println);
    }
    
    public void showPersonsByLastNameAZ(LinkedHashSet<Person> hash) {
        System.out.println(String.format("%1$-10s", "Name") + String.format("%1$-20s", "Last Name") + "dni");
        hash.stream().sorted(Comparator.comparing(person -> person.getLastName().toUpperCase())).forEach(System.out::println);
    }
    
    public void showPersonsByLastNameZA(LinkedHashSet<Person> hash) {
        System.out.println(String.format("%1$-10s", "Name") + String.format("%1$-20s", "Last Name") + "dni");
        hash.stream().sorted((person1, person2) -> person2.getLastName().compareTo(person1.getLastName())).forEach(System.out::println);
    }
    
    public void showPersonsByDNI19(LinkedHashSet<Person> hash) {
        System.out.println(String.format("%1$-10s", "Name") + String.format("%1$-20s", "Last Name") + "dni");
        hash.stream().sorted(Comparator.comparing(Person::getDni)).forEach(System.out::println);
    }
    
    public void showPersonsByDNI91(LinkedHashSet<Person> hash) {
        System.out.println(String.format("%1$-10s", "Name") + String.format("%1$-20s", "Last Name") + "dni");
        hash.stream().sorted((person1, person2) -> person2.getDni().compareTo(person1.getDni())).forEach(System.out::println);
    }
    
    public boolean tryAgain() {
        boolean response = true;
        String option = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("¿Volver a intentarlo? [Y/N]");
            option = sc.next();
            
            if (option.matches("([Yy])")) {
                response = true;
            } else if (option.matches("([Nn])")) {
                response = false;
            } else {
                System.out.println("Chose Valid Option.");
            }
        } while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N"));
        return response;
    }
    
    public boolean checkDni(String dni) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        String dniNum = "", dniLetter = "";
        if (dni.matches("([0-9]{8})([A-Za-z])")) {
            dniNum = dni.substring(0, 8);
            dniLetter = dni.substring(8);
            if (dniLetter.toUpperCase().charAt(0) == letters.charAt(Integer.parseInt(dniNum) % 23)) {
                return true;
            } else {
                System.out.println("Incorrect Number Or Letter.");
                return false;
            }
        } else {
            System.out.println("Incorrect Format.");
            return false;
        }
    }
}

