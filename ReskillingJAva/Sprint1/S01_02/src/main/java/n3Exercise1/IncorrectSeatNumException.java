package n3Exercise1;

public class IncorrectSeatNumException extends Exception {
    private String message;

    public IncorrectSeatNumException() {
        this.message = "Incorrect Seat.";
    }


    @Override
    public String getMessage() {
        return message;
    }
}

