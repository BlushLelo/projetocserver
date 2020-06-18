package exception;


/**
 * The type Save exception.
 * Exception quando temos erros ao salvar um desenho de um user
 */
public class SaveException extends Exception {
    /**
     * Instantiates a new Save exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
