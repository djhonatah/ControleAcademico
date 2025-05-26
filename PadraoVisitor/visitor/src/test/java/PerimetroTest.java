import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.classes.Circulo;
import com.classes.Retangulo;
import com.classes.Triangulo;
import com.excecoes.FiguraInvalidaException;
import com.visitors.PerimetroVisitor;

public class PerimetroTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testVisitarCirculoValido() throws FiguraInvalidaException {
        Circulo c = new Circulo(2.0);
        PerimetroVisitor visitor = new PerimetroVisitor();
        c.aceitar(visitor);
        assertTrue(outContent.toString().contains("Perímetro do Círculo:"));
        assertTrue(outContent.toString().contains("12.566"));
    }

    @Test
    public void testVisitarCirculoInvalido() throws FiguraInvalidaException {
        Circulo c = new Circulo(2.0);
        c.setRaio(0); 
        PerimetroVisitor visitor = new PerimetroVisitor();
        c.aceitar(visitor);
        assertTrue(errContent.toString().contains("Raio inválido para calcular perímetro"));
    }

    @Test
    public void testVisitarTrianguloValido() throws FiguraInvalidaException {
        Triangulo t = new Triangulo(3.0, 4.0, 5.0, 6.0);
        PerimetroVisitor visitor = new PerimetroVisitor();
        t.aceitar(visitor);
        assertTrue(outContent.toString().contains("Perímetro do Triângulo: 14.0")); // 3+5+6
    }

    @Test
    public void testVisitarTrianguloInvalido() throws FiguraInvalidaException {
        Triangulo t = new Triangulo(3.0, 4.0, 5.0, 6.0);
        t.setBase(0);
        PerimetroVisitor visitor = new PerimetroVisitor();
        t.aceitar(visitor);
        assertTrue(errContent.toString().contains("Base ou lados inválidos"));
    }

    @Test
    public void testVisitarRetanguloValido() throws FiguraInvalidaException {
        Retangulo r = new Retangulo(4.0, 5.0);
        PerimetroVisitor visitor = new PerimetroVisitor();
        r.aceitar(visitor);
        assertTrue(outContent.toString().contains("Perímetro do Retângulo: 18.0")); // 2*(4+5)
    }

    @Test
    public void testVisitarRetanguloInvalido() throws FiguraInvalidaException {
        Retangulo r = new Retangulo(4.0, 5.0);
        r.setAltura(0);
        PerimetroVisitor visitor = new PerimetroVisitor();
        r.aceitar(visitor);
        assertTrue(errContent.toString().contains("Base ou altura inválida"));
    }
}
