package main;

import fabrica.FabricaFiguras;
import figuras.Figura;

public class Main {
    public static void main(String[] args) {
        FabricaFiguras fabrica = FabricaFiguras.getInstancia();

        Figura circulo1 = fabrica.CreateCirculo();
        Figura triangulo1 = fabrica.CreateTrianguloIsosceles();
        Figura triangulo2 = fabrica.CreateTrianguloEquilatero();
        Figura triangulo3 = fabrica.CreateTrianguloRetangulo();
        Figura quadrado1 = fabrica.CreateQuadrado();
        Figura quadrado2 = fabrica.CreateQuadrado();

        circulo1.desenhar();
        triangulo1.desenhar();
        triangulo2.desenhar();
        triangulo3.desenhar();
        quadrado1.desenhar();
        quadrado2.desenhar();
    }
}
