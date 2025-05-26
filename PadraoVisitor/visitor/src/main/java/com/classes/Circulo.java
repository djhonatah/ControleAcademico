package com.classes;

import com.Interface.FiguraGeometrica;
import com.Interface.Visitante;
import com.excecoes.FiguraInvalidaException;

public class Circulo implements FiguraGeometrica {
    double raio;

    public Circulo(double raio) throws FiguraInvalidaException {
        if (raio <= 0) {
            throw new FiguraInvalidaException("Raio inválido: " + raio);
        }
        this.raio = raio;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) throws FiguraInvalidaException {
        if (raio <= 0) {
            throw new FiguraInvalidaException("Raio inválido: " + raio);
        }
        this.raio = raio;
    }
}
