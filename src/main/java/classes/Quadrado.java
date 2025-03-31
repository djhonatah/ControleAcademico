package classes;

public class Quadrado implements InterfaceMétodosFiguras {

    private final double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    //métodos
    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return lado * 4;
    }

    public double getLado() {
        return lado;
    }
}