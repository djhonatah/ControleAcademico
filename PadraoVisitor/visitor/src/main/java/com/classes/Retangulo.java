package com.classes;

import com.Interface.FiguraGeometrica;
import com.Interface.Visitante;
import com.excecoes.FiguraInvalidaException;

public class Retangulo implements FiguraGeometrica {
    double base;
    double altura;

    public Retangulo(double base, double altura) throws FiguraInvalidaException {
        if (base <= 0 || altura <= 0) {
            throw new FiguraInvalidaException("Base ou altura inválida: base=" + base + ", altura=" + altura);
        }
        this.base = base;
        this.altura = altura;
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
}
