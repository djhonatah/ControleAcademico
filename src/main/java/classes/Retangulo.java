package classes;

public class Retangulo implements InterfaceMétodosFiguras {

    public final double altura;
    public final double largura;

    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double area() {
        return altura * largura;
    }

    @Override
    public double perimetro() {
        return 2 * altura + 2 * largura;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }
}
