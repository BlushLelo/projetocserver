import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * The type Main.
 */
public class Main {


    /**
     * The entry point of application.
     * <p>
     * Na main, iniciamos a conexao com o banco de dados e apos isso, criamos uma thread para cada client conectado no servidor
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(2134);
        Database conexao = new ConexaoDB().getDatabase();


        while (true) {
            Socket client = server.accept();
            System.out.println("Conectou");
            TrataCliente tc = new TrataCliente(client, conexao);
            new Thread(tc).start();
        }


    }

}
