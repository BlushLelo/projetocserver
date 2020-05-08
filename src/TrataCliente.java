import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TrataCliente implements Runnable {

    private Socket socket;
    private ServerSocket server;

    public TrataCliente(Socket socket, ServerSocket server) {
        this.socket = socket;
        this.server = server;
    }


    @Override
    public void run() {
        try {
            System.out.println("Thread Criada");
            while (true) {
                new Scanner(System.in);
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Operacao operacao = (Operacao) objectInputStream.readObject();
                System.out.println(operacao.getOperation());
                OperacoesCommander operacoesCommander = new OperacoesCommander(operacao, new OperacoesImpl());
                operacoesCommander.executa();
            }

        } catch (Exception e) {
            System.out.println("Errou");
        }
    }

}
