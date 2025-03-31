package classes;

public class Circulo implements InterfaceMétodosFiguras {

    public final double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        if (raio < 0) {
            throw new IllegalArgumentException("O raio não pode ser negativo.");
        }
        return Math.PI * raio * raio;
    }

    @Override
    public double perimetro() {
        if (raio < 0) {
            throw new IllegalArgumentException("O raio não pode ser negativo.");
        }
        return 2 * Math.PI * raio;
    }


    public double getRaio() {
        return raio;
    }
}
