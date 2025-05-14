package fabrica;

import figuras.*;

public class FabricaFiguras {

    private static FabricaFiguras instancia;
    private Circulo circulo;
    private TrianguloIsosceles isosceles;
    private TrianguloEquilatero equilatero;
    private TrianguloRetangulo retangulo;

    private FabricaFiguras() {
    }

    public static FabricaFiguras getInstancia() {
        //Dupla checagem para garantir SEGURANÇA e EFICIÊNCIA **APENAS MÉTODOS ESTATICOS**
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
        }
        return circulo;
    }

    public Figura CreateTrianguloIsosceles() {
        if (isosceles == null) {
            isosceles = new TrianguloIsosceles();
        }
        return isosceles;
    }

    public Figura CreateTrianguloEquilatero() {
        if (equilatero == null) {
            equilatero = new TrianguloEquilatero();
        }
        return equilatero;
    }

    public Figura CreateTrianguloRetangulo() {
        if (retangulo == null) {
            retangulo = new TrianguloRetangulo();
        }
        return retangulo;
    }

    public Figura CreateQuadrado() {
        return new Quadrado();
    }
}
