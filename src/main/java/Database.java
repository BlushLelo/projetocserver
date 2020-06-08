import bd.DBteste;
import bd.FiguraDatabase;
import dev.morphia.Datastore;
import dev.morphia.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static dev.morphia.query.experimental.filters.Filters.eq;
import static dev.morphia.query.experimental.updates.UpdateOperators.pullAll;
import static dev.morphia.query.experimental.updates.UpdateOperators.push;

public class Database implements DatabaseGateway {
    Datastore datastore;

    public Database(Datastore datastore) {
        this.datastore = datastore;
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public void salvar(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora) {
        System.out.println("Nome: " + nome + "\nListagiruas: " + figuraList.toString() + "\nIp: " + ipDoCliente + "\ndata: " + dataHora);

        List<FiguraDatabase> figuraDatabase = figuraList.stream().map(FiguraConverter::converter).collect(Collectors.toList());

        /*consultar primeiro, se o nome do desenho não existir CRIAR UM NOVO\ */
        Query<DBteste> query = datastore.find(DBteste.class);
        query.filter(eq("ip", ipDoCliente), eq("nome", nome));
        List<DBteste> document = query.iterator().toList();

        DBteste doc = new DBteste(ipDoCliente, nome, figuraDatabase);

        if (document.isEmpty())
            datastore.save(doc);//salva novo desenho
        else {
            //salva desenho com novas figuras
            if (!document.get(0).getListaDeFiguras().isEmpty()) {
                query.update(pullAll("listaDeFiguras", document.get(0).getListaDeFiguras())).execute();
            }
            query.update(push("listaDeFiguras", figuraDatabase)).execute();

        }
    }

    @Override
    public void consultar(String ip) {
        System.out.println("IP a ser consultado no DB: " + ip);
        //Consultar IP e retornar desenhos do IP ou indicar que não há
        List<DBteste> teste = datastore.find(DBteste.class).filter(eq("ip", ip)).iterator().toList();

        System.out.println(teste);
    }
}

