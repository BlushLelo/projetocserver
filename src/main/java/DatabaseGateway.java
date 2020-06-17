import exception.ConsultarException;
import exception.SaveException;

import java.util.List;

public interface DatabaseGateway {

    OperacaoResponse salvar(String nome, List<Figura> figuraList, String ipDoCliente, String dataHora) throws SaveException;

    List<OperacaoResponse> consultar(String ip) throws ConsultarException;
}
