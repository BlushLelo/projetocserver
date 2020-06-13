import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TesteImpl implements Teste {


    @Override
    public void enviaDesenho(String nomeDaOperacao, Socket server, OperacaoResponse operacaoResponse) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(server.getOutputStream());
        objectOutputStream.writeObject(operacaoResponse);

    }
}
