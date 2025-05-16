package main;

import classes.fabrica.FabricaFiguras;
import interfaces.Figura;

public class Main {
    public static void main(String[] args) {

        try {
            FabricaFiguras fabrica = FabricaFiguras.getInstancia();
            Figura circulo1 = fabrica.CreateCirculo();
            Figura trianguloIsosceles1 = fabrica.CreateTrianguloIsosceles();
            Figura trianguloEquilatero1 = fabrica.CreateTrianguloEquilatero();
            Figura trianguloRetangulo1 = fabrica.CreateTrianguloRetangulo();
            Figura quadrado1 = fabrica.CreateQuadrado();
            Figura quadrado2 = fabrica.CreateQuadrado();
            
            circulo1.desenhar();
            trianguloIsosceles1.desenhar();
            trianguloEquilatero1.desenhar();
            trianguloRetangulo1.desenhar();
            quadrado1.desenhar();
            quadrado2.desenhar();
            
            // Chamada de exceção - figura diferente do quadrado 
            // Figura circulo2 = fabrica.CreateCirculo();
            // circulo2.desenhar();
            // Figura trianguloIsosceles2 = fabrica.CreateTrianguloIsosceles();
            // trianguloIsosceles2.desenhar();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
