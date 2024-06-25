package n3Exercise1;

public class FreeSeatException extends Exception {
    private String message;

    public FreeSeatException() {
        this.message = "Not Booked Seat.";
    }


    @Override
    public String getMessage() {
        return message;
    }
}

