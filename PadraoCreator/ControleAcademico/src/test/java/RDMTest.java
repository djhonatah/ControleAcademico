import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.ControleAcademicoClass;
import classes.Disciplina;
import classes.Professor;
import classes.RDM;

public class RDMTest {
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
        disciplina = new Disciplina("Matemática 1", 60,"Obrigatoria","Mat","10 - 12");
    }

    @Test
    public void registrarNotaTest() {
        rdm.registrarNota(aluno, disciplina, 9.0);
        assertEquals(9.0, rdm.exibirNota(aluno, disciplina), "Erro ao registrar nota");
    }

    @Test
    public void exibirNotaTest() {
        rdm.registrarNota(aluno, disciplina, 7.5);
        
        Double nota = rdm.exibirNota(aluno, disciplina);
        assertNotNull(nota, "Nota deveria estar registrada");
        assertEquals(7.5, nota, "Nota incorreta");
    }

    @Test
    public double calculoCraTest() {
    Disciplina disciplina1 = new Disciplina("Paradigmas de programação", 60,"Obrigatoria","computação","11:00-13:00");
    Disciplina disciplina2 = new Disciplina("Programação Web", 60,"Obrigatoria","computação","14:00-16:00");

    aluno.matricular_disciplina(disciplina1);
    aluno.matricular_disciplina(disciplina2);

    professor.adicionarDisciplina(disciplina1);
    professor.adicionarDisciplina(disciplina2);

    professor.adicionarNotas(aluno, disciplina1, 8.0, 7.0);
    professor.adicionarNotas(aluno, disciplina2, 7.0, 9.0);

    rdm.registrarNota(aluno, disciplina1, 7.5);
    rdm.registrarNota(aluno, disciplina2, 8.0); 

    double cra = rdm.calculoCra(aluno);
    
    assertEquals(7.75, cra, 0.01, "Cálculo do CRA incorreto");

    return cra;
    }
}
