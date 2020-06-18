import exception.ConsultarException;
import exception.SaveException;

import java.util.List;


/**
 * The interface Database gateway.
 * Interface para as operacoes que o banco de dados ira realizar
 */
public interface DatabaseGateway {

    /**
     * Salvar operacao response.
     *
     * @param nome        the nome
     * @param figuraList  the figura list
     * @param ipDoCliente the ip do cliente
     * @return the operacao response
     * @throws SaveException the save exception
     */
    OperacaoResponse salvar(String nome, List<Figura> figuraList, String ipDoCliente) throws SaveException;

    /**
     * Consultar list.
     *
     * @param ip the ip
     * @return the list
     * @throws ConsultarException the consultar exception
     */
    List<OperacaoResponse> consultar(String ip) throws ConsultarException;
}
