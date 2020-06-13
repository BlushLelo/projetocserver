import java.io.IOException;
import java.net.Socket;

public interface Teste {

    void enviaDesenho(String nomeDaOperacao, Socket server, OperacaoResponse operacaoResponse) throws IOException;

}