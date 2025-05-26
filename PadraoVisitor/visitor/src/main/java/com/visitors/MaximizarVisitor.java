package com.visitors;

import com.Interface.Visitante;
import com.classes.Circulo;
import com.classes.Retangulo;
import com.classes.Trapezio;
import com.classes.Triangulo;
import com.excecoes.FiguraInvalidaException;

public class MaximizarVisitor implements Visitante {

    @Override
    public void visitar(Circulo c) {
        try {
            c.setRaio(c.getRaio() * 2);
            System.out.println("Círculo maximizado para raio: " + c.getRaio());
        } catch (FiguraInvalidaException e) {
            System.err.println("Erro ao maximizar Círculo: " + e.getMessage());
        }
    }

    @Override
    public void visitar(Triangulo t) {
        try {
            t.setBase(t.getBase() * 2); 
            t.setAltura(t.getAltura() * 2);
            t.setLado1(t.getLado1() * 2);    
            t.setLado2(t.getLado2() * 2);    
            System.out.println("Triângulo maximizado.");
        } catch (FiguraInvalidaException e) {
            System.err.println("Erro ao maximizar Triângulo: " + e.getMessage());
        }
    }

    @Override
    public void visitar(Retangulo r) {
        try {
            r.setBase(r.getBase() * 2); 
            r.setAltura(r.getAltura() * 2);
            System.out.println("Retângulo maximizado.");
        } catch (FiguraInvalidaException e) {
            System.err.println("Erro ao maximizar Retângulo: " + e.getMessage());
        }
    }

    @Override
    public void visitar(Trapezio t) {
        try {
            t.setBaseMaior(t.getBaseMaior() * 2);
            t.setBaseMenor(t.getBaseMenor() * 2);
            t.setAltura(t.getAltura() * 2);
            t.setLado1(t.getLado1() * 2);
            t.setLado2(t.getLado2() * 2);
            System.out.println("Trapézio maximizado.");
        } catch (FiguraInvalidaException e) {
            System.err.println("Erro ao maximizar Trapézio: " + e.getMessage());
        }
    }
}
