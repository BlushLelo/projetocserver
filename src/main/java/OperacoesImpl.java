import exception.ConsultarException;
import exception.SaveException;

import java.util.List;

public class OperacoesImpl implements Operacoes {

    DatabaseGateway database;

    public OperacoesImpl(DatabaseGateway database) {
        this.database = database;
    }

    @Override
    public OperacaoResponse salvarDesenho(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora) throws SaveException {
        System.out.println("Chamada a implementacao de salvar desenho");
        return database.salvar(nome, figuraList, ipDoCliente, dataHora);
    }

    @Override
    public List<OperacaoResponse> consultarDesenho(String ip) throws ConsultarException {
        System.out.println("Chamada a implementacao de consultar desenho");
        return database.consultar(ip);

    }

    @Override
    public void desconectar() {

    }
}
