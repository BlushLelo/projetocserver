public class OperacoesCommander {

    private Operacao operacao;

    private Operacoes operacoes;

    public OperacoesCommander(Operacao operacao, Operacoes operacoes) {
        this.operacao = operacao;
        this.operacoes = operacoes;
    }


    public void executa() {
        switch (operacao.getOperation()) {
            case "SAV":
                operacoes.salvarDesenho(null, null, null, null, null);
                break;
            case "CON":
                operacoes.consultarDesenho();
                break;
            case "FIC":
                operacoes.desconectar();
        }
    }
}
