import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Circulo;

public class TesteCirculo {
    private Circulo figura;

    @BeforeEach
    public void setUp(){
        this.figura = new Circulo(3);
    }

    @Test
    public double areaTest(){
        assertEquals(28.2735,this.figura.area(),0.1);
        return figura.area();
    }

    @Test
    public double perimetroTest(){
        assertEquals(18.849,figura.perimetro(),0.1);
        return figura.perimetro();
    }

    @Test
    public double raioTest(){
        assertEquals(3.0,figura.getRaio(),0);
        return figura.getRaio();
    }
}
