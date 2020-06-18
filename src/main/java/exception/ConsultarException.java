package exception;


/**
 * The type Consultar exception.
 * Exception quando temos erro ao consultar os desenhos de um user
 */
public class ConsultarException extends Exception {
    /**
     * Instantiates a new Consultar exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ConsultarException(String message, Throwable cause) {
        super(message, cause);
    }
}
