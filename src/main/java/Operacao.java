import java.io.Serializable;
import java.util.List;


/**
 * The type Operacao.
 */
public class Operacao implements Serializable {

    private static final long serialVersionUID = -2829362307114855733L;
    /**
     * The Ip.
     */
    String ip;
    /**
     * The Nome.
     */
    String nome;

    /**
     * The Operation.
     */
    String operation;
    /**
     * The Figura list.
     */
    List<Figura> figuraList;

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
     * Gets serial version uid.
     *
     * @return the serial version uid
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Gets operation.
     *
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets operation.
     *
     * @param operation the operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Gets figura list.
     *
     * @return the figura list
     */
    public List<Figura> getFiguraList() {
        return figuraList;
    }

    /**
     * Sets figura list.
     *
     * @param figuraList the figura list
     */
    public void setFiguraList(List<Figura> figuraList) {
        this.figuraList = figuraList;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
