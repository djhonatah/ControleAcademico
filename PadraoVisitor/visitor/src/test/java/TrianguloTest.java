import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.classes.Triangulo;
import com.excecoes.FiguraInvalidaException;
import com.visitors.MaximizarVisitor;

public class TrianguloTest {

    @Test
    public void testCriarTrianguloValido() {
        assertDoesNotThrow(() -> {
            new Triangulo(6.0, 4.0, 5.0, 5.0);
        });
    }

    @Test
    public void testCriarTrianguloComBaseInvalida() {
        FiguraInvalidaException e = assertThrows(FiguraInvalidaException.class, () -> {
            new Triangulo(0.0, 4.0, 5.0, 5.0);
        });
        assertEquals("Dimensões inválidas para triângulo.", e.getMessage());
    }

    @Test
    public void testCriarTrianguloComAlturaInvalida() {
        FiguraInvalidaException e = assertThrows(FiguraInvalidaException.class, () -> {
            new Triangulo(6.0, -1.0, 5.0, 5.0);
        });
        assertEquals("Dimensões inválidas para triângulo.", e.getMessage());
    }

    @Test
    public void testCriarTrianguloComLado1Invalido() {
        FiguraInvalidaException e = assertThrows(FiguraInvalidaException.class, () -> {
            new Triangulo(6.0, 4.0, 0.0, 5.0);
        });
        assertEquals("Dimensões inválidas para triângulo.", e.getMessage());
    }

    @Test
    public void testCriarTrianguloComLado2Invalido() {
        FiguraInvalidaException e = assertThrows(FiguraInvalidaException.class, () -> {
            new Triangulo(6.0, 4.0, 5.0, -3.0);
        });
        assertEquals("Dimensões inválidas para triângulo.", e.getMessage());
    }

    @Test
    public void testAceitarMaximizarVisitor() throws FiguraInvalidaException {
        Triangulo t = new Triangulo(3.0, 4.0, 5.0, 6.0);
        MaximizarVisitor visitor = new MaximizarVisitor();
        t.aceitar(visitor);

        assertEquals(6.0, t.getBase());
        assertEquals(8.0, t.getAltura());
        assertEquals(10.0, t.getLado1());
        assertEquals(12.0, t.getLado2());
    }
}
