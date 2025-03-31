package classes;

import java.util.ArrayList;
import java.util.List;

public class ControleAcademicoClass {
    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<RDM> rdms_alunos = new ArrayList<>();

    // Adiciona um aluno ao sistema
    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
        }
    }

    // Adiciona um professor ao sistema
    public void adicionarProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            professores.add(professor);
        }
    }

    // Matricula um aluno em uma disciplina específica
    public boolean matricularAlunoEmDisciplina(Aluno aluno, Disciplina disciplina) {
        if (alunos.contains(aluno) && disciplinas.contains(disciplina)) {
            aluno.matricular_disciplina(disciplina);
            return true;
        }
        return false;
    }

    // Associa um professor a uma disciplina específica
    public boolean associarProfessorADisciplina(Professor professor, Disciplina disciplina) {
        if (professores.contains(professor) && disciplinas.contains(disciplina)) {
            professor.adicionarDisciplina(disciplina);
            return true;
        }
        return false;
    }

    // Consulta disciplinas ministradas por um professor
    public List<Disciplina> consultarDisciplinasProfessor(Professor professor) {
        return professor.getDisciplinasProfessor();
    }

    // Consulta os alunos matriculados em uma disciplina
    public List<Aluno> consultarAlunosDisciplina(Disciplina disciplina) {
        return disciplina.alunos;
    }

    // Consulta o horário de um professor
    public List<String> consultarHorarioProfessor(Professor professor) {
        return professor.getHorariosProfessor();
    }

    // Consulta todos os alunos cadastrados
    public List<Aluno> getAlunos() {
        return alunos;
    }

    // Consulta todos os professores cadastrados
    public List<Professor> getProfessores() {
        return professores;
    }

    // Consulta todas as disciplinas cadastradas
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public String alterarHorarioDisciplina(Disciplina disciplina,String novo_horario){
        disciplina.alterarHorario(novo_horario);
        return novo_horario;
    }

    public List<RDM> gerarRdm(Professor profesor, Aluno aluno, Disciplina disciplina, RDM rdm){
        for (Disciplina disci : aluno.disciplinas) {
            rdm.registrarNota(aluno, disciplina, aluno.getNotasAluno(disci));    
        }
        
        rdm.calculoCra(aluno);
        rdm.exibirNota(aluno, disciplina);
        aluno.getCRA_Aluno();
    

    return rdms_alunos;
    }


}
