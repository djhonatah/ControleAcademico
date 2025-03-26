package classes;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private Integer numMatricula;
    private List<Disciplina> disciplinas;
    private List<String> horarios;

    public Professor(String nome, Integer numMatricula) {
        this.nome = nome;
        this.numMatricula = numMatricula;
        this.disciplinas = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }


    //Responsabilidades
    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            horarios.add(disciplina.horario_disciplina); 
        }
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public List<Aluno> getAlunosDaDisciplina(Disciplina disciplina) {
        if (disciplinas.contains(disciplina)) {
            return disciplina.alunos;
        }
        return new ArrayList<>(); 
    }

    public int getNumeroAlunosDeDisciplina(Disciplina disciplina) {
        return disciplina.alunos.size();
    }

    public String getNome() {
        return nome;
    }

}
