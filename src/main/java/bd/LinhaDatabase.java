package bd;

import dev.morphia.annotations.Embedded;

import java.io.Serializable;

@Embedded
public class LinhaDatabase extends FiguraDatabase implements Serializable {

    private static final long serialVersionUID = -6004191062758821870L;
    private String tipo;
    protected PontoDatabase p1, p2;


    public LinhaDatabase(int x1, int y1, int x2, int y2, int cor, String tipo) {
        super(cor);

        this.p1 = new PontoDatabase(x1, y1, cor, "Linha");
        this.p2 = new PontoDatabase(x2, y2, cor, "Linha");
        this.tipo = tipo;
    }

    public LinhaDatabase() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

}