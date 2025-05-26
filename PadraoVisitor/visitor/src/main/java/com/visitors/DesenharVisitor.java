package com.visitors;

import com.Interface.Visitante;
import com.classes.Circulo;
import com.classes.Retangulo;
import com.classes.Trapezio;
import com.classes.Triangulo;

public class DesenharVisitor implements Visitante {
    
    @Override
    public void visitar(Circulo c) {
        System.out.println("Desenhando Círculo com raio " + c.getRaio());
    }

    @Override
    public void visitar(Triangulo t) {
        System.out.println("Desenhando Triângulo com base " + t.getBase() + " e altura " + t.getAltura() );
    }

    @Override
    public void visitar(Retangulo r) {
        System.out.println("Desenhando Retângulo com base " + r.getBase() + " e altura " + r.getAltura());
    }

    @Override
    public void visitar(Trapezio t) {
        System.out.println("Desenhando Trapézio com bases " + t.getBaseMaior() + " e " + t.getBaseMenor());
    }
}
