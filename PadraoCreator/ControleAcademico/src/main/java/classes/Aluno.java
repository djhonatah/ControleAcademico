package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aluno {
    public String nome;
    private Integer num_matricula;
    private Double CRA;
    protected  List<Disciplina> disciplinas;
    private List<String> horario; 
    public HashMap<Disciplina,Double> notas;
    protected ControleAcademicoClass controleAcademico;
    protected RDM rdm_aluno;


    public Aluno(Double CRA, String nome, Integer num_matricula, ControleAcademicoClass controle, RDM rdm) {
        this.CRA = CRA;
        this.nome = nome;
        this.disciplinas = new ArrayList<Disciplina>();
        this.notas = new HashMap<Disciplina,Double>();
        this.controleAcademico = controle;
        controle.adicionarAluno(this);
        this.rdm_aluno = rdm;
        rdm.adicionarAluno(this);

    }

    //Responsabilidades
    public List<Disciplina> matricular_disciplina(Disciplina disciplina) {
        if (disciplina != null && !disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            disciplina.adicionarAluno(this);
        }

        return this.getDisciplinasAluno();
    }
    

    public List<Disciplina> trancar_disciplina(Disciplina disciplina){
        if (disciplinas.contains(disciplina)) {
            disciplinas.remove(disciplina);
        }
        return disciplinas;
    }

    public String getHorarioAluno(){
        String Horarios = "";
        for (int i = 0; i < disciplinas.size();i++){
            if (disciplinas.get(i).horario_disciplina != null){
                Horarios += "Horario "+(disciplinas.get(i).ComponenteCurricular)+": \n"+disciplinas.get(i).horario_disciplina;
            }
        }
        return Horarios;
    }

    public List<Disciplina> getDisciplinasAluno() {
        return disciplinas;    
    }

    public double getNotasAluno(Disciplina disciplina){
        double nota = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            nota += notas.get(disciplina).doubleValue();
        }
        return nota/notas.size();
    }

    public String getNomeAluno() {
        return nome;
    }

    public Double getCRA_Aluno() {
        return CRA;
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return this.disciplinas; 
    }
    
}
