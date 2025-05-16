package classes.figuras;

import interfaces.Figura;

public class Quadrado implements Figura {
    @Override
    public void desenhar() {
        System.out.println("Desenhando um Quadrado");
    }
}
