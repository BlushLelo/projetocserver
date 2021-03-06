import exception.ConsultarException;
import exception.SaveException;

import java.io.IOException;
import java.net.Socket;
import java.util.List;


/**
 * The type Operacoes commander.
 * A partir de uma operacao recebida pelo client chamamos o gateway correspondente para realizar a operacao
 * SAV - SALVAR
 * CON - CONSULTAR
 */
public class OperacoesCommander {

    private Operacao operacao;

    private Operacoes operacoes;

    private RespondeCliente respondeCliente;

    private Socket socket;

    /**
     * Instantiates a new Operacoes commander.
     *
     * @param operacao        the operacao
     * @param operacoes       the operacoes
     * @param respondeCliente the responde cliente
     * @param socket          the socket
     */
    public OperacoesCommander(Operacao operacao, Operacoes operacoes, RespondeCliente respondeCliente, Socket socket) {
        this.operacao = operacao;
        this.operacoes = operacoes;
        this.respondeCliente = respondeCliente;
        this.socket = socket;
    }


    /**
     * Executa.
     *
     * @throws IOException the io exception
     */
    public void executa() throws IOException {
        switch (operacao.getOperation()) {
            case "SAV":
                try {
                    OperacaoResponse responseSav = operacoes.salvarDesenho(operacao.getNome(), operacao.getFiguraList(), operacao.getIp());
                    respondeCliente.enviaDesenho(socket, responseSav);
                } catch (SaveException e) {
                    respondeCliente.enviaDesenho(socket, new OperacaoResponse(null, null, null, null, true));
                }

                break;
            case "CON":
                try {
                    List<OperacaoResponse> responseCon = operacoes.consultarDesenho(operacao.getIp());
                    responseCon.forEach(responseConI -> {
                        try {
                            respondeCliente.enviaDesenho(socket, responseConI);
                        } catch (IOException e) {
                            System.out.println("Erro ao enviar desenhos ao cliente: " + e);
                        }
                    });
                    OperacaoResponse ficOperation = new OperacaoResponse(null, null, null, null, "FIC", false, null);
                    ficOperation.setOperacao("FIC");
                    respondeCliente.enviaDesenho(socket, ficOperation);
                } catch (ConsultarException e) {
                    respondeCliente.enviaDesenho(socket, new OperacaoResponse(null, null, null, null, true));
                }
        }
    }
}
