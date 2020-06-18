import exception.ConsultarException;
import exception.SaveException;

import java.util.List;


/**
 * The type Operacoes.
 * <p>
 * Chamamos o gateway que faz a conexao com a database de acordo com a operacao necessaria
 */
public class OperacoesImpl implements Operacoes {

    /**
     * The Database.
     */
    DatabaseGateway database;

    /**
     * Instantiates a new Operacoes.
     *
     * @param database the database
     */
    public OperacoesImpl(DatabaseGateway database) {
        this.database = database;
    }

    @Override
    public OperacaoResponse salvarDesenho(String nome, List<Figura> figuraList, String ipDoCliente) throws SaveException {
        System.out.println("Chamada a implementacao de salvar desenho");
        return database.salvar(nome, figuraList, ipDoCliente);
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
