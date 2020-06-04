import java.io.Serializable;

public class PontoDatabase extends FiguraDatabase implements Serializable
{

    private String tipo;
    private static final long serialVersionUID = -6192761458213279090L;
    protected int x,  y;

    public PontoDatabase(int x, int y, int cor, String tipo)
    {
        super (cor);

        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    public void setX (int x)
    {
        this.x = x;
    }

    public void setY (int y)
    {
        this.y = y;
    }

    public int getX ()
    {
        return this.x;
    }

    public int getY ()
    {
        return this.y;
    }

}
