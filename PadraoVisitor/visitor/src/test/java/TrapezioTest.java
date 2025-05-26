import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.classes.Trapezio;
import com.excecoes.FiguraInvalidaException;
import com.visitors.MaximizarVisitor;

public class TrapezioTest {

    @Test
    public void testCriarTrapezioValido() {
        assertDoesNotThrow(() -> {
            new Trapezio(10.0, 5.0, 4.0, 3.0, 3.0);
        });
    }

    @Test
    public void testCriarTrapezioComBaseMaiorInvalida() {
        FiguraInvalidaException e = assertThrows(FiguraInvalidaException.class, () -> {
            new Trapezio(0.0, 5.0, 4.0, 3.0, 3.0);
        });
        assertEquals("Dimensões inválidas para trapézio.", e.getMessage());
    }

    @Test
    public void testCriarTrapezioComBaseMenorInvalida() {
        FiguraInvalidaException e = assertThrows(FiguraInvalidaException.class, () -> {
            new Trapezio(10.0, -1.0, 4.0, 3.0, 3.0);
        });
        assertEquals("Dimensões inválidas para trapézio.", e.getMessage());
    }

    @Test
    public void testCriarTrapezioComAlturaInvalida() {
        FiguraInvalidaException e = assertThrows(FiguraInvalidaException.class, () -> {
            new Trapezio(10.0, 5.0, 0.0, 3.0, 3.0);
        });
        assertEquals("Dimensões inválidas para trapézio.", e.getMessage());
    }

    @Test
    public void testCriarTrapezioComLado1Invalido() {
        FiguraInvalidaException e = assertThrows(FiguraInvalidaException.class, () -> {
            new Trapezio(10.0, 5.0, 4.0, -2.0, 3.0);
        });
        assertEquals("Dimensões inválidas para trapézio.", e.getMessage());
    }

    @Test
    public void testCriarTrapezioComLado2Invalido() {
        FiguraInvalidaException e = assertThrows(FiguraInvalidaException.class, () -> {
            new Trapezio(10.0, 5.0, 4.0, 3.0, 0.0);
        });
        assertEquals("Dimensões inválidas para trapézio.", e.getMessage());
    }

    @Test
    public void testAceitarMaximizarVisitor() throws FiguraInvalidaException {
        Trapezio t = new Trapezio(8.0, 4.0, 2.0, 3.0, 3.0);
        MaximizarVisitor visitor = new MaximizarVisitor();
        t.aceitar(visitor);

        assertEquals(16.0, t.getBaseMaior());
        assertEquals(8.0, t.getBaseMenor());
        assertEquals(4.0, t.getAltura());
        assertEquals(6.0, t.getLado1());
        assertEquals(6.0, t.getLado2());
    }
}
