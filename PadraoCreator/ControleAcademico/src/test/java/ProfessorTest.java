import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.ControleAcademicoClass;
import classes.Disciplina;
import classes.Professor;
import classes.RDM;

public class ProfessorTest {

    public Professor professor;
    public Aluno aluno;
    public Disciplina disciplina;
    ControleAcademicoClass controle;
    RDM rdm;

    @BeforeEach
    public void setUp() {
        controle = new ControleAcademicoClass();
        rdm = new RDM();
        aluno = new Aluno(0.0, "Werlys", 222222, controle, rdm);
        professor = new Professor("Carlos", 12345, controle);
        disciplina = new Disciplina("Matemática", 60,"Obrigatoria","Mat","10 - 12");
    }

    @Test
    public List<Disciplina> adicionarDisciplinaTest() {
        
        aluno.matricular_disciplina(disciplina);

        professor.adicionarDisciplina(disciplina);
        assertTrue(professor.getDisciplinasProfessor().contains(disciplina), "Erro ao adicionar disciplina");

        return professor.getDisciplinasProfessor();
    }

    @Test
    public void getHorariosProfessorTest() {
        professor.adicionarDisciplina(disciplina);
        assertTrue(professor.getHorariosProfessor().contains("10 - 12"), "Erro ao obter horários do professor");
    }

    @Test
    public void getAlunosDaDisciplinaTest() {
        aluno.matricular_disciplina(disciplina);
        professor.adicionarDisciplina(disciplina);
        
        List<Aluno> alunosDaDisciplina = professor.getAlunosDaDisciplina(disciplina);
        assertTrue(alunosDaDisciplina.contains(aluno), "Erro ao obter alunos da disciplina");
    }

    @Test
    public void getNumeroAlunosDeDisciplinaTest() {
        aluno.matricular_disciplina(disciplina);
        professor.adicionarDisciplina(disciplina);
        
        int numAlunos = professor.getNumeroAlunosDeDisciplina(disciplina);
        assertEquals(1, numAlunos, "Número de alunos na disciplina incorreto");
    }

    @Test
    public void adicionarNotasTest() {
        aluno.matricular_disciplina(disciplina);
        professor.adicionarDisciplina(disciplina);
        double nota = professor.adicionarNotas(aluno, disciplina, 8.0, 7.0);
        assertEquals(7.5, nota, "Erro ao adicionar notas");
    }

    @Test
    public void adicionarDisciplinaDuplicadaTest() {
        professor.adicionarDisciplina(disciplina);
        List<Disciplina> disciplinas = professor.adicionarDisciplina(disciplina); // Tentando adicionar a mesma disciplina novamente

        // Verifica se a disciplina duplicada não foi adicionada
        assertEquals(1, disciplinas.size(), "A disciplina foi adicionada mais de uma vez.");
        assertTrue(disciplinas.contains(disciplina), "A disciplina não foi adicionada corretamente.");
    }

    @Test
    public void testAdicionarDisciplinaInvalida() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            professor.adicionarDisciplina(null); // Adicionando disciplina nula
        });

        System.out.println("Erro esperado ao adicionar disciplina inválida: " + exception.getMessage());
    }
}
