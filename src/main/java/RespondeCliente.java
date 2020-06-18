import java.io.IOException;
import java.net.Socket;


/**
 * The interface Responde cliente.
 */
public interface RespondeCliente {

    /**
     * Envia desenho.
     *
     * @param server           the server
     * @param operacaoResponse the operacao response
     * @throws IOException the io exception
     */
    void enviaDesenho(Socket server, OperacaoResponse operacaoResponse) throws IOException;

}