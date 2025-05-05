import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Classes.PapelFuncionario;
import com.Interface.PapelInterface;
import com.PapeisPackage.Diretor;

public class PapelFuncionarioTest {

    @Test
    void testConstrutorComFuncionarioEPapel() {
        PapelInterface papel = new Diretor();
        PapelFuncionario pf = new PapelFuncionario("Christopher Nolan", papel);

        assertEquals("Christopher Nolan", pf.getFuncionario());
        assertEquals(papel, pf.getPapel());
    }

    @Test
    void testConstrutorSomenteFuncionario() {
        PapelFuncionario pf = new PapelFuncionario("Quentin Tarantino");

        assertEquals("Quentin Tarantino", pf.getFuncionario());
        assertNull(pf.getPapel());
    }

    @Test
    void testSetFuncionario() {
        PapelFuncionario pf = new PapelFuncionario("Funcionario Antigo");
        pf.setFuncionario("Funcionario Novo");

        assertEquals("Funcionario Novo", pf.getFuncionario());
    }

    @Test
    void testSetPapel() {
        PapelFuncionario pf = new PapelFuncionario("Funcionario X");
        PapelInterface papel = new Diretor();

        pf.setPapel(papel);
        assertEquals(papel, pf.getPapel());
    }
}
