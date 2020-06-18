import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The type Operacao response.
 */
public class OperacaoResponse implements Serializable {

    private static final long serialVersionUID = -8167573074331114690L;

    private String nomeDoDesenho;

    private String operacao;

    private Date createdDated;

    private Date updatedDate;

    private String ip;

    private boolean error;

    private List<Figura> listaDeFiguras;

    /**
     * Instantiates a new Operacao response.
     */
    public OperacaoResponse() {
    }

    /**
     * Instantiates a new Operacao response.
     *
     * @param nomeDoDesenho  the nome do desenho
     * @param createdDated   the created dated
     * @param updatedDate    the updated date
     * @param listaDeFiguras the lista de figuras
     * @param error          the error
     */
    public OperacaoResponse(String nomeDoDesenho, Date createdDated, Date updatedDate, List<Figura> listaDeFiguras, boolean error) {
        this.nomeDoDesenho = nomeDoDesenho;
        this.createdDated = createdDated;
        this.updatedDate = updatedDate;
        this.listaDeFiguras = listaDeFiguras;
        this.error = error;
    }

    /**
     * Instantiates a new Operacao response.
     *
     * @param nomeDoDesenho  the nome do desenho
     * @param createdDated   the created dated
     * @param updatedDate    the updated date
     * @param listaDeFiguras the lista de figuras
     * @param operacao       the operacao
     * @param error          the error
     * @param ip             the ip
     */
    public OperacaoResponse(String nomeDoDesenho, Date createdDated, Date updatedDate, List<Figura> listaDeFiguras, String operacao, boolean error, String ip) {
        this.nomeDoDesenho = nomeDoDesenho;
        this.createdDated = createdDated;
        this.updatedDate = updatedDate;
        this.listaDeFiguras = listaDeFiguras;
        this.operacao = operacao;
        this.error = error;
        this.ip = ip;
    }

    /**
     * Instantiates a new Operacao response.
     *
     * @param operacao     the operacao
     * @param createdDated the created dated
     * @param updatedDate  the updated date
     */
    public OperacaoResponse(String operacao, Date createdDated, Date updatedDate) {
        this.operacao = operacao;
        this.createdDated = createdDated;
        this.updatedDate = updatedDate;
    }

    /**
     * Gets nome do desenho.
     *
     * @return the nome do desenho
     */
    public String getNomeDoDesenho() {
        return nomeDoDesenho;
    }

    /**
     * Sets nome do desenho.
     *
     * @param nomeDoDesenho the nome do desenho
     */
    public void setNomeDoDesenho(String nomeDoDesenho) {
        this.nomeDoDesenho = nomeDoDesenho;
    }

    /**
     * Gets lista de figuras.
     *
     * @return the lista de figuras
     */
    public List<Figura> getListaDeFiguras() {
        return listaDeFiguras;
    }

    /**
     * Sets lista de figuras.
     *
     * @param listaDeFiguras the lista de figuras
     */
    public void setListaDeFiguras(List<Figura> listaDeFiguras) {
        this.listaDeFiguras = listaDeFiguras;
    }

    /**
     * Gets operacao.
     *
     * @return the operacao
     */
    public String getOperacao() {
        return operacao;
    }

    /**
     * Sets operacao.
     *
     * @param operacao the operacao
     */
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    /**
     * Gets created dated.
     *
     * @return the created dated
     */
    public Date getCreatedDated() {
        return createdDated;
    }

    /**
     * Sets created dated.
     *
     * @param createdDated the created dated
     */
    public void setCreatedDated(Date createdDated) {
        this.createdDated = createdDated;
    }

    /**
     * Gets updated date.
     *
     * @return the updated date
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * Sets updated date.
     *
     * @param updatedDate the updated date
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * Gets ip.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets ip.
     *
     * @param ip the ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Is error boolean.
     *
     * @return the boolean
     */
    public boolean isError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(boolean error) {
        this.error = error;
    }
}
