package week15_final_prep.BookDataTransformation;

public class WrongFormatException extends RuntimeException {
    public WrongFormatException(String message) {
        super(message);
    }

    public WrongFormatException(String message, Throwable cause){
        super(message, cause);
    }
}
