import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RespondeClienteImpl implements RespondeCliente {


    @Override
    public void enviaDesenho(Socket server, OperacaoResponse operacaoResponse) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
        objectOutputStream.writeObject(operacaoResponse);

    }
}
