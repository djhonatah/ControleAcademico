package classes;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    public List<Aluno> alunos;
    public List<Professor> professores;
    public String ComponenteCurricular;
    public int tempo_duracao;
    public String tipoDisciplina;
    public String curso;
    public String horario_disciplina;

    public Disciplina(String componenteCurricular, int tempo_duracao, String tipoDisciplina, String curso, String horario_disciplina) {
        this.ComponenteCurricular = componenteCurricular;
        this.tempo_duracao = tempo_duracao;
        this.tipoDisciplina = tipoDisciplina;
        this.curso = curso;
        this.professores = new ArrayList<Professor>();
        this.alunos = new ArrayList<Aluno>();
        this.horario_disciplina = horario_disciplina;
    }

    //Responsabilidades
    public int numAlunos(int numAlunos){
        if (!alunos.isEmpty()){
            numAlunos = alunos.size();
        }
        return numAlunos;
    }

    public List<Aluno> adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
        }
        return alunos;
    }

    public List<Professor> adicionarProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            professores.add(professor);
        }    
        return professores;
    }

    public String alterarHorario(String novoHorario) {
        this.horario_disciplina = novoHorario;
        return novoHorario;
    }
}
