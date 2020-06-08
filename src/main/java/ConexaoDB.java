import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;


public class ConexaoDB {


    public Database getDatabase() {
        Datastore datastore = Morphia.createDatastore(MongoClients.create("mongodb://admin:z7_8f!HA7hk-Bsf@ds237196.mlab.com:37196/projetoc?retryWrites=false"), "projetoc");
        datastore.getMapper().mapPackage("bd");
        return new Database(datastore);
    }
}
