package n3Exercici1;

public class BusySeatException extends Exception {
    private String message;

    public BusySeatException() {
        this.message = "The Seat Is Reserved.";
    }


    @Override
    public String getMessage() {
        return message;
    }
}

