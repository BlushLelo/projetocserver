package bd;

import java.io.Serializable;

public class TextoDatabase extends FiguraDatabase implements Serializable {
    private static final long serialVersionUID = 6548308103191019816L;

    protected int x, y;
    protected String textoDigitado;
    protected String fontName;
    protected int fontSize;
    protected int fontStyle;

    public TextoDatabase() {
    }

    public TextoDatabase(int x, int y, String texto, String fontName, int fontSize, int fontStyle, int cor) {
        super(cor);
        this.x = x;
        this.y = y;
        this.textoDigitado = texto;
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.fontStyle = fontStyle;
        this.cor = cor;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {

        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getTextoDigitado() {
        return textoDigitado;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    public void setTextoDigitado(String textoDigitado) {
        this.textoDigitado = textoDigitado;
    }
}