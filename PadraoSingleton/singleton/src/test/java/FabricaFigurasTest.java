import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.fabrica.FabricaFiguras;
import excecoes.FiguraJaCriadaException;
import interfaces.Figura;

public class FabricaFigurasTest {

    FabricaFiguras fabrica;

    @BeforeEach
    public void setUp() {
        fabrica = FabricaFiguras.getInstancia();
    }

    // Testes para CÍRCULO

    @Test
    public void testCriarCirculo() {
        // Deve criar um círculo corretamente
        Figura circulo = fabrica.CreateCirculo();
        assertNotNull(circulo);
    }

    @Test
    public void testCriarSegundoCirculo() {
        // Deve lançar exceção ao tentar criar outro círculo
        fabrica.CreateCirculo(); // primeira criação
        FiguraJaCriadaException thrown = assertThrows(
            FiguraJaCriadaException.class,
            () -> fabrica.CreateCirculo()
        );
        assertEquals("A figura 'Círculo' já foi criada anteriormente.", thrown.getMessage());
    }

    // Testes para TRIÂNGULO ISÓSCELES

    @Test
    public void testCriarTrianguloIsosceles() {
        // Deve criar um triângulo isósceles corretamente
        Figura t = fabrica.CreateTrianguloIsosceles();
        assertNotNull(t);
    }

    @Test
    public void testCriarSegundoTrianguloIsosceles() {
        // Deve lançar exceção ao tentar criar outro triângulo isósceles
        fabrica.CreateTrianguloIsosceles();
        FiguraJaCriadaException thrown = assertThrows(
            FiguraJaCriadaException.class,
            () -> fabrica.CreateTrianguloIsosceles()
        );
        assertEquals("A figura 'Triângulo Isósceles' já foi criada anteriormente.", thrown.getMessage());
    }

    // Testes para TRIÂNGULO EQUILÁTERO

    @Test
    public void testCriarTrianguloEquilatero() {
        // Deve criar um triângulo equilátero corretamente
        Figura t = fabrica.CreateTrianguloEquilatero();
        assertNotNull(t);
    }

    @Test
    public void testCriarSegundoTrianguloEquilatero() {
        // Deve lançar exceção ao tentar criar outro triângulo equilátero
        fabrica.CreateTrianguloEquilatero(); // primeira criação
        FiguraJaCriadaException thrown = assertThrows(
            FiguraJaCriadaException.class,
            () -> fabrica.CreateTrianguloEquilatero()
        );
        assertEquals("A figura 'Triângulo Equilátero' já foi criada anteriormente.", thrown.getMessage());
    }

    // Testes para TRIÂNGULO RETÂNGULO
    @Test
    public void testCriarTrianguloRetangulo() {
        // Deve criar um triângulo retângulo corretamente
        Figura t = fabrica.CreateTrianguloRetangulo();
        assertNotNull(t);
    }

    @Test
    public void testCriarSegundoTrianguloRetangulo() {
        // Deve lançar exceção ao tentar criar outro triângulo retângulo
        fabrica.CreateTrianguloRetangulo(); // primeira criação
        FiguraJaCriadaException thrown = assertThrows(
            FiguraJaCriadaException.class,
            () -> fabrica.CreateTrianguloRetangulo()
        );
        assertEquals("A figura 'Triângulo Retângulo' já foi criada anteriormente.", thrown.getMessage());
    }

    // Testes para QUADRADO
    @Test
    public void testCriarQuadrado() {
        // Deve criar dois quadrados diferentes, pois quadrado pode ser criado sempre
        Figura quadrado1 = fabrica.CreateQuadrado();
        Figura quadrado2 = fabrica.CreateQuadrado();
        assertNotNull(quadrado1);
        assertNotNull(quadrado2);
        assertNotSame(quadrado1, quadrado2); // Devem ser instâncias diferentes
    }
}
