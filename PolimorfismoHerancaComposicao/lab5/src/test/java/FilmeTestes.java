import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.Classes.Filme;
import com.Classes.Funcionario;
import com.Classes.PapelFuncionario;
import com.Interface.PapelInterface;
import com.PapeisPackage.Ator;

public class FilmeTestes {

    @Test
    void testConstrutorComNomeAnoTrilha() {
        String[] trilha = {"Trilha 1", "Trilha 2"};
        Filme filme = new Filme("Matrix", "1999", trilha);

        assertEquals("Matrix", filme.getNome());
        assertEquals("1999", filme.getAno());
        assertEquals(2, filme.getTrilhaSonora().size());
    }

    @Test
    void testConstrutorComNomeTrilha() {
        String[] trilha = {"T1", "T2"};
        Filme filme = new Filme("Sem Ano", trilha);

        assertEquals("Sem Ano", filme.getNome());
        assertEquals("Não Informado", filme.getAno());
        assertEquals(2, filme.getTrilhaSonora().size());
    }

    @Test
    void testConstrutorComNomeAnoSemTrilha() {
        Filme filme = new Filme("Filme Cru", "2023");

        assertEquals("Filme Cru", filme.getNome());
        assertEquals("2023", filme.getAno());
        assertTrue(filme.getTrilhaSonora().isEmpty());
    }

    @Test
    void testAddEnvolvido() {
        Filme filme = new Filme("Inception", "2010");
        Funcionario funcionario = new Funcionario("Leonardo", 123456);
        PapelInterface papel = new Ator(); //  Ator implementa PapelInterface

        filme.addEnvolvido(papel, funcionario);
        ArrayList<PapelFuncionario> envolvidos = filme.getEnvolvidos();

        assertEquals(1, envolvidos.size());
        assertEquals("Leonardo", envolvidos.get(0).getFuncionario());
        assertEquals(papel, envolvidos.get(0).getPapel());
    }

    @Test
    void testGetTrilhaSonora() {
        String[] trilhas = {"Trilha A", "Trilha B"};
        Filme filme = new Filme("Sonoro", "2020", trilhas);

        ArrayList<String> trilhaSonora = filme.getTrilhaSonora();
        assertEquals(2, trilhaSonora.size());
        assertTrue(trilhaSonora.contains("Trilha A"));
    }
}
