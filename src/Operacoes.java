public interface Operacoes {

    void salvarDesenho(String nomeDoDesenho, String ipDoCliente, String dataDeCriacao, String dataDeModificacao, Figura figura);

    void consultarDesenho();

    void selecionarDesenhoNoServer();

}
