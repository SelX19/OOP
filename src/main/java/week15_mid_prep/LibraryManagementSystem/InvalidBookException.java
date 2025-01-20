package week15_mid_prep.LibraryManagementSystem;

//unchecked exception - runtime exception
public class InvalidBookException extends RuntimeException {
    public InvalidBookException(String message) {
        super(message);
    }
    public InvalidBookException(String message, Throwable cause) {
        super(message, cause);
    }
}
