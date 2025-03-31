import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.ControleAcademicoClass;
import classes.Disciplina;
import classes.Professor;
import classes.RDM;

class ControleAcademicoClassTest {
    private ControleAcademicoClass controleAcademico;
    private Aluno aluno;
    private Professor professor;
    private Disciplina disciplina;
    private RDM rdm;

    @BeforeEach
    void setUp() {
        controleAcademico = new ControleAcademicoClass();
        rdm = new RDM();
        aluno = new Aluno(0.0, "Werlys", 222222, controleAcademico, rdm);
        professor = new Professor("Carlos", 12345, controleAcademico);
        disciplina = new Disciplina("Matemática", 60,"Obrigatoria","Mat","10 - 12");

        // Adicionando ao sistema
        controleAcademico.adicionarAluno(aluno);
        controleAcademico.adicionarProfessor(professor);
    }

    @Test
    void testAdicionarAluno() {
        assertTrue(controleAcademico.getAlunos().contains(aluno), "Aluno deveria estar cadastrado no sistema");
    }

    @Test
    void testAdicionarProfessor() {
        assertTrue(controleAcademico.getProfessores().contains(professor), "Professor deveria estar cadastrado no sistema");
    }

    @Test
    void testMatricularAlunoEmDisciplina() {
        aluno.matricular_disciplina(disciplina);
        controleAcademico.getDisciplinas().add(disciplina);
        boolean resultado = controleAcademico.matricularAlunoEmDisciplina(aluno, disciplina);
        assertTrue(resultado, "Aluno deveria ser matriculado na disciplina");
        assertTrue(!aluno.getDisciplinasAluno().contains(disciplina), "Disciplina deveria estar na lista de disciplinas do aluno");
    }

    @Test
    void testAssociarProfessorADisciplina() {
        controleAcademico.getDisciplinas().add(disciplina);
        boolean resultado = controleAcademico.associarProfessorADisciplina(professor, disciplina);
        assertTrue(resultado, "Professor deveria ser associado à disciplina");
        assertTrue(professor.getDisciplinasProfessor().contains(disciplina), "Disciplina deveria estar na lista do professor");
    }

    @Test
    void testConsultarDisciplinasProfessor() {
        professor.adicionarDisciplina(disciplina);
        List<Disciplina> disciplinasProfessor = controleAcademico.consultarDisciplinasProfessor(professor);
        assertTrue(disciplinasProfessor.contains(disciplina), "Disciplina deveria estar associada ao professor");
    }

    @Test
    void testConsultarAlunosDisciplina() {
        aluno.matricular_disciplina(disciplina);
        List<Aluno> alunosDaDisciplina = controleAcademico.consultarAlunosDisciplina(disciplina);
        assertTrue(alunosDaDisciplina.contains(aluno), "Aluno deveria estar matriculado na disciplina");
    }

    @Test
    void testConsultarHorarioProfessor() {
        professor.adicionarDisciplina(disciplina);
        List<String> horarios = controleAcademico.consultarHorarioProfessor(professor);
        assertTrue(horarios.contains("10:00-12:00"), "Horário deveria estar na lista do professor");
    }

    @Test
    void testAlterarHorarioDisciplina() {
        String novoHorario = "14:00-16:00";
        String resultado = controleAcademico.alterarHorarioDisciplina(disciplina, novoHorario);
        assertEquals(novoHorario, resultado, "O horário da disciplina deveria ser atualizado corretamente");
    }

    @Test
    void testGerarRdm() {
        aluno.matricular_disciplina(disciplina);
        rdm.registrarNota(aluno, disciplina, 8.0);
        List<RDM> rdms = controleAcademico.gerarRdm(professor, aluno, disciplina, rdm);

        assertNotNull(rdms, "A lista de RDMs não deveria ser nula");
        assertEquals(0, rdms.size(), "A lista de RDMs gerada deveria estar vazia inicialmente");
    }
}
