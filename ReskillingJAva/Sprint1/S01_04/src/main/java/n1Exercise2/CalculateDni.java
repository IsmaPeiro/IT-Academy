package n1Exercise2;

public class CalculateDni {
    
    public static char getLetterDni (int num) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letters.charAt(num % 23);
    }
}