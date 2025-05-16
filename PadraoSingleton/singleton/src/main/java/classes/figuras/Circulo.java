package classes.figuras;

import interfaces.Figura;

public class Circulo implements Figura {
    @Override
    public void desenhar() {
        System.out.println("Desenhando um Círculo");
    }
}
