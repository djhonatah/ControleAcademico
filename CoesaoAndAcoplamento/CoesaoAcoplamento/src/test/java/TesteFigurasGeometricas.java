import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Excecoes.FiguraDesconhecida;
import classes.FigurasGeometricas;

public class TesteFigurasGeometricas {
    private FigurasGeometricas figura;

    @BeforeEach
    public void setUp(){
        this.figura = new FigurasGeometricas(20, 7, 12, 32);
    }

    @Test
    public void perimetroDoRetanguloTest() throws FiguraDesconhecida {
        assertEquals(54.0,figura.perimetro(3),0.0);
    }

    @Test
    public void perimetroDoQuadradoTest() throws FiguraDesconhecida {
        assertEquals(48.0,figura.perimetro(2),0.0);
    }

    @Test
    public void perimetroDoCirculoTest() throws FiguraDesconhecida {
        assertEquals(201.0,figura.perimetro(1),0.1);
    }

    // @Test
    // public double figuraInexistentePerimetroTest() throws FiguraDesconhecida {
    //     assertEquals(54.0,figura.perimetro(0),0.0);
    //     return figura.perimetro(0);
    // }

    @Test
    public void areaDoRetanguloTest() throws FiguraDesconhecida {
        assertEquals(140.0,figura.area(FigurasGeometricas.RETANGULO),0.0);
    }

    @Test
    public void areaDoQuadradoTest() throws FiguraDesconhecida {
        assertEquals(144.0,figura.area(FigurasGeometricas.QUADRADO),0.0);
    }

    @Test
    public void areaDoCirculo() throws FiguraDesconhecida {
        assertEquals(3216.9,figura.area(FigurasGeometricas.CIRCULO),0.1);
    }
}
