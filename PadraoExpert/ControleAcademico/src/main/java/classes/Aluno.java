package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aluno {
 public String nome;
    private Integer num_matricula;
    private Double CRA;
    private List<Disciplina> disciplinas;
    private List<String> horario;
    private List<Professor> professores;
    private HashMap<Disciplina,Double> notas;

    public Aluno(Double CRA, String nome, Integer num_matricula) {
        this.CRA = CRA;
        this.nome = nome;
        this.num_matricula = num_matricula;
        this.disciplinas = new ArrayList<Disciplina>();
        this.professores = new ArrayList<Professor>();
        this.horario = new ArrayList<String>();
        this.notas = new HashMap<Disciplina,Double>();
    }

    //Responsabilidades
    public List<Disciplina> matricular_disciplina(Disciplina disciplina){
        disciplinas.add(disciplina);
        return disciplinas;
    }

    public String get_Horario(){
        String Horarios = "";
        for (int i = 0; i < disciplinas.size();i++){
            if (disciplinas.get(i).horario_disciplina != null){
                Horarios += "Horario "+(disciplinas.get(i).ComponenteCurricular)+": \n"+disciplinas.get(i).horario_disciplina;
            }
        }
        return Horarios;
    }


    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public  HashMap<Disciplina,Double> adicionarNotas(Disciplina disciplina,Double nota1,Double nota2){
        Double nota = (nota1 + nota2)/2;
        notas.put(disciplina,nota);
        return notas;
    }

    public double notas_aluno(Disciplina disciplina){
        double nota = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            nota += notas.get(disciplina).doubleValue();
        }
        return nota/notas.size();
    }

   public double calculoCra() {
    double numerador = 0.0;
    double denominador = 0.0;

    for (Disciplina disciplina : disciplinas) {
        if (notas.containsKey(disciplina)) {
            double media = notas.get(disciplina); 
            double cargaHoraria = disciplina.tempo_duracao; 
            //formula do Cra
            numerador += cargaHoraria * media;
            denominador += cargaHoraria;
        }
    }

    return denominador != 0 ? numerador / denominador : 0.0; 
}

    public String getNome() {
        return nome;
    }

    public Double getCRA() {
        return CRA;
    }

    public void setCRA(Double CRA) {
        this.CRA = CRA;
    }

}
