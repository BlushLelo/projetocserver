import java.util.List;

public class OperacoesImpl implements Operacoes {

    DatabaseGateway database;

    public OperacoesImpl(DatabaseGateway database) {
        this.database = database;
    }

    @Override
    public void salvarDesenho(String nome, List<Figura> figuraList, String ipDoCliente) {
        System.out.println("Chamada a implementacao de salvar desenho");
        database.salvar(nome, figuraList, ipDoCliente);
    }

    @Override
    public void consultarDesenho() {
        System.out.println("Chamada a implementacao de consultar desenho");
    }

    @Override
    public void desconectar() {

    }
}
