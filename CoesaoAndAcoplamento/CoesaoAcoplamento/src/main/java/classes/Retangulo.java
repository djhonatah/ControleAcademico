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
        if (altura < 0 || largura < 0) {
            throw new IllegalArgumentException("A altura e a largura do retângulo não podem ser negativas.");
        }
        return altura * largura;
    }

    @Override
    public double perimetro() {
        if (altura < 0 || largura < 0) {
            throw new IllegalArgumentException("A altura e a largura do retângulo não podem ser negativas.");
        }
        return 2 * (altura + largura);
    }


    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }
}
