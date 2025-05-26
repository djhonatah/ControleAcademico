package com.visitors;

import com.Interface.Visitante;
import com.classes.Circulo;
import com.classes.Retangulo;
import com.classes.Trapezio;
import com.classes.Triangulo;
import com.excecoes.ValorInvalidoException;

public class AreaVisitor implements Visitante {

    @Override
    public void visitar(Circulo c) {
        try {
            if (c.getRaio() <= 0) {
                throw new ValorInvalidoException("Raio inválido: " + c.getRaio());
            }
            double area = Math.PI * c.getRaio() * c.getRaio();
            System.out.println("Área do Círculo: " + area);
        } catch (ValorInvalidoException e) {
            System.err.println("Erro ao calcular área do círculo: " + e.getMessage());
        }
    }

    @Override
    public void visitar(Triangulo t) {
        try {
            if (t.getBase() <= 0 || t.getAltura() <= 0) {
                throw new ValorInvalidoException("Base ou altura inválida no triângulo.");
            }
            double area = (t.getBase() * t.getAltura()) / 2;
            System.out.println("Área do Triângulo: " + area);
        } catch (ValorInvalidoException e) {
            System.err.println("Erro ao calcular área do triângulo: " + e.getMessage());
        }
    }

    @Override
    public void visitar(Retangulo r) {
        try {
            if (r.getBase() <= 0 || r.getAltura() <= 0) {
                throw new ValorInvalidoException("Base ou altura inválida no retângulo.");
            }
            double area = r.getBase() * r.getAltura();
            System.out.println("Área do Retângulo: " + area);
        } catch (ValorInvalidoException e) {
            System.err.println("Erro ao calcular área do retângulo: " + e.getMessage());
        }
    }

    @Override
    public void visitar(Trapezio t) {
        try {
            if (t.getBaseMaior() <= 0 || t.getBaseMenor() <= 0 || t.getAltura() <= 0) {
                throw new ValorInvalidoException("Base maior, base menor ou altura inválida no trapézio.");
            }
            double area = ((t.getBaseMaior() + t.getBaseMenor()) * t.getAltura()) / 2;
            System.out.println("Área do Trapézio: " + area);
        } catch (ValorInvalidoException e) {
            System.err.println("Erro ao calcular área do trapézio: " + e.getMessage());
        }
    }
}