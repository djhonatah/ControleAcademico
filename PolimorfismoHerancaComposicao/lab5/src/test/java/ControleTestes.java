import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Classes.Controle;
import com.Classes.Funcionario;
import com.Excecoes.FuncionarioExistente;

public class ControleTestes {
    
    private Controle controle;

    @BeforeEach
    void setUp() {
        controle = new Controle();
    }
    
    @Test
    void testAdicionarFuncionarioComSucesso() throws FuncionarioExistente {
        Funcionario funcionario = controle.adicionarFuncionario("João");
        assertNotNull(funcionario);
        assertEquals("João", funcionario.getNome());
    }

    @Test
    void testAdicionarFuncionarioExistente() throws FuncionarioExistente {
        controle.adicionarFuncionario("Maria");
        assertThrows(FuncionarioExistente.class, () -> {
            controle.adicionarFuncionario("Maria");
        });
    }


}
