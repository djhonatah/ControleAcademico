import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.Disciplina;

public class AlunoTest {
    public Aluno aluno;
    public Disciplina disciplina1;
    public Disciplina disciplina2;

    @BeforeEach
    public void setUp() {
        aluno = new Aluno(0.0, "Werlys", 222080143);
        disciplina1 = new Disciplina("Oac", 60, "Obrigatoria", "Computação", "7 - 9");
        disciplina2 = new Disciplina("Calculo", 90, "Obrigatoria", "Matemática", "10 - 12");
    }

    @Test
    public List<Disciplina> MatricularDisciplinaTest() {
        List<Disciplina> disciplinas = aluno.matricular_disciplina(disciplina1);
        assertTrue(disciplinas.contains(disciplina1));
        return disciplinas;
    }

    @Test
    public void getHorarioTest() {
        aluno.matricular_disciplina(disciplina1);
        String horario = aluno.get_Horario();
        assertTrue(horario.contains("Horario Oac:"));
        assertTrue(horario.contains("7 - 9"));
    }

    @Test
    public HashMap<Disciplina, Double> AdicionarNotasTest() {
        HashMap<Disciplina, Double> notas = aluno.adicionarNotas(disciplina1, 8.0, 6.0);
        assertEquals(7.0, notas.get(disciplina1), 0.01);
        return notas;
    }

    @Test
    public double notasAlunoTest() {
        aluno.adicionarNotas(disciplina1, 8.0, 6.0);
        double media = aluno.notas_aluno(disciplina1);
        assertEquals(7.0, media, 0.01);
        return media;
    }

    
    @Test
    public double CalculoCraTest() {
        aluno.matricular_disciplina(disciplina1);
        aluno.matricular_disciplina(disciplina2);

        aluno.adicionarNotas(disciplina1, 8.0, 6.0);
        aluno.adicionarNotas(disciplina2, 7.0, 5.0);

        double cra = aluno.calculoCra();
        assertEquals(6.4, cra, 0.0);  
        return cra;
    }
}

    
