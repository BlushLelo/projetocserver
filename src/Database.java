import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;
import java.util.stream.Collectors;

public class Database implements DatabaseGateway {
    MongoCollection<Document> mongoCollection;

    public Database(MongoCollection<Document> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    @Override
    public void salvar(String nome, List<Figura> figuraList, String ipDoCliente) {
        List<FiguraDatabase> figuraDatabase = figuraList.stream().map(FiguraConverter::converter).collect(Collectors.toList());

        Document doc = new Document("ip", ipDoCliente).append("nome", nome).append("listaDeFiguras", figuraDatabase);
        mongoCollection.insertOne(doc);
    }

}
