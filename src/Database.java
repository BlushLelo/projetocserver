import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.sun.istack.internal.localization.NullLocalizable;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.print.Doc;
import javax.swing.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Database implements DatabaseGateway {
    MongoCollection<Document> mongoCollection;

    public Database(MongoCollection<Document> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public void salvar(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora) {
        System.out.println("Nome: " + nome+"\nListagiruas: " + figuraList.toString() + "\nIp: " + ipDoCliente + "\ndata: "+dataHora);

        List<FiguraDatabase> figuraDatabase = figuraList.stream().map(FiguraConverter::converter).collect(Collectors.toList());

        /*consultar primeiro, se o nome do desenho não existir CRIAR UM NOVO\
        *se existir atualiza desenho*/
        //query
        BasicDBObject query = new BasicDBObject();
        query.put("nome", nome);
        query.put("ip", ipDoCliente);
        //consulta no banco por desenho com o mesmo nome e claro o mesmo IP
        FindIterable<Document> document =  mongoCollection.find(query);

        Document doc = new Document("ip", ipDoCliente).append("nome", nome).append("data", dataHora).append("data_mod","").append("listaDeFiguras", figuraDatabase);
        if(!document.iterator().hasNext())
            mongoCollection.insertOne(doc);//salva novo desenho
        else {
            //salva desenho com novas figuras
            BasicDBObject newDoc = new BasicDBObject("data_mod",getDateTime()).append("listaDeFiguras", figuraDatabase);
            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("$set", newDoc);
            mongoCollection.updateOne(query, updateObject);
            //SE SALAR CORRETO ENVIAR 'UPD' e a data de mod PARA O USUARIO, caso contrario 'ERR'
        }
    }

    @Override
    public void consular(String ip, String nome) {
        System.out.println("IP a ser consultado no DB: " + ip);
        //consultar IP e retornar desenhos do IP ou indicar que não há
        BasicDBObject query = new BasicDBObject();
        query.put("ip", ip);
        //query.put("nome", nome);

        FindIterable<Document> document =  mongoCollection.find(query);




        //TEMOS OS OBJETOS DO BANCO EM 'jsonData'
        if(!document.iterator().hasNext())
            System.out.println("FIC");
        else {
            //'DES' para cada desenho
            String a = JOptionPane.showInputDialog("a");
            System.out.println();
        }
    }

}
