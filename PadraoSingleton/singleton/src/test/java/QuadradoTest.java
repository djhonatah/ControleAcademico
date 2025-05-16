import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.fabrica.FabricaFiguras;
import classes.figuras.Quadrado;
import interfaces.Figura;


public class QuadradoTest {
    FabricaFiguras fabrica;

    @BeforeEach
    public void setUp() {
        fabrica = FabricaFiguras.getInstancia();
    }

    @Test
    public void testInstanciaQuadrado() {
        Figura quadrado = fabrica.CreateQuadrado();
        assertNotNull(quadrado);
        assertTrue(quadrado instanceof Quadrado);
    }

    @Test
    public void testDesenharQuadrado() {
        Figura quadrado = fabrica.CreateQuadrado();
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));

        quadrado.desenhar();

        System.setOut(System.out);

        assertEquals("Desenhando um Quadrado", saida.toString().trim());

    }
}