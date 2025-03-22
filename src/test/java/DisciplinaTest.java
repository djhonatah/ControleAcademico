import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.Disciplina;
import classes.Professor;

public class DisciplinaTest {

    private Disciplina disciplina;
    private Aluno aluno1;
    private Aluno aluno2;
    private Professor professor1;
    private Professor professor2;

    @BeforeEach
    public void setUp() {
        disciplina = new Disciplina("Oac", 60, "Obrigatória", "Computação", "7 - 9");
        aluno1 = new Aluno(0.0, "Aluno 1", 11111);
        aluno2 = new Aluno(0.0, "Aluno 2", 22222);
        professor1 = new Professor("Prof. João", 12345);
        professor2 = new Professor("Prof. Maria", 54321);

        disciplina.adicionarAluno(aluno1);
        disciplina.adicionarAluno(aluno2);
        disciplina.adicionarProfessor(professor1);
        disciplina.adicionarProfessor(professor2);
    }

    @Test
    public void numAlunosTest() {
        int numAlunos = disciplina.numAlunos(disciplina.alunos.size());
        assertEquals(2, numAlunos, "A disciplina deve ter 2 alunos matriculados.");
    }

    @Test
    public List<Aluno> adicionarAlunoTest() {
        Aluno aluno3 = new Aluno(0.0, "Aluno 3", 20198912);
        disciplina.adicionarAluno(aluno3);
        List<Aluno> alunos = disciplina.alunos;
        assertTrue(alunos.contains(aluno3), "Aluno 3 deve ser adicionado à lista de alunos.");
        return alunos;
    }

    @Test
    public List<Professor> adicionarProfessorTest() {
        Professor professor3 = new Professor("Antônio Carlos", 678902456);
        disciplina.adicionarProfessor(professor3);
        List<Professor> professores = disciplina.professores;
        assertTrue(professores.contains(professor3), "Professor deve ser adicionado à lista de professores.");
        return professores;
    }

    @Test
    public String alterarHorariotest() {
        String novoHorario = "10 - 12";
        String horarioAlterado = disciplina.alterarHorario(novoHorario);
        assertEquals(novoHorario, horarioAlterado, "O horário da disciplina deve ser alterado corretamente.");
        return novoHorario;
    }

    @Test
    public void verificarAlunoMatriculadoTest() {
        assertTrue(disciplina.verificarAlunoMatriculado(aluno1), "Aluno 1 deve estar matriculado na disciplina.");
        assertFalse(disciplina.verificarAlunoMatriculado(new Aluno(0.0, "Aluno 4", 44444)), "Aluno 4 não deve estar matriculado na disciplina.");
    }

    @Test
    public void verificarProfessorVinculadoTest() {
        assertTrue(disciplina.verificarProfessorVinculado(professor1), "Prof. João deve estar vinculado à disciplina.");
        assertFalse(disciplina.verificarProfessorVinculado(new Professor("Prof. Pedro", 98765)), "Prof. Pedro não deve estar vinculado à disciplina.");
    }
}
