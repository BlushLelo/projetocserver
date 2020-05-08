public class OperacoesImpl implements Operacoes {

    @Override
    public void salvarDesenho(String nomeDoDesenho, String ipDoCliente, String dataDeCriacao, String dataDeModificacao, Figura figura) {
        System.out.println("Chamada a implementacao de salvar desenho");
    }

    @Override
    public void consultarDesenho() {
        System.out.println("Chamada a implementacao de consultar desenho");
    }

    @Override
    public void desconectar() {

    }
}
