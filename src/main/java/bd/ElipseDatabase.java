package bd;

import java.io.Serializable;

public class ElipseDatabase extends FiguraDatabase implements Serializable {

    private static final long serialVersionUID = 1415037501871152309L;
    protected PontoDatabase p1, p2;
    protected boolean preenchido;
    private String tipo;


    public ElipseDatabase(int x1, int y1, int x2, int y2, int cor, boolean preenchido, String tipo) {
        super(cor);
        this.tipo = tipo;

        this.p1 = new PontoDatabase(x1, y1, cor, "Elipse");
        this.p2 = new PontoDatabase(x2, y2, cor, "Elipse");
        this.preenchido = preenchido;
    }

    public ElipseDatabase() {
    }

    public void setP1(int x, int y) {
        this.p1 = new PontoDatabase(x, y, this.getCor(), tipo);
    }

    public void setP2(int x, int y) {
        this.p2 = new PontoDatabase(x, y, this.getCor(), tipo);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public PontoDatabase getP1() {
        return p1;
    }

    public void setP1(PontoDatabase p1) {
        this.p1 = p1;
    }

    public PontoDatabase getP2() {
        return p2;
    }

    public void setP2(PontoDatabase p2) {
        this.p2 = p2;
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
