import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Classes.Controle;
import com.Classes.Filme;
import com.Classes.Funcionario;
import com.Excecoes.*;

import com.Interface.Papeis;

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
        assertThrows(FuncionarioExistente.class, () -> controle.adicionarFuncionario("Maria"));
    }

    @Test
    void testCadastrarFilmeComSucesso() throws FilmeExistente {
        Filme filme = controle.cadastrarFilme("Matrix", "1999", new String[]{"Trilha A", "Trilha B"});
        assertEquals("Matrix", filme.getNome());
    }

    @Test
    void testCadastrarFilmeExistente() throws FilmeExistente {
        controle.cadastrarFilme("Matrix", "1999", new String[]{"Trilha"});
        assertThrows(FilmeExistente.class, () -> controle.cadastrarFilme("Matrix", "2000", new String[]{"Outra Trilha"}));
    }

    @Test
    void testCadastrarPapelNoFilmeComSucesso() throws Exception {
        controle.adicionarFuncionario("Carlos");
        Filme filme = controle.cadastrarFilme("Inception", "2010", new String[]{"Dream Track"});
        assertNotNull(controle.cadastrarPapelNoFilme(filme, Papeis.ATOR, "Carlos"));
    }

    @Test
    void testCadastrarPapelFuncionarioInexistente() throws Exception {
        Filme filme = controle.cadastrarFilme("Titanic", "1997", new String[]{"Soundtrack"});
        assertThrows(FuncionarioNaoEncontrado.class, () -> controle.cadastrarPapelNoFilme(filme, Papeis.DIRETOR, "NãoExiste"));
    }

    @Test
    void testCadastrarPapelPapelNaoEncontrado() throws Exception {
        controle.adicionarFuncionario("Joana");
        Filme filme = controle.cadastrarFilme("Sem Papel", "2020", new String[]{"Trilha"});
        assertThrows(PapelNaoEncontrado.class, () -> controle.cadastrarPapelNoFilme(filme, null, "Joana"));
    }

    @Test
    void testCadastrarEnvolvidosComTamanhoIncompativel() {
        assertThrows(TamanhoIncompativel.class, () -> {
            controle.cadastrarEnvolvidos("Qualquer", new Papeis[]{Papeis.ATOR, Papeis.DIRETOR}, new String[]{"PessoaSó"});
        });
    }

    @Test
    void testCadastrarEnvolvidosComSucesso() throws Exception {
        controle.adicionarFuncionario("Ana");
        controle.adicionarFuncionario("Bruno");
        controle.cadastrarFilme("Avatar", "2009", new String[]{"Trilha X"});
        
        assertDoesNotThrow(() -> controle.cadastrarEnvolvidos("Avatar",
                new Papeis[]{Papeis.ATOR, Papeis.DIRETOR},
                new String[]{"Ana", "Bruno"}));
    }

    @Test
    void testBuscarFuncionarioNaoEncontrado() {
        assertThrows(FuncionarioNaoEncontrado.class, () -> controle.buscarFuncionario("Desconhecido"));
    }

    @Test
    void testBuscarFilmeNaoEncontrado() {
        assertThrows(FilmeNaoEncontrado.class, () -> controle.buscarFilme("Não Existe"));
    }

    @Test
    void testExibirDadosFilme() throws Exception {
        controle.cadastrarFilme("Interestelar", "2014", new String[]{"Trilha A", "Trilha B"});
        controle.adicionarFuncionario("Murphy");
        controle.cadastrarPapelNoFilme(controle.buscarFilme("Interestelar"), Papeis.ATOR, "Murphy");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        controle.exibirDadosFilme("Interestelar");

        String output = outputStream.toString();
        assertTrue(output.contains("Interestelar"));
        assertTrue(output.contains("Trilha A"));
        assertTrue(output.contains("Murphy"));

        System.setOut(System.out); // Restaurar a saída padrão
    }

    @Test
    void testExibirFilmografia() throws Exception {
        controle.adicionarFuncionario("Nolan");
        Filme filme = controle.cadastrarFilme("A Origem", "2010", new String[]{"Dreams"});
        controle.cadastrarPapelNoFilme(filme, Papeis.DIRETOR, "Nolan");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        controle.exibirFilmografia("Nolan");

        String output = outputStream.toString();
        assertTrue(output.contains("Filmografia de Nolan"));
        assertTrue(output.contains("A Origem"));
        assertFalse(output.contains("DIRETOR"));

        System.setOut(System.out); // Restaurar a saída padrão
    }
}
