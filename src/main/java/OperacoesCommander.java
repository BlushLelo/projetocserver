import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import java.util.List;

public class OperacoesCommander {

    private Operacao operacao;

    private Operacoes operacoes;

    private RespondeCliente respondeCliente;

    private Socket socket;

    public OperacoesCommander(Operacao operacao, Operacoes operacoes, RespondeCliente respondeCliente, Socket socket) {
        this.operacao = operacao;
        this.operacoes = operacoes;
        this.respondeCliente = respondeCliente;
        this.socket = socket;
    }


    public void executa() throws IOException {
        switch (operacao.getOperation()) {
            case "SAV":
                operacoes.salvarDesenho(operacao.getNome(), operacao.getFiguraList(), operacao.getIp(), operacao.getDataHora());
                break;
            case "CON":
                List<OperacaoResponse> operacaoResponses = operacoes.consultarDesenho(operacao.getIp());
                operacaoResponses.forEach(response -> {
                    try {
                        response.setOperacao("DES");
                        respondeCliente.enviaDesenho(socket, response);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                });
                OperacaoResponse ficOperation = new OperacaoResponse("Nenhum desenho salvo", Collections.emptyList());
                ficOperation.setOperacao("FIC");
                respondeCliente.enviaDesenho(socket, ficOperation);
                break;
            case "FIC":
                operacoes.desconectar();
        }
    }
}
