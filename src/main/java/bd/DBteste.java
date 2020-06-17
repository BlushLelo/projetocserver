package bd;


import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.PrePersist;

import java.util.Date;
import java.util.List;


@Entity("projetoc")
public class DBteste {

    @Id
    private String nome;
    private String ip;
    private Date creationDate;
    private Date lastChange;
    private List<FiguraDatabase> listaDeFiguras;

    public DBteste() {
    }

    public DBteste(String ip, String nome, List<FiguraDatabase> listaDeFiguras) {
        this.ip = ip;
        this.nome = nome;
        this.listaDeFiguras = listaDeFiguras;
    }

    public String getIp() {
        return ip;
    }

    public String getNome() {
        return nome;
    }

    public List<FiguraDatabase> getListaDeFiguras() {
        return listaDeFiguras;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setListaDeFiguras(List<FiguraDatabase> listaDeFiguras) {
        this.listaDeFiguras = listaDeFiguras;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    @PrePersist
    public  void prePersist() {
        creationDate = (creationDate == null) ? new Date() : creationDate;
        lastChange = (lastChange == null) ? creationDate : new Date();
    }
}
