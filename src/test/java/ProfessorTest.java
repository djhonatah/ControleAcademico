import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.Disciplina;
import classes.Professor;

public class ProfessorTest {

    public Professor professor;
    public Aluno aluno1;
    public Aluno aluno2;
    public Disciplina disciplina1;
    public Disciplina disciplina2;

    @BeforeEach
    public void setUp() {
        professor = new Professor("Daniel Marques", 12373612);
        aluno1 = new Aluno(0.0, "Ascendino", 201589121);
        aluno2 = new Aluno(0.0, "Guilherme", 222070130);
        
        disciplina1 = new Disciplina("Oac", 60, "Obrigatória", "Computação", "7 - 9");
        disciplina2 = new Disciplina("Cálculo", 90, "Obrigatória", "Computação", "10 - 12");

        aluno1.matricular_disciplina(disciplina1);
        aluno1.matricular_disciplina(disciplina2);
        aluno2.matricular_disciplina(disciplina1);
        
        professor.adicionarDisciplina(disciplina1);
        professor.adicionarDisciplina(disciplina2);
    }

    @Test
    public List<Disciplina> disciplinasProfessorTest() {
        List<Disciplina> disciplinas = professor.getDisciplinas();
        assertEquals(2, disciplinas.size());
        assertTrue(disciplinas.contains(disciplina1), "Disciplina Oac deve estar na lista.");
        assertTrue(disciplinas.contains(disciplina2), "Disciplina Cálculo deve estar na lista.");
        return disciplinas;
    }

    @Test
    public List<String> HorariosProfessorTest() {
        List<String> horarios = professor.getHorarios();
        assertEquals(2, horarios.size(), "Professor tem 2 horários.");
        assertTrue(horarios.contains("7 - 9"), "O horário de Oac deve estar na lista.");
        assertTrue(horarios.contains("10 - 12"), "O horário de Cálculo deve estar na lista.");
        return horarios;
    }

    @Test
    public List<Aluno> alunosDaDisciplinaTest() {
        List<Aluno> alunos = professor.getAlunosDaDisciplina(disciplina1);
        assertEquals(2, alunos.size(), "A disciplina Oac deve ter 2 alunos.");
        assertTrue(alunos.contains(aluno1), "Aluno 1 deve estar matriculado na disciplina Oac.");
        assertTrue(alunos.contains(aluno2), "Aluno 2 deve estar matriculado na disciplina Oac.");
        return alunos;
    }

    @Test
    public int numeroAlunosDeDisciplinaTest() {
        int numAlunos = professor.getNumeroAlunosDeDisciplina(disciplina1);
        assertEquals(2, numAlunos, "A disciplina Oac deve ter 2 alunos matriculados.");
        return numAlunos;
    }
}
