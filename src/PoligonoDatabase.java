import java.io.Serializable;
import java.util.List;

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


}