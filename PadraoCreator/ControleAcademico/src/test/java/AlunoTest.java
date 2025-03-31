import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.ControleAcademicoClass;
import classes.Disciplina;
import classes.Professor;
import classes.RDM;

public class AlunoTest {
    
    public Professor professor;
    public Aluno aluno;
    public Disciplina disciplina;
    ControleAcademicoClass controle;
    RDM rdm;

    @BeforeEach
    public void setUp() {
        controle = new ControleAcademicoClass();
        rdm = new RDM();
        aluno = new Aluno(8.5, "Werlys", 222222, controle, rdm);
        professor = new Professor("Carlos", 12345, controle);
        disciplina = new Disciplina("Matemática 1", 60,"Obrigatoria","Mat","10 - 12");
    }

    @Test
    public List<Disciplina> matricularDisciplinaTest() {
        aluno.matricular_disciplina(disciplina);
        assertTrue(aluno.getDisciplinasMatriculadas().contains(disciplina), "Erro ao matricular disciplina");
        return aluno.getDisciplinasAluno();
    }

    @Test
    public void trancarDisciplinaTest() {
        aluno.matricular_disciplina(disciplina);
        aluno.trancar_disciplina(disciplina);
        assertFalse(aluno.getDisciplinasAluno().contains(disciplina), "Erro ao trancar disciplina");
    }

    @Test
    public double getNotasAlunoTest() {
        aluno.matricular_disciplina(disciplina);
        aluno.notas.put(disciplina, 9.0);
        
        double nota = aluno.getNotasAluno(disciplina);
        assertEquals(9.0, nota, "Erro ao obter nota do aluno");

        return nota;
    }

    @Test
    public void getCRA_AlunoTest() {    
        assertEquals(8.5, aluno.getCRA_Aluno(), "Erro ao obter CRA do aluno");
    }
}
