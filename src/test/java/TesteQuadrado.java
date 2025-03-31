import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Quadrado;

public class TesteQuadrado {

    private Quadrado figura;

    @BeforeEach
    public void setUp(){
        this.figura = new Quadrado(8);
    }

    @Test
    public double area(){
        assertEquals(64.0,figura.area(),0.0);
        return figura.area();
    }

    @Test
    public double perimetro(){
        assertEquals(32.0,figura.perimetro(),0.0);
        return figura.perimetro();
    }

    @Test
    public double lado(){
        assertEquals(8.0,figura.getLado(),0.0);
        return figura.getLado();
    }
}
