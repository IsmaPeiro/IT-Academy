package n3Exercise1;

public class IncorrectRowException extends Exception {
    private String message;

    public IncorrectRowException() {
        this.message = "Incorrect Row.";
    }


    @Override
    public String getMessage() {
        return message;
    }
}

