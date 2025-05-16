package classes.fabrica;

import classes.figuras.Circulo;
import classes.figuras.Quadrado;
import classes.figuras.TrianguloEquilatero;
import classes.figuras.TrianguloIsosceles;
import classes.figuras.TrianguloRetangulo;
import excecoes.FiguraJaCriadaException;
import interfaces.Figura;

public class FabricaFiguras {

    private static FabricaFiguras instancia;
    private Circulo circulo;
    private TrianguloIsosceles isosceles;
    private TrianguloEquilatero equilatero;
    private TrianguloRetangulo retangulo;

    private FabricaFiguras() {
    }

    public static FabricaFiguras getInstancia() {
        synchronized (FabricaFiguras.class) {
            if (instancia == null) {
                instancia = new FabricaFiguras();
            }
        }
        return instancia;
    }

    public Figura CreateCirculo() {
        if (circulo == null) {
            circulo = new Circulo();
            return circulo;
        } else {
            throw new FiguraJaCriadaException("Círculo");
        }
    }

    public Figura CreateTrianguloIsosceles() {
        if (isosceles == null) {
            isosceles = new TrianguloIsosceles();
            return isosceles;
        } else {
            throw new FiguraJaCriadaException("Triângulo Isósceles");
        }
    }

    public Figura CreateTrianguloEquilatero() {
        if (equilatero == null) {
            equilatero = new TrianguloEquilatero();
            return equilatero;
        } else {
            throw new FiguraJaCriadaException("Triângulo Equilátero");
        }
    }

    public Figura CreateTrianguloRetangulo() {
        if (retangulo == null) {
            retangulo = new TrianguloRetangulo();
            return retangulo;
        } else {
            throw new FiguraJaCriadaException("Triângulo Retângulo");
        }
    }

    public Figura CreateQuadrado() {
        return new Quadrado(); // Quadrado pode ser criado sempre
    }
}
