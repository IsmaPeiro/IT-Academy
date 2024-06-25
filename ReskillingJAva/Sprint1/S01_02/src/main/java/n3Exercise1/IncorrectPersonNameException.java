package n3Exercise1;

public class IncorrectPersonNameException extends Exception {
    private String message;

    public IncorrectPersonNameException() {
        this.message = "The name cannot contains numbers.";
    }


    @Override
    public String getMessage() {
        return message;
    }
}


