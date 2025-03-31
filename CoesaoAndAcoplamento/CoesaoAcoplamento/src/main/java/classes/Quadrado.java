package classes;

public class Quadrado implements InterfaceMétodosFiguras {

    private final double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    //métodos
    @Override
    public double area() {
        if (lado < 0) {
            throw new IllegalArgumentException("O lado do quadrado não pode ser negativo.");
        }
        return lado * lado;
    }

    @Override
    public double perimetro() {
        if (lado < 0) {
            throw new IllegalArgumentException("O lado do quadrado não pode ser negativo.");
        }
        return lado * 4;
    }


    public double getLado() {
        return lado;
    }
}