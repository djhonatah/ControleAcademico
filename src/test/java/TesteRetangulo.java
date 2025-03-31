import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Retangulo;

public class TesteRetangulo {
    private Retangulo figura;

    @BeforeEach
    public void setUp(){
        this.figura = new Retangulo(5,10);
    }

    @Test
    public double perimetro(){
        assertEquals(30.0,figura.perimetro(),0.0);
        return figura.perimetro();
    }

    @Test
    public double area(){
        assertEquals(50.0,figura.area(),0.0);
        return figura.area();
    }

    @Test
    public double altura(){
        assertEquals(5.0,figura.getAltura(),0.0);
        return figura.getAltura();
    }

    @Test
    public double largura(){
        assertEquals(10.0,figura.getLargura(),0.0);
        return figura.getLargura();
    }
}
