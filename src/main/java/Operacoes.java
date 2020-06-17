import exception.ConsultarException;
import exception.SaveException;

import java.util.List;

public interface Operacoes {

    OperacaoResponse salvarDesenho(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora) throws SaveException;

    List<OperacaoResponse> consultarDesenho(String ip) throws ConsultarException;

    void desconectar();

}
