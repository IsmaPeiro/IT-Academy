package n1Exercise1;

public class EmptySaleException extends Exception {
    private String message;

    public EmptySaleException() {
        this.message="To make a sale you first have to add products.";
    }


    @Override
    public String getMessage() {
        return message;
    }
}

