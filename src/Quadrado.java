import java.awt.*;
import java.io.Serializable;
import java.util.StringTokenizer;

public class Quadrado extends Figura implements Serializable {

    private static final long serialVersionUID = 9120967549872685645L;
    protected Ponto p1, p2;
    protected boolean preenchido;

    public Quadrado(int x1, int y1, int x2, int y2, boolean preenchido) {
        this(x1, y1, x2, y2, Color.BLACK, preenchido);
    }

    public Quadrado(int x1, int y1, int x2, int y2, Color cor, boolean preenchido) {
        super(cor);

        this.p1 = new Ponto(x1, y1, cor);
        this.p2 = new Ponto(x2, y2, cor);
        this.preenchido = preenchido;
    }

    public Quadrado(String s) {
        StringTokenizer quebrador = new StringTokenizer(s, ":");

        quebrador.nextToken();

        int x1 = Integer.parseInt(quebrador.nextToken());
        int y1 = Integer.parseInt(quebrador.nextToken());

        int x2 = Integer.parseInt(quebrador.nextToken());
        int y2 = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color(Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        boolean isPreenchido = Boolean.parseBoolean(quebrador.nextToken());

        this.p1 = new Ponto(x1, y1, cor);
        this.p2 = new Ponto(x2, y2, cor);
        this.cor = cor;
        this.preenchido = isPreenchido;
    }

    public void setP1(int x, int y) {
        this.p1 = new Ponto(x, y, this.getCor());
    }

    public void setP2(int x, int y) {
        this.p2 = new Ponto(x, y, this.getCor());
    }

    public Ponto getP1() {
        return this.p1;
    }

    public Ponto getP2() {
        return this.p2;
    }

    public boolean isPreenchido() {
        return preenchido;
    }

    public void setPreenchido(boolean preenchido) {
        this.preenchido = preenchido;
    }

    public void torneSeVisivel(Graphics g) {
        int raio = (int) Math.abs(Math.sqrt(Math.pow(this.p2.getX() - this.p1.getX(), 2) + Math.pow(this.p2.getY() - this.p1.getY(), 2)));
        if (!preenchido) {
            g.setColor(cor);
            g.drawRect(
                    Math.abs(this.p2.getX() - raio),
                    Math.abs(this.p2.getY() - raio),
                    2 * raio,
                    2 * raio
            );
        } else {
            g.setColor(cor);
            g.fillRect(
                    Math.abs(this.p2.getX() - raio),
                    Math.abs(this.p2.getY() - raio),
                    2 * raio,
                    2 * raio
            );
        }

    }

    public String toString() {
        return "q:" +
                this.p1.getX() +
                ":" +
                this.p1.getY() +
                ":" +
                this.p2.getX() +
                ":" +
                this.p2.getY() +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue() +
                ":" +
                this.preenchido;
    }
}