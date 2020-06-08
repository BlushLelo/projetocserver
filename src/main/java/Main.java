import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printMenu() {
        System.out.println("+-------+------------------------------------------+");
        System.out.println("| CON   |   Fazer consulta de desenho armazenados. |");
        System.out.println("| SAV   |   Salvar desenho.                        |");
        System.out.println("| FIC   |   Sair do programa.                      |");
        System.out.println("+-------+------------------------------------------+");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket server = new ServerSocket(2134);
        Database conexao = new ConexaoDB().getDatabase();
        List<ObjectInputStream> clientes = new ArrayList<>();


        while (true) {
            Socket client = server.accept();
            System.out.println("Conectou");
            TrataCliente tc = new TrataCliente(client, server, conexao);
            new Thread(tc).start();
        }


    }

}
