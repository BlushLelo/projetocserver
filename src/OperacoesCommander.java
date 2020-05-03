public class OperacoesCommander {

    private Operacao operacao;

    private Operacoes operacoes;

    public OperacoesCommander(Operacao operacao, Operacoes operacoes) {
        this.operacao = operacao;
        this.operacoes = operacoes;
    }


    public void executa() {
        switch (operacao.getOperation()) {
            case 1:
                operacoes.salvarDesenho(null, null, null, null, null);
                break;
            case 2:
                operacoes.consultarDesenho();
                break;
            case 3:
                operacoes.selecionarDesenhoNoServer();
        }
    }
}
