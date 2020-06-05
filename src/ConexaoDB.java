import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

public class ConexaoDB {

    /*
    * db.desenhos.insert({id:1,ip_cliente:"127.0.0.1",data_criacao:"2020-06-04 19:21:22",data_mod:"2020-06-04 20:36:45",desenho:"c:340:442:423:112:0:0:0:255:255:255"});
    * INSERT STRING
    * id : int : 0
    * ip_cliente : string : "127.0.0.1"
    * data_criacao : string : "2020-06-04 19:21:22"
    * data_mod : string "2020-06-04 19:24:22"
    * desenho : string : "c:340:442:423:112:0:0:0:255:255:255"
    */
    private static String server = "localhost";
    private static Integer port = 27017;
    //private static String database = "desenhos";

    //private static String user = "admin";
    //private static String password = "admin";
    //no authentication

    MongoClient mongoClient = new MongoClient( server , port );
    DB database = mongoClient.getDB("desenhos");
//    DBCollection collection = database.getCollection("");

    public ConexaoDB(){
        try {
            mongoClient.getAddress();
        }catch (Exception e){
            mongoClient.close();
            System.out.println(e.getMessage());
        }
    }

    public static MongoClient getConexaoDB(){
        //this.mongoClient.get
        return null;
    }
    public static boolean fecharConexao(){
        try{
            //mongoClient.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());

            return false;
        }
    }
}
