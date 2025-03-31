package classes;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private Integer numMatricula;
    private List<Disciplina> disciplinas;
    private List<String> horarios;
    protected ControleAcademicoClass controleAcademico;

    public Professor(String nome, Integer numMatricula, ControleAcademicoClass controle) {
        this.nome = nome;
        this.numMatricula = numMatricula;
        this.disciplinas = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.controleAcademico = controle;
        controle.adicionarProfessor(this);
    }

    //Responsabilidades
    public List<Disciplina> adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            disciplina.adicionarProfessor(this);
            horarios.add(disciplina.horario_disciplina); 
            controleAcademico.associarProfessorADisciplina(this, disciplina);
        }
        return disciplinas;
    }

    public double adicionarNotas(Aluno aluno, Disciplina disciplina, double nota1, double nota2) {
    double nota = 0.0;
    
    if (aluno.getDisciplinasAluno().contains(disciplina) && this.getDisciplinasProfessor().contains(disciplina) && nota1 >= 0.0 && nota2 >= 0.0) {
        nota = (nota1 + nota2)/2;
        aluno.notas.put(disciplina, nota);
    } else {
        System.out.println("Não é possível adicionar a nota. Verifique se o aluno está matriculado na disciplina e se o professor está associado à mesma.");
    }
    
    return nota;
}


    public List<Aluno> getAlunosDaDisciplina(Disciplina disciplina) {
        if (disciplinas.contains(disciplina)) {
            return disciplina.alunos;
        }
        return disciplina.alunos;
    }

    public int getNumeroAlunosDeDisciplina(Disciplina disciplina) {
        return disciplina.alunos.size();
    }

    public String getNomeProfessor() {
        return nome;
    }

    public List<Disciplina> getDisciplinasProfessor() {
        return disciplinas;
    }

    public List<String> getHorariosProfessor() {
        return horarios;
    }

}
