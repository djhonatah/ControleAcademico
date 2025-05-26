package com.classes;

import com.Interface.FiguraGeometrica;
import com.Interface.Visitante;
import com.excecoes.FiguraInvalidaException;

public class Triangulo implements FiguraGeometrica {
    double base;
    double altura;
    double lado1;
    double lado2;

    public Triangulo(double base, double altura, double lado1, double lado2) throws FiguraInvalidaException {
        if (base <= 0 || altura <= 0 || lado1 <= 0 || lado2 <= 0) {
            throw new FiguraInvalidaException("Dimensões inválidas para triângulo.");
        }
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setBase(double base) throws FiguraInvalidaException {
        if (base <= 0) {
            throw new FiguraInvalidaException("Base inválida: " + base);
        }
        this.base = base;
    }

    public void setAltura(double altura) throws FiguraInvalidaException {
        if (altura <= 0) {
            throw new FiguraInvalidaException("Altura inválida: " + altura);
        }
        this.altura = altura;
    }

    public void setLado1(double lado1) throws FiguraInvalidaException {
        if (lado1 <= 0) {
            throw new FiguraInvalidaException("Lado1 inválido: " + lado1);
        }
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) throws FiguraInvalidaException {
        if (lado2 <= 0) {
            throw new FiguraInvalidaException("Lado2 inválido: " + lado2);
        }
        this.lado2 = lado2;
    }
}
