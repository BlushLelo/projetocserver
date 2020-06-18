import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * The type Responde cliente.
 * <p>
 * Criamos um object outPutStream e enviamos a operacaoResponse de volta ao client
 */
public class RespondeClienteImpl implements RespondeCliente {


    @Override
    public void enviaDesenho(Socket server, OperacaoResponse operacaoResponse) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
        objectOutputStream.writeObject(operacaoResponse);

    }
}
