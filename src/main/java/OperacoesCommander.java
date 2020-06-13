import java.net.Socket;
import java.util.List;

public class OperacoesCommander {

    private Operacao operacao;

    private Operacoes operacoes;

    private Teste teste;

    private Socket socket;

    public OperacoesCommander(Operacao operacao, Operacoes operacoes, Teste teste, Socket socket) {
        this.operacao = operacao;
        this.operacoes = operacoes;
        this.teste = teste;
        this.socket = socket;
    }


    public void executa() {
        switch (operacao.getOperation()) {
            case "SAV":
                operacoes.salvarDesenho(operacao.getNome(), operacao.getFiguraList(), operacao.getIp(), operacao.getDataHora());
                break;
            case "CON":
                List<OperacaoResponse> operacaoResponses = operacoes.consultarDesenho(operacao.getIp());
                operacaoResponses.forEach(response -> teste.enviaDesenho("DES", socket, response));
                break;
            case "FIC":
                operacoes.desconectar();
        }
    }
}
