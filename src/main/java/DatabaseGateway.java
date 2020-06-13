import java.util.List;

public interface DatabaseGateway {

    void salvar(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora);

    List<OperacaoResponse> consultar(String ip);
}
