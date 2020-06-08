import java.util.List;

public interface DatabaseGateway {

    void salvar(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora);

    void consular(String ip, String nome);
}
