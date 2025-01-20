package week15_final_prep.MovieDataTransformation;

public class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String message) {
        super(message);
    }
    public InvalidMovieDataException(String message, Throwable cause){
        super(message, cause);
    }
}
