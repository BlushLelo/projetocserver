import bd.*;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import exception.SaveException;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public OperacaoResponse salvar(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora) throws SaveException {
        System.out.println("Nome: " + nome + "\nListagiruas: " + figuraList.toString() + "\nIp: " + ipDoCliente + "\ndata: " + dataHora);

        List<FiguraDatabase> figuraDatabase = figuraList.stream().map(FiguraConverter::converter).collect(Collectors.toList());

        /*consultar primeiro, se o nome do desenho não existir CRIAR UM NOVO\ */
        Query<DBteste> query = datastore.find(DBteste.class);
        query.filter(eq("ip", ipDoCliente), eq("nome", nome));
        List<DBteste> document = query.iterator().toList();

        DBteste doc = new DBteste(ipDoCliente, nome, figuraDatabase);

        if (document.isEmpty())
            try {
                DBteste desenho = datastore.save(doc);//salva novo desenho
                return new OperacaoResponse("NEW", desenho.getCreationDate(), desenho.getLastChange());
            } catch (Exception e) {
                throw new SaveException("Problemas ao salvar", e);
            }
        else {
            //salva desenho com novas figuras
            try {
                if (!document.get(0).getListaDeFiguras().isEmpty()) {
                    query.update(pullAll("listaDeFiguras", document.get(0).getListaDeFiguras())).execute();
                }
                query.update(push("listaDeFiguras", figuraDatabase)).execute();
                return new OperacaoResponse("UPD", null, document.get(document.size() - 1).getLastChange());
            } catch (Exception e) {
                return new OperacaoResponse(null, null, null, null, true);
            }
        }
    }

    @Override
    public List<OperacaoResponse> consultar(String ip) {
        System.out.println("IP a ser consultado no DB: " + ip);
        //Consultar IP e retornar desenhos do IP ou indicar que não há
        List<DBteste> response = datastore.find(DBteste.class).filter(eq("ip", ip)).iterator().toList();

        return response.stream().map(item -> {

            List<Figura> figuraList = new ArrayList<>();
            List<RetanguloDatabase> retanguloDatabaseList = item.getListaDeFiguras().stream().filter(object -> object instanceof RetanguloDatabase).map(object -> (RetanguloDatabase) object).collect(Collectors.toList());
            List<QuadradoDatabase> quadradoDatabaseList = item.getListaDeFiguras().stream().filter(object -> object instanceof QuadradoDatabase).map(object -> (QuadradoDatabase) object).collect(Collectors.toList());
            List<PontoDatabase> pontoDatabaseList = item.getListaDeFiguras().stream().filter(object -> object instanceof PontoDatabase).map(object -> (PontoDatabase) object).collect(Collectors.toList());
            List<PoligonoDatabase> poligonoDatabaseList = item.getListaDeFiguras().stream().filter(object -> object instanceof PoligonoDatabase).map(object -> (PoligonoDatabase) object).collect(Collectors.toList());
            List<LinhaDatabase> linhaDatabaseList = item.getListaDeFiguras().stream().filter(object -> object instanceof LinhaDatabase).map(object -> (LinhaDatabase) object).collect(Collectors.toList());
            List<ElipseDatabase> elipseDatabaseList = item.getListaDeFiguras().stream().filter(object -> object instanceof ElipseDatabase).map(object -> (ElipseDatabase) object).collect(Collectors.toList());
            List<CirculoDatabase> circuloDatabaseList = item.getListaDeFiguras().stream().filter(object -> object instanceof CirculoDatabase).map(object -> (CirculoDatabase) object).collect(Collectors.toList());


            retanguloDatabaseList.stream().map(ret -> new Retangulo(ret.getP1().getX(), ret.getP1().getY(), ret.getP2().getX(), ret.getP2().getY(), new Color(ret.getCor()), ret.isPreenchido())).forEach(figuraList::add);
            quadradoDatabaseList.stream().map(quad -> new Quadrado(quad.getP1().getX(), quad.getP1().getY(), quad.getP2().getX(), quad.getP2().getY(), new Color(quad.getCor()), quad.isPreenchido())).forEach(figuraList::add);
            pontoDatabaseList.stream().map(pont -> new Ponto(pont.getX(), pont.getY(), new Color(pont.getCor()))).forEach(figuraList::add);

            poligonoDatabaseList.stream().map(poli -> {
                ArrayList<Ponto> arrayListPontos = poli.getPontosDoPol().stream().map(ponto -> new Ponto(ponto.getX(), ponto.getY(), new Color(ponto.getCor()))).collect(Collectors.toCollection(ArrayList::new));
                return new Poligono(arrayListPontos, new Color(poli.getCor()), poli.isPreenchido());
            }).forEach(figuraList::add);

            linhaDatabaseList.stream().map(linha -> new Linha(linha.getP1().getX(), linha.getP1().getY(), linha.getP2().getX(), linha.getP2().getY(), new Color(linha.getCor()))).forEach(figuraList::add);

            elipseDatabaseList.stream().map(elipse -> new Elipse(elipse.getP1().getX(), elipse.getP1().getY(), elipse.getP2().getX(), elipse.getP2().getY(), new Color(elipse.getCor()), elipse.isPreenchido())).forEach(figuraList::add);

            circuloDatabaseList.stream().map(circulo -> new Circulo(circulo.getP1().getX(), circulo.getP1().getY(), circulo.getP2().getX(), circulo.getP2().getY(), new Color(circulo.getCor()), circulo.isPreenchido())).forEach(figuraList::add);
            System.out.println(figuraList);
            return new OperacaoResponse(item.getNome(), item.getCreationDate(), item.getLastChange(), figuraList, "DES", false, item.getIp());
        }).collect(Collectors.toList());


    }
}

