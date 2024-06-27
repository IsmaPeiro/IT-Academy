package n1Exercise3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Game {
    
    private String userName;
    private int score = 0;
    private IOManagement files = new IOManagement();
    private final LinkedHashMap<String, String> countriesMap = new LinkedHashMap<>();
    private final List<String> countries = new ArrayList<>();
    
    public Game() throws IOException {
    }
    
    private void fillCountries() throws FileNotFoundException {
        files.readCountriesFile().forEach((country) -> {
            String[] countryParts = country.split(" ");
            countriesMap.put(countryParts[0], countryParts[1]);
            countries.add(countryParts[0]);
        });
    }
    
    private void nextQuestion() {
        Scanner sc = new Scanner(System.in);
        String country = countries.get((int) Math.floor(Math.random() * countries.size()));
        String capital = countriesMap.get(country);
        country = country.replace('_', ' ');
        capital = capital.replace('_', ' ');
        System.out.println("Capital of " + country + "?");
        if (sc.nextLine().equalsIgnoreCase(capital)) {
            System.out.println("Correct!");
            this.score++;
        } else {
            System.out.println("Error, the capital of " + country + " is " + capital + ".");
        }
    }
    
    public void play() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your Name:");
        userName = sc.nextLine();
        if (userName.equalsIgnoreCase("")) userName = "No Name";
        fillCountries();
        for (int i = 0; i < 10; i++) {
            nextQuestion();
        }
        System.out.println("Your score is: " + score);
        files.writeRanking(userName, score);
    }
}
