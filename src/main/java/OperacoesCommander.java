import exception.ConsultarException;
import exception.SaveException;

import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import java.util.Date;
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
                try {
                    OperacaoResponse responseSav = operacoes.salvarDesenho(operacao.getNome(), operacao.getFiguraList(), operacao.getIp(), operacao.getDataHora());
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
                    OperacaoResponse ficOperation = new OperacaoResponse("Nenhum desenho salvo", new Date(), new Date(), Collections.emptyList(), false);
                    ficOperation.setOperacao("FIC");
                    respondeCliente.enviaDesenho(socket, ficOperation);
                } catch (ConsultarException e) {
                    respondeCliente.enviaDesenho(socket, new OperacaoResponse(null, null, null, null, true));
                }
                break;
            case "FIC":
                operacoes.desconectar();
        }
    }
}
