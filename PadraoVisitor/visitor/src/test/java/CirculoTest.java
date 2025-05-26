

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.classes.Circulo;
import com.excecoes.FiguraInvalidaException;

public class CirculoTest {

    @Test
    public void testCriarCirculoValido() {
        assertDoesNotThrow(() -> {
            Circulo c = new Circulo(5);
            assertEquals(5, c.getRaio());
        });
    }

    @Test
    public void testCriarCirculoRaioInvalido() {
        Exception e = assertThrows(FiguraInvalidaException.class, () -> {
            new Circulo(-3);
        });
        assertEquals("Raio inválido: -3.0", e.getMessage());
    }

    @Test
    public void testSetRaioValido() throws FiguraInvalidaException {
        Circulo c = new Circulo(4);
        c.setRaio(10);
        assertEquals(10, c.getRaio());
    }

    @Test
    public void testSetRaioInvalido() throws FiguraInvalidaException {
        Circulo c = new Circulo(4);
        Exception e = assertThrows(FiguraInvalidaException.class, () -> {
            c.setRaio(0);
        });
        assertEquals("Raio inválido: 0.0", e.getMessage());
    }
}
