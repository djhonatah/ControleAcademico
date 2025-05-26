package com.classes;

import com.Interface.FiguraGeometrica;
import com.Interface.Visitante;
import com.excecoes.FiguraInvalidaException;

public class Trapezio implements FiguraGeometrica {
    double baseMaior;
    double baseMenor;
    double altura;
    double lado1;
    double lado2;

    public Trapezio(double baseMaior, double baseMenor, double altura, double lado1, double lado2) throws FiguraInvalidaException {
        if (baseMaior <= 0 || baseMenor <= 0 || altura <= 0 || lado1 <= 0 || lado2 <= 0) {
            throw new FiguraInvalidaException("Dimensões inválidas para trapézio.");
        }
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }

    public double getBaseMaior() {
        return baseMaior;
    }

    public double getBaseMenor() {
        return baseMenor;
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

    public void setBaseMaior(double baseMaior) throws FiguraInvalidaException {
        if (baseMaior <= 0) {
            throw new FiguraInvalidaException("Base maior inválida: " + baseMaior);
        }
        this.baseMaior = baseMaior;
    }

    public void setBaseMenor(double baseMenor) throws FiguraInvalidaException {
        if (baseMenor <= 0) {
            throw new FiguraInvalidaException("Base menor inválida: " + baseMenor);
        }
        this.baseMenor = baseMenor;
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
