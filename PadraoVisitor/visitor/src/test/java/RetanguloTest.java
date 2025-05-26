import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.classes.Retangulo;
import com.excecoes.FiguraInvalidaException;
import com.visitors.MaximizarVisitor;

public class RetanguloTest {

    @Test
    public void testCriarRetanguloValido() {
        assertDoesNotThrow(() -> {
            new Retangulo(5.0, 10.0);
        });
    }

    @Test
    public void testCriarRetanguloComBaseInvalida() {
        Exception e = assertThrows(FiguraInvalidaException.class, () -> {
            new Retangulo(-3.0, 8.0);
        });
        assertEquals("Base ou altura inválida: base=-3.0, altura=8.0", e.getMessage());
    }

    @Test
    public void testCriarRetanguloComAlturaInvalida() {
        Exception e = assertThrows(FiguraInvalidaException.class, () -> {
            new Retangulo(4.0, 0.0);
        });
        assertEquals("Base ou altura inválida: base=4.0, altura=0.0", e.getMessage());
    }

    @Test
    public void testCriarRetanguloComBaseEAlturaInvalidas() {
        Exception e = assertThrows(FiguraInvalidaException.class, () -> {
            new Retangulo(-1.0, -2.0);
        });
        assertEquals("Base ou altura inválida: base=-1.0, altura=-2.0", e.getMessage());
    }

    @Test
    public void testAceitarMaximizarVisitor() throws FiguraInvalidaException {
        Retangulo r = new Retangulo(2.0, 3.0);
        MaximizarVisitor visitor = new MaximizarVisitor();
        r.aceitar(visitor);

        assertEquals(4.0, r.getBase());
        assertEquals(6.0, r.getAltura());
    }
}
