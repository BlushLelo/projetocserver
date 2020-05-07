import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void printMenu(){
        System.out.println("+-------+------------------------------------------+");
        System.out.println("| CON   |   Fazer consulta de desenho armazenados. |");
        System.out.println("| SAV   |   Salvar desenho.                        |");
        System.out.println("| FIC   |   Sair do programa.                      |");
        System.out.println("+-------+------------------------------------------+");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ServerSocket server = new ServerSocket(1234);
        Socket client = server.accept();
        ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
        Operacao operacao = (Operacao) objectInputStream.readObject();
        OperacoesCommander operacoesCommander = new OperacoesCommander(operacao, new OperacoesImpl());
        operacoesCommander.executa();

//        Scanner scanner = new Scanner(System.in);
//        try {
//            ServerSocket request = new ServerSocket (12345);
//            Socket conn = request.accept();
//        } catch (Exception erro){
//            System.out.println(erro.getMessage());
//        }
//        System.out.println("O servidor está ativo.");
//        printMenu();
//
//        for(;;){
//            String comando = "";
//            try{
//                System.out.print("> ");
//                comando = scanner.nextLine();
//
//                Operacao op = null;
//                switch(comando){
//                    case "CON":
//                        Ope
//                        break;
//                    case "SAV":
//                        String nome_desenho;
//                }
//
//            }catch (Exception erro){}
//        }
    }
}
