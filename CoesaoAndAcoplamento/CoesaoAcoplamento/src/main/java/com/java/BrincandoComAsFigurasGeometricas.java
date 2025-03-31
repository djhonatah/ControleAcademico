package com.java;

import Excecoes.FiguraDesconhecida;
import classes.FigurasGeometricas;

public class BrincandoComAsFigurasGeometricas {

	public static void main(String[] args) {

        try {
            FigurasGeometricas figura = new FigurasGeometricas(8, 2, 5, 12);

            System.out.println("Perimetro de figuras geomêtricas:");
            double perimetro;
            perimetro = figura.perimetro(FigurasGeometricas.RETANGULO);
            System.out.println("Retângulo: "+perimetro);
            perimetro = figura.perimetro(FigurasGeometricas.CIRCULO);
            System.out.println("Circulo: "+perimetro+"\n");
            
            System.out.println("Informações de figuras geomêtricas:");
            System.out.print(figura.toStringDaFigura(FigurasGeometricas.CIRCULO));
            System.out.print(figura.toStringDaFigura(FigurasGeometricas.QUADRADO));            
            System.out.println(figura.toStringDaFigura(FigurasGeometricas.RETANGULO)+"\n");
            
            //Print das informações de todas as figuras
            //System.out.println(figura.toStringDaFigura(FigurasGeometricas.TODOS));            
            

            System.out.println("Exceções lançadas para figuras inexistentes/inválidas:");
            //Lança exceção - Figura 'Todos'        
            System.out.println(figura.area(0));
            
            //Lança exceção = Figura inválida
            perimetro = figura.perimetro(-5);
            System.out.println(perimetro);
        }
        catch (FiguraDesconhecida e) {
            System.out.println(e.getMessage());
        }
    }

}