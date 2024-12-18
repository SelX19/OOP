package week11;

//unchecked exception (unchecked during compilation time, only checked during runtime)
public class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message){
        super(message);
    }
}
