package bd;


import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.PrePersist;

import java.util.Date;
import java.util.List;


/**
 * The type D bteste.
 */
@Entity("projetoc")
public class DBteste {

    @Id
    private String nome;
    private String ip;
    private Date creationDate;
    private Date lastChange;
    private List<FiguraDatabase> listaDeFiguras;

    /**
     * Instantiates a new D bteste.
     */
    public DBteste() {
    }

    /**
     * Instantiates a new D bteste.
     *
     * @param ip             the ip
     * @param nome           the nome
     * @param listaDeFiguras the lista de figuras
     */
    public DBteste(String ip, String nome, List<FiguraDatabase> listaDeFiguras) {
        this.ip = ip;
        this.nome = nome;
        this.listaDeFiguras = listaDeFiguras;
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
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Gets lista de figuras.
     *
     * @return the lista de figuras
     */
    public List<FiguraDatabase> getListaDeFiguras() {
        return listaDeFiguras;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * Sets lista de figuras.
     *
     * @param listaDeFiguras the lista de figuras
     */
    public void setListaDeFiguras(List<FiguraDatabase> listaDeFiguras) {
        this.listaDeFiguras = listaDeFiguras;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets last change.
     *
     * @return the last change
     */
    public Date getLastChange() {
        return lastChange;
    }

    /**
     * Sets last change.
     *
     * @param lastChange the last change
     */
    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    /**
     * Pre persist.
     */
    @PrePersist
    public  void prePersist() {
        creationDate = (creationDate == null) ? new Date() : creationDate;
        lastChange = (lastChange == null) ? creationDate : new Date();
    }
}
