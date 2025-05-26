package com.visitors;

import com.Interface.Visitante;
import com.classes.Circulo;
import com.classes.Retangulo;
import com.classes.Trapezio;
import com.classes.Triangulo;
import com.excecoes.ValorInvalidoException;

public class PerimetroVisitor implements Visitante {

    @Override
    public void visitar(Circulo c) {
        try {
            if (c.getRaio() <= 0) {
                throw new ValorInvalidoException("Raio inválido para calcular perímetro: " + c.getRaio());
            }
            double perimetro = 2 * Math.PI * c.getRaio();
            System.out.println("Perímetro do Círculo: " + perimetro);
        } catch (ValorInvalidoException e) {
            System.err.println("Erro ao calcular perímetro do círculo: " + e.getMessage());
        }
    }

    @Override
    public void visitar(Triangulo t) {
        try {
            if (t.getBase() <= 0 || t.getLado1() <= 0 || t.getLado2() <= 0) {
                throw new ValorInvalidoException("Base ou lados inválidos para calcular perímetro do triângulo.");
            }
            double perimetro = t.getBase() + t.getLado1() + t.getLado2();
            System.out.println("Perímetro do Triângulo: " + perimetro);
        } catch (ValorInvalidoException e) {
            System.err.println("Erro ao calcular perímetro do triângulo: " + e.getMessage());
        }
    }

    @Override
    public void visitar(Retangulo r) {
        try {
            if (r.getBase() <= 0 || r.getAltura() <= 0) {
                throw new ValorInvalidoException("Base ou altura inválida para calcular perímetro do retângulo.");
            }
            double perimetro = 2 * (r.getBase() + r.getAltura());
            System.out.println("Perímetro do Retângulo: " + perimetro);
        } catch (ValorInvalidoException e) {
            System.err.println("Erro ao calcular perímetro do retângulo: " + e.getMessage());
        }
    }

    @Override
    public void visitar(Trapezio t) {
        try {
            if (t.getBaseMaior() <= 0 || t.getBaseMenor() <= 0 || t.getLado1() <= 0 || t.getLado2() <= 0) {
                throw new ValorInvalidoException("Bases ou lados inválidos para calcular perímetro do trapézio.");
            }
            double perimetro = t.getBaseMaior() + t.getBaseMenor() + t.getLado1() + t.getLado2();
            System.out.println("Perímetro do Trapézio: " + perimetro);
        } catch (ValorInvalidoException e) {
            System.err.println("Erro ao calcular perímetro do trapézio: " + e.getMessage());
        }
    }
}
