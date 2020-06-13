import java.io.IOException;
import java.net.Socket;

public interface RespondeCliente {

    void enviaDesenho(Socket server, OperacaoResponse operacaoResponse) throws IOException;

}