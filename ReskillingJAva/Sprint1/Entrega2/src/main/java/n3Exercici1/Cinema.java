package n3Exercici1;

import java.util.Scanner;

public class Cinema {
    private int rows;
    private int seatsPerRow;
    private final SeatManagement management;
    
    public Cinema() {
        management = new SeatManagement();
        initialData();
    }
    
    public void init() {
        boolean exit = false;
        
        do {
            switch (menu()) {
                case 1 -> showSeats();
                case 2 -> showSeatsPerPerson();
                case 3 -> reserveSeat();
                case 4 -> cancelReserve();
                case 5 -> cancelReservePerson();
                case 0 -> {
                    System.out.println("gracias por usar la aplicación.");
                    exit = true;
                }
            }
        } while (!exit);
    }
    
    public static byte menu() {
        Scanner sc = new Scanner(System.in);
        byte option = -1;
        final byte MINIMUM = 0;
        final byte MAXIMUM = 5;
        
        do {
            System.out.println("\nMAIN MENU\n"+
                                "1. Show All Seats Booked.\n"+
                                "2. Shows Client Bookings.\n"+
                                "3. Book a Seat.\n"+
                                "4. Remove Booking.\n"+
                                "5. Remove All Bookings of a Client.\n"+
                                "0. Exit.\n");
            if (sc.hasNextByte()) option = sc.nextByte();
            sc.nextLine();
            if (option < MINIMUM || option > MAXIMUM) {
                System.out.println("Chose Correct Option.");
            }
        } while (option < MINIMUM || option > MAXIMUM);
        return option;
    }
    
    private void showSeats() {
        if (!management.getSeats().isEmpty()) {
            management.getSeats().forEach(System.out::println);
        } else {
            System.out.println("There Are No Booked Seats.");
        }
    }
    
    private void showSeatsPerPerson() {
        try {
            String person = inputPerson();
            
            if (management.getSeats().stream().anyMatch(o -> o.getPerson().equalsIgnoreCase(person))) {
                management.getSeats().stream().filter(o -> o.getPerson().equalsIgnoreCase(person)).forEach(System.out::println);
            } else {
                System.out.println(person + " Don't Have Any Seat Booked.");
            }
        } catch (IncorrectPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void reserveSeat() {
        try {
            int row, seatNum;
            String person = "";
            
            row = inputrow();
            seatNum = inputSeatNum();
            if (management.searchSeat(row, seatNum) == -1) {
                person = inputPerson();
                System.out.println(management.addSeat(new Seat(row, seatNum, person)));
            } else {
                throw new BusySeatException();
            }
        } catch (IncorrectPersonNameException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectRowException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectSeatNumException e) {
            System.out.println(e.getMessage());
        } catch (BusySeatException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void cancelReserve() {
        try {
            int row, seatNum;
            row = inputrow();
            seatNum = inputSeatNum();
            System.out.println(management.removeSeat(row, seatNum));
        } catch (IncorrectRowException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectSeatNumException e) {
            System.out.println(e.getMessage());
        } catch (FreeSeatException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void cancelReservePerson() {
        try {
            String person = inputPerson();
            
            if (management.getSeats().stream().anyMatch(o -> o.getPerson().equalsIgnoreCase(person))) {
                management.getSeats().removeIf(o -> o.getPerson().equalsIgnoreCase(person));
                System.out.println("Bookings Removed.");
            } else {
                System.out.println(person + " Have No Booked Seats.");
            }
        } catch (IncorrectPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private String inputPerson() throws IncorrectPersonNameException {
        String person;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("Input Name:");
            person = sc.nextLine();
            if (!person.matches(".*\\d.*")) {
                return person;
            } else {
                throw new IncorrectPersonNameException();
            }
        } while (person.matches(".*\\d.*"));
    }
    
    private void initialData() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.println("Input Number of Rows:");
        do {
            if (sc.hasNextInt()) num = sc.nextInt();
            sc.nextLine();
            if (num < 1) System.out.println("The number must be greater than 0.");
        } while (num < 1);
        this.rows = num;
        num = 0;
        System.out.println("Input Number of Seats Per Row:");
        do {
            if (sc.hasNextInt()) num = sc.nextInt();
            sc.nextLine();
            if (num < 1) System.out.println("The number must be greater than 0.");
        } while (num < 1);
        this.seatsPerRow = num;
        
        Seat s1 = new Seat(1, 1, "Isma");
        Seat s2 = new Seat(2, 3, "Isma");
        Seat s3 = new Seat(2, 5, "Isma");
        Seat s4 = new Seat(4, 6, "Vane");
        Seat s5 = new Seat(5, 5, "Sorro");
        Seat s6 = new Seat(6, 3, "vane");
        
        try {
            management.addSeat(s1);
            management.addSeat(s2);
            management.addSeat(s3);
            management.addSeat(s4);
            management.addSeat(s5);
            management.addSeat(s6);
        } catch (BusySeatException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private int inputrow() throws IncorrectRowException {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Row:");
        if (sc.hasNextInt()) num = sc.nextInt();
        if (num < 1 || num > this.rows) throw new IncorrectRowException();
        return num;
    }
    
    private int inputSeatNum() throws IncorrectSeatNumException {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Seat Number:");
        if (sc.hasNextInt()) num = sc.nextInt();
        if (num < 1 || num > this.seatsPerRow) throw new IncorrectSeatNumException();
        return num;
    }
}
