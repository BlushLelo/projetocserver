package bd;

import dev.morphia.annotations.Embedded;

import java.io.Serializable;

@Embedded
public abstract class FiguraDatabase implements Serializable {

    private static final long serialVersionUID = -1449450329337496159L;

    protected int cor;

    public FiguraDatabase() {
    }

    protected FiguraDatabase(int cor) {
        this.cor = cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public int getCor() {
        return this.cor;
    }
}
