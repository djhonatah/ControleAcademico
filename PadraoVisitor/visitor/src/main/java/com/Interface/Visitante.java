package com.Interface;

import com.classes.Circulo;
import com.classes.Retangulo;
import com.classes.Trapezio;
import com.classes.Triangulo;

public interface Visitante {
    void visitar(Circulo circulo); 
    void visitar(Triangulo triangulo);
    void visitar(Retangulo retangulo);
    void visitar(Trapezio trapezio); 
}
