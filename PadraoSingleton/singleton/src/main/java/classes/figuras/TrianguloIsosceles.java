package classes.figuras;

import interfaces.Figura;

public class TrianguloIsosceles implements Figura {
    @Override
    public void desenhar() {
        System.out.println("Desenhando um Triângulo Isósceles");
    }
}
