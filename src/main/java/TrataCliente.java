import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TrataCliente implements Runnable {

    private Socket client;
    private ServerSocket server;
    private DatabaseGateway database;

    public TrataCliente(Socket client, ServerSocket server, DatabaseGateway database) {
        this.client = client;
        this.server = server;
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
