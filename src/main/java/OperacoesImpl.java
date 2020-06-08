import java.util.List;

public class OperacoesImpl implements Operacoes {

    DatabaseGateway database;

    public OperacoesImpl(DatabaseGateway database) {
        this.database = database;
    }

    @Override
    public void salvarDesenho(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora) {
        System.out.println("Chamada a implementacao de salvar desenho");
        database.salvar(nome, figuraList, ipDoCliente, dataHora);
    }

    @Override
    public void consultarDesenho(String ip) {
        System.out.println("Chamada a implementacao de consultar desenho");
        database.consular(ip);
    }

    @Override
    public void desconectar() {

    }
}