import java.util.List;

public interface Operacoes {

    void salvarDesenho(String nome, List<Figura> figuraList, String ipDoCliente);

    void consultarDesenho();

    void desconectar();

}
