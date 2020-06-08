package bd;

import dev.morphia.annotations.Embedded;

import java.io.Serializable;

@Embedded
public class RetanguloDatabase extends FiguraDatabase implements Serializable {
    private String tipo;
    private static final long serialVersionUID = -8492157169123352509L;
    protected PontoDatabase p1, p2;
    protected boolean preenchido;

    public RetanguloDatabase(String tipo, int x1, int y1, int x2, int y2, int cor, boolean preenchido) {
        super(cor);
        this.tipo = tipo;

        this.p1 = new PontoDatabase(x1, y1, cor, tipo);
        this.p2 = new PontoDatabase(x2, y2, cor, tipo);
        this.preenchido = preenchido;
    }

    public RetanguloDatabase() {
    }

    public void setP1(int x, int y) {
        this.p1 = new PontoDatabase(x, y, this.getCor(), tipo);
    }

    public void setP2(int x, int y) {
        this.p2 = new PontoDatabase(x, y, this.getCor(), tipo);
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}