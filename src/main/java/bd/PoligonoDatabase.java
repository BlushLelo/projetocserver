package bd;

import dev.morphia.annotations.Embedded;

import java.io.Serializable;
import java.util.List;

@Embedded
public class PoligonoDatabase extends FiguraDatabase implements Serializable {

    private static final long serialVersionUID = 4973656244032944210L;
    private String tipo;
    protected List<PontoDatabase> pontosDoPol;
    protected boolean preenchido;

    public PoligonoDatabase(List<PontoDatabase> pontos, int cor, String tipo, boolean preenchido) {
        super(cor);
        this.pontosDoPol = pontos;
        this.tipo = tipo;
        this.preenchido = preenchido;
    }

    public PoligonoDatabase() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<PontoDatabase> getPontosDoPol() {
        return pontosDoPol;
    }

    public void setPontosDoPol(List<PontoDatabase> pontosDoPol) {
        this.pontosDoPol = pontosDoPol;
    }

    public boolean isPreenchido() {
        return preenchido;
    }

    public void setPreenchido(boolean preenchido) {
        this.preenchido = preenchido;
    }
}