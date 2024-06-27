package n3Exercise1;

import n3Exercise1.news.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Editorial {
    ArrayList<Editor> editors;
    
    public Editorial() {
        this.editors = new ArrayList<>();
    }
    
    public void init() {
        Editor isma = new Editor("Isma", "00000000T");
        Editor vane = new Editor("Vane", "11111111H");
        
        editors.add(isma);
        editors.add(vane);
        
        Basket new1 = new Basket("Penya Wins the EuroLigue", "EuroLigue", "Joventut");
        Basket new2 = new Basket("Chicho Terremoto MVP", "ACB", "Buffalos");
        F1 new3 = new F1("Turtle run in Montmeló", "Isseta");
        F1 new4 = new F1("Pedal cars of Orbea not work", "Orbea");
        Motorcycling new5 = new Motorcycling("Vespa riders take the wrong circuit", "Vespa");
        Motorcycling new6 = new Motorcycling("HP wants to enter in the runs", "HP");
        Soccer new7 = new Soccer("Benzema stay home", "Champions", "Madrid", "Benzema");
        Soccer new8 = new Soccer("El New Team win La Liga", "La Liga", "New Team", "Oliver");
        Tennis new9 = new Tennis("The tennis with golf sticks are weird", "Mad Open", "Tiger Woods");
        Tennis new10 = new Tennis("First solo tennis match", "Grand Slam", "Venus");
        
        isma.inputNew(new1);
        isma.inputNew(new3);
        isma.inputNew(new5);
        isma.inputNew(new7);
        isma.inputNew(new9);
        vane.inputNew(new2);
        vane.inputNew(new4);
        vane.inputNew(new6);
        vane.inputNew(new8);
        vane.inputNew(new10);
        boolean exit = false;
        
        do {
            switch (menu()) {
                case 1 -> createEditor(editors);
                case 2 -> removeEditor(editors);
                case 3 -> inputNew(editors);
                case 4 -> removeNew(editors);
                case 5 -> showNews(editors);
                case 6 -> calculatePointsNew(editors);
                case 7 -> calculatePriceNew(editors);
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
            System.out.println("1. Input New Editor.");
            System.out.println("2. Remove Editor.");
            System.out.println("3. Input New.");
            System.out.println("4. Remove New.");
            System.out.println("5. Show All News of Editor.");
            System.out.println("6. Calculate Punctuation of a New.");
            System.out.println("7. Calculate Price of a New.");
            System.out.println("0. Exit.\n");
            if (sc.hasNextByte()) option = sc.nextByte();
            sc.nextLine();
            if (option < MINIMUM || option > MAXIMUM) System.out.println("Chose Valid Option.");
        } while (option < MINIMUM || option > MAXIMUM);
        return option;
    }
    
    public void createEditor(ArrayList<Editor> editors) {
        Scanner sc = new Scanner(System.in);
        String dni = "", name = "";
        Editor editor = null;
        
        do {
            do {
                System.out.println("Input DNI or EXIT:");
                dni = sc.nextLine();
            } while (!dni.equalsIgnoreCase("EXIT") && !checkDni(dni));
            if (!dni.equalsIgnoreCase("EXIT")) {
                editor = seekEditor(dni, editors);
                
                if (editor == null) {
                    System.out.println("Input Editor's Name:");
                    name = sc.nextLine();
                    editors.add(new Editor(name, dni));
                } else {
                    System.out.println("This Editor is Already Input.");
                }
            }
        } while (editor != null && tryAgain());
    }
    
    public void removeEditor(ArrayList<Editor> editors) {
        showEditors();
        if (editors.remove(requestEditor(editors))) System.out.println("Editor Removed Properly.");
    }
    
    public void inputNew(ArrayList<Editor> editors) {
        showEditors();
        Editor editor=requestEditor(editors);
        
        if (editor!=null) menuNews(editor);
    }
    
    public void menuNews(Editor editor) {
        int sport = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("¿What sport do you want to introduce the news about?\n");
            System.out.println("1. Soccer | 2. Basket | 3. Tenis | 4. F1 | 5. Motorcycling | 0. Exit");
            if (sc.hasNextByte()) sport = sc.nextByte();
            sc.nextLine();
            if (sport > 5 || sport < 0) System.out.println("Chose Valid Option.");
        } while (sport > 5 || sport < 0);
        
        switch (sport) {
            case 1 -> inputSoccerNew(editor);
            case 2 -> inputBasketNew(editor);
            case 3 -> inputTennisNew(editor);
            case 4 -> inputF1New(editor);
            case 5 -> inputMotorcyclingNew(editor);
        }
    }
    
    public void inputSoccerNew(Editor editor) {
        String titular = "", competition = "", club = "", player = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Input titular:");
        titular = sc.nextLine();
        System.out.println("Input Competition:");
        competition = sc.nextLine();
        System.out.println("Input club:");
        club = sc.nextLine();
        System.out.println("Input Player:");
        player = sc.nextLine();
        Soccer newsReport = new Soccer(titular, competition, club, player);
        editor.inputNew(newsReport);
        System.out.println("New Created Properly.");
    }
    
    public void inputBasketNew(Editor editor) {
        
        String titular = "", competition = "", club = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Input Titular:");
        titular = sc.nextLine();
        System.out.println("Input Competition:");
        competition = sc.nextLine();
        System.out.println("Input Club:");
        club = sc.nextLine();
        Basket newsReport = new Basket(titular, competition, club);
        editor.inputNew(newsReport);
        System.out.println("New Created PProperly.");
    }
    
    public void inputTennisNew(Editor editor) {
        
        String titular = "", competicion = "", player = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Input titular:");
        titular = sc.nextLine();
        System.out.println("Input Competition:");
        competicion = sc.nextLine();
        System.out.println("Input Player:");
        player = sc.nextLine();
        Tennis newsReport = new Tennis(titular, competicion, player);
        editor.inputNew(newsReport);
        System.out.println("New Created Properly.");
    }
    
    public void inputF1New(Editor editor) {
        
        String titular = "", team = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Input titular:");
        titular = sc.nextLine();
        System.out.println("Input Team:");
        team = sc.nextLine();
        F1 rnewsReport = new F1(titular, team);
        editor.inputNew(rnewsReport);
        System.out.println("New Created Properly.");
    }
    
    public void inputMotorcyclingNew(Editor editor) {
        
        String titular = "", team = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Input titular:");
        titular = sc.nextLine();
        System.out.println("Input Team:");
        team = sc.nextLine();
        Motorcycling newsReport = new Motorcycling(titular, team);
        editor.inputNew(newsReport);
        System.out.println("New Created Properly.");
    }
    
    public void removeNew(ArrayList<Editor> editors) {
        showEditors();
        Editor editor = null;
        
        editor = requestEditor(editors);
        if (editor != null) {
            System.out.print(editor.showTitulars());
            if (editor.removeNew(requestNew(editor))) System.out.println("New Removed Properly.");
        }
    }
    
    
    public void showNews(ArrayList<Editor> editors) {
        showEditors();
        Editor editor = null;
        
        editor = requestEditor(editors);
        if (editor != null) System.out.println(editor.showNews());
    }
    
    public void calculatePointsNew(ArrayList<Editor> editors) {
        showEditors();
        Editor editor = null;
        NewsReport newsReport = null;
        
        editor = requestEditor(editors);
        if (editor != null) {
            System.out.print(editor.showTitulars());
            newsReport = requestNew(editor);
            if (newsReport != null) {
                System.out.println("The Punctuation of The New is: " + newsReport.calculatePointsNew());
            }
        }
    }
    
    public void calculatePriceNew(ArrayList<Editor> editors) {
        showEditors();
        Editor editor = null;
        NewsReport newsReport = null;
        
        
        editor = requestEditor(editors);
        if (editor != null) {
            System.out.print(editor.showTitulars());
            newsReport = requestNew(editor);
            if (newsReport != null) {
                System.out.println("The Price of the New is: " + newsReport.calculatePriceNew());
            }
            
        }
        
    }
    
    public NewsReport requestNew(Editor editor) {
        Scanner sc = new Scanner(System.in);
        String titular = "";
        NewsReport newsReport = null;
        boolean exit = true;
        
        do {
            exit = true;
            System.out.println("Input Titular of the New or EXIT:");
            titular = sc.nextLine();
            if (!titular.equalsIgnoreCase("EXIT")) {
                newsReport = editor.seekNew(titular);
                if (newsReport == null) {
                    System.out.println("This New is Not Registered.");
                    exit = !tryAgain();
                }
            }
        } while (!exit);
        return newsReport;
    }
    
    public Editor requestEditor(ArrayList<Editor> editors) {
        Scanner sc = new Scanner(System.in);
        String dni;
        Editor editor = null;
        boolean exit = true;
        
        do {
            exit = true;
            System.out.println("Input DNI or EXIT:");
            dni = sc.nextLine();
            if (!dni.equalsIgnoreCase("EXIT")) {
                if (checkDni(dni)) {
                    editor = seekEditor(dni, editors);
                    if (editor == null) {
                        System.out.println("This Editor is Not Registered.");
                        exit = !tryAgain();
                    }
                } else {
                    exit = false;
                }
            }
        } while (!exit);
        return editor;
    }
    
    public Editor seekEditor(String dni, ArrayList<Editor> editors) {
        Editor editor = null;
        Optional<Editor> expresion = editors.stream().filter(o -> o.getDni().equalsIgnoreCase(dni)).findFirst();
        
        if (expresion.isPresent()) editor = expresion.get();
        return editor;
    }
    
    public boolean tryAgain() {
        boolean response = true;
        String option = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Try again? [Y/N]");
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
    
    private void showEditors() {
        System.out.println("List of Editors:");
        editors.forEach(editors ->
                System.out.println("Name: " + editors.getName() + " DNI: " + editors.getDni()));
    }
}
