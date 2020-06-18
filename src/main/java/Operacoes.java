import exception.ConsultarException;
import exception.SaveException;

import java.util.List;


/**
 * The interface Operacoes.
 * Interfaces das operacoes disponiveis no sistema
 */
public interface Operacoes {

    /**
     * Salvar desenho operacao response.
     *
     * @param nome        the nome
     * @param figuraList  the figura list
     * @param ipDoCliente the ip do cliente
     * @return the operacao response
     * @throws SaveException the save exception
     */
    OperacaoResponse salvarDesenho(String nome, List<Figura> figuraList, String ipDoCliente) throws SaveException;

    /**
     * Consultar desenho list.
     *
     * @param ip the ip
     * @return the list
     * @throws ConsultarException the consultar exception
     */
    List<OperacaoResponse> consultarDesenho(String ip) throws ConsultarException;

    /**
     * Desconectar.
     */
    void desconectar();

}
