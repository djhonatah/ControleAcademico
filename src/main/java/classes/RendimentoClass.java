import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class RendimentoClass {
    private Aluno aluno;
    private Disciplina disciplina;

    public RendimentoClass(Aluno aluno, Disciplina disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
