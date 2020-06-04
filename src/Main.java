import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main {

    private static MongoClient mongoClient = MongoClients.create("mongodb://admin:z7_8f!HA7hk-Bsf@ds237196.mlab.com:37196/projetoc");


    public static void printMenu() {
        System.out.println("+-------+------------------------------------------+");
        System.out.println("| CON   |   Fazer consulta de desenho armazenados. |");
        System.out.println("| SAV   |   Salvar desenho.                        |");
        System.out.println("| FIC   |   Sair do programa.                      |");
        System.out.println("+-------+------------------------------------------+");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket server = new ServerSocket(2134);
        List<ObjectInputStream> clientes = new ArrayList<>();

        while (true) {
            Socket client = server.accept();
            System.out.println("Conectou");
            TrataCliente tc = new TrataCliente(client, server, getDatabase());
            new Thread(tc).start();
        }


    }

    private static Database getDatabase() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoDatabase database = mongoClient.getDatabase("projetoc").withCodecRegistry(pojoCodecRegistry);
        return new Database(database.getCollection("figuras"));
    }
}
