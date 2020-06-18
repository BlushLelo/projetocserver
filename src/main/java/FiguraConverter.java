import bd.*;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The type Figura converter.
 */
public class FiguraConverter {


    /**
     * Converter figura database.
     * Realizamos a conversao dos objetos que recebemos do client para nossas entidades que serao salvas no banco de dados.
     *
     * @param figura the figura
     * @return the figura database
     */
    public static FiguraDatabase converter(Figura figura) {
        if (figura instanceof Retangulo) {
            Ponto p1 = ((Retangulo) figura).getP1();
            Ponto p2 = ((Retangulo) figura).getP2();
            boolean preenchido = ((Retangulo) figura).isPreenchido();
            int rgb = figura.getCor().getRGB();
            return new RetanguloDatabase("Retangulo", p1.getX(), p1.getY(), p2.getX(), p2.getY(), rgb, preenchido);
        } else if (figura instanceof Quadrado) {
            Ponto p1 = ((Quadrado) figura).getP1();
            Ponto p2 = ((Quadrado) figura).getP2();
            int rgb = figura.getCor().getRGB();
            boolean preenchido = ((Quadrado) figura).isPreenchido();
            return new QuadradoDatabase("Quadrado", p1.getX(), p1.getY(), p2.getX(), p2.getY(), rgb, preenchido);
        } else if (figura instanceof Ponto) {
            int rgb = figura.getCor().getRGB();
            return new PontoDatabase(((Ponto) figura).getX(), ((Ponto) figura).getY(), rgb, "Ponto");
        } else if (figura instanceof Poligono) {
            List<PontoDatabase> pontoDataBase = ((Poligono) figura).getPontosDoPol().stream().map(ponto -> new PontoDatabase(ponto.getX(), ponto.getY(), ponto.getCor().getRGB(), "Ponto")).collect(Collectors.toList());
            int rgb = figura.getCor().getRGB();
            boolean preenchido = ((Poligono) figura).isPreenchido();
            return new PoligonoDatabase(pontoDataBase, rgb, "Poligono", preenchido);
        } else if (figura instanceof Linha) {
            Ponto p1 = ((Linha) figura).getP1();
            Ponto p2 = ((Linha) figura).getP2();
            int cor = figura.getCor().getRGB();
            return new LinhaDatabase(p1.getX(), p1.getY(), p2.getX(), p2.getY(), cor, "Linha");
        } else if (figura instanceof Elipse) {
            Ponto p1 = ((Elipse) figura).getP1();
            Ponto p2 = ((Elipse) figura).getP2();
            int rgb = figura.getCor().getRGB();
            boolean preenchido = ((Elipse) figura).isPreenchido();
            return new ElipseDatabase(p1.getX(), p1.getY(), p2.getX(), p2.getY(), rgb, preenchido, "Elipse");
        } else if (figura instanceof Circulo) {
            Ponto p1 = ((Circulo) figura).getP1();
            Ponto p2 = ((Circulo) figura).getP2();
            int rgb = figura.getCor().getRGB();
            boolean preenchido = ((Circulo) figura).isPreenchido();
            return new CirculoDatabase("Circulo", p1.getX(), p1.getY(), p2.getX(), p2.getY(), rgb, preenchido);
        } else if (figura instanceof Texto) {
            int x = ((Texto) figura).getX();
            int y = ((Texto) figura).getY();
            String textoDigitado = ((Texto) figura).getTextoDigitado();
            Font fontStyle = ((Texto) figura).getFontStyle();
            int rgb = ((Texto) figura).getCor().getRGB();
            return new TextoDatabase(x, y, textoDigitado, fontStyle.getFamily(), fontStyle.getSize(), fontStyle.getStyle(), rgb);
        }
        return null;
    }
}
