/**
 * Exception thrown for deleting in an empty array
 */
public class UnderflowException extends Exception {
    public UnderflowException(String errorMessage) {
        super(errorMessage);
    }
}
