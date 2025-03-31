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
    public void perimetro(){
        assertEquals(30.0,figura.perimetro(),0.0);
    }

    @Test
    public void area(){
        assertEquals(50.0,figura.area(),0.0);
    }

    @Test
    public void altura(){
        assertEquals(5.0,figura.getAltura(),0.0);
    }

    @Test
    public void largura(){
        assertEquals(10.0,figura.getLargura(),0.0);
    }
}
