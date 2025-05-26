package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Interface.FiguraGeometrica;
import com.Interface.Visitante;
import com.classes.Circulo;
import com.classes.Retangulo;
import com.classes.Trapezio;
import com.classes.Triangulo;
import com.excecoes.FiguraInvalidaException;
import com.visitors.AreaVisitor;
import com.visitors.DesenharVisitor;
import com.visitors.MaximizarVisitor;
import com.visitors.PerimetroVisitor;

public class Main {
    public static void main(String[] args) {
        List<FiguraGeometrica> figuras = new ArrayList<>();

        try {
            figuras.add(new Circulo(5));
        } catch (FiguraInvalidaException e) {
            System.err.println("Erro ao criar Círculo: " + e.getMessage());
        }

        try {
            figuras.add(new Triangulo(4, 3, 5, 6));
        } catch (FiguraInvalidaException e) {
            System.err.println("Erro ao criar Triângulo: " + e.getMessage());
        }

        try {
            figuras.add(new Retangulo(3, 7));
        } catch (FiguraInvalidaException e) {
            System.err.println("Erro ao criar Retângulo: " + e.getMessage());
        }

        try {
            figuras.add(new Trapezio(8, 4, 3, 5, 5));
        } catch (FiguraInvalidaException e) {
            System.err.println("Erro ao criar Trapézio: " + e.getMessage());
        }

        List<Visitante> visitantes = Arrays.asList(
            new DesenharVisitor(),
            new AreaVisitor(),
            new PerimetroVisitor(),
            new MaximizarVisitor()
        );

        for (Visitante visitante : visitantes) {
            System.out.println("\n--- Aplicando " + visitante.getClass().getSimpleName() + " ---");
            for (FiguraGeometrica figura : figuras) {
                try {
                    figura.aceitar(visitante);
                } catch (Exception e) {
                    System.err.println("Erro ao aplicar visitante: " + e.getMessage());
                }
            }
        }
    }
}
