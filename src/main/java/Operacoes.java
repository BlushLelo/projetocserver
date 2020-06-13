import java.util.List;

public interface Operacoes {

    void salvarDesenho(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora);

    List<OperacaoResponse> consultarDesenho(String ip);

    void desconectar();

}
