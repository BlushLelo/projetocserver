package bd;

import dev.morphia.annotations.Embedded;

import java.io.Serializable;

@Embedded
public class QuadradoDatabase extends FiguraDatabase implements Serializable {

    private String tipo;
    private static final long serialVersionUID = 9120967549872685645L;
    protected PontoDatabase p1, p2;
    protected boolean preenchido;

    public QuadradoDatabase(String tipo, int x1, int y1, int x2, int y2, int cor, boolean preenchido) {
        super(cor);
        this.tipo = tipo;

        this.p1 = new PontoDatabase(x1, y1, cor, tipo);
        this.p2 = new PontoDatabase(x2, y2, cor, tipo);
        this.preenchido = preenchido;
    }

    public QuadradoDatabase() {
    }

    public void setP1(int x, int y) {
        this.p1 = new PontoDatabase(x, y, this.getCor(), tipo);
    }

    public void setP2(int x, int y) {
        this.p2 = new PontoDatabase(x, y, this.getCor(), tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PontoDatabase getP1() {
        return this.p1;
    }

    public PontoDatabase getP2() {
        return this.p2;
    }

    public boolean isPreenchido() {
        return preenchido;
    }

    public void setPreenchido(boolean preenchido) {
        this.preenchido = preenchido;
    }
}