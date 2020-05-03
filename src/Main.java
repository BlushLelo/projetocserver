import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ServerSocket server = new ServerSocket(1234);
        Socket client = server.accept();
        ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
        Operacao operacao = (Operacao) objectInputStream.readObject();
        OperacoesCommander operacoesCommander = new OperacoesCommander(operacao, new OperacoesImpl());
        operacoesCommander.executa();
    }

}
