import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


/**
 * The type Trata cliente.
 */
public class TrataCliente implements Runnable {

    private Socket client;
    private DatabaseGateway database;

    /**
     * Instantiates a new Trata cliente.
     *
     * @param client   the client
     * @param database the database
     */
    public TrataCliente(Socket client, DatabaseGateway database) {
        this.client = client;
        this.database = database;
    }


    @Override
    public void run() {
        try {
            System.out.println("Thread Criada");
            while (true) {
                String ip = (((InetSocketAddress) client.getRemoteSocketAddress()).getAddress()).toString().replace("/", "");
                System.out.println("Ip conectado ao servidor: " + ip);
                new Scanner(System.in);
                ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                Operacao operacao = (Operacao) objectInputStream.readObject();
                operacao.setIp(ip);
                System.out.println(operacao.getOperation());
                OperacoesCommander operacoesCommander = new OperacoesCommander(operacao, new OperacoesImpl(database), new RespondeClienteImpl(), client);
                operacoesCommander.executa();
            }

        } catch (Exception e) {
            System.out.println("Errou " + e);
        }
    }

}
