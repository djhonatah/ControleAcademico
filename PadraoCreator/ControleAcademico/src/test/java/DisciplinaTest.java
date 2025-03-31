import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.ControleAcademicoClass;
import classes.Disciplina;
import classes.Professor;
import classes.RDM;

public class DisciplinaTest {

    private Disciplina disciplina;
    private Aluno aluno1;
    private Aluno aluno2;
    private Professor professor1;
    private Professor professor2;
    ControleAcademicoClass controle;
    RDM rdm;

    @BeforeEach
    public void setUp() {
        controle = new ControleAcademicoClass();
        rdm = new RDM();
        aluno1 = new Aluno(8.5, "Werlys", 222222, controle, rdm);
        aluno2 = new Aluno(8.5, "Gabriel", 3333333, controle, rdm);
        professor1 = new Professor("Carlos", 12345, controle);
        professor2 = new Professor("Fábio", 45957, controle);

        disciplina = new Disciplina("Matemática Discreta", 60, "Obrigatória", "Ciências Exatas", "Segunda-feira, 10h");
    }

    @Test
    public void testAdicionarAluno() {

        assertEquals(0, disciplina.numAlunos(0));

        disciplina.adicionarAluno(aluno1);
        assertEquals(1, disciplina.numAlunos(0));

        disciplina.adicionarAluno(aluno1);
        assertEquals(1, disciplina.numAlunos(0));

        disciplina.adicionarAluno(aluno2);
        assertEquals(2, disciplina.numAlunos(0));
    }

    @Test
    public void testAdicionarProfessor() {
        disciplina.adicionarProfessor(professor1);
        assertEquals(1, disciplina.professores.size());

        disciplina.adicionarProfessor(professor1);
        assertEquals(1, disciplina.professores.size());

        disciplina.adicionarProfessor(professor2);
        assertEquals(2, disciplina.professores.size());
    }

    @Test
    public void testAlterarHorario() {
        assertEquals("Segunda-feira, 10h", disciplina.horario_disciplina);

        String novoHorario = "Quarta-feira, 14h";
        disciplina.alterarHorario(novoHorario);

        assertEquals(novoHorario, disciplina.horario_disciplina);
    }

    @Test
    public void testNumAlunos() {
        assertEquals(0, disciplina.numAlunos(0));

        disciplina.adicionarAluno(aluno1);
        disciplina.adicionarAluno(aluno2);

        assertEquals(2, disciplina.numAlunos(0));
    }
}
