package project.mohak.booking.platform.exception;

public class InvalidInputException extends RuntimeException {
    String message;
    public InvalidInputException(String msg) {
        this.message = msg;
    }

}
