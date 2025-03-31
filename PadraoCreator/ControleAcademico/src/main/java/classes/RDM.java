package classes;

import java.util.HashMap;
import java.util.Map;

public class RDM {
    private Map<Aluno, Map<Disciplina, Double>> registroNotas;

    public RDM() {
        this.registroNotas = new HashMap<>();
    }

    public void adicionarAluno(Aluno aluno) {
        if (!registroNotas.containsKey(aluno)) {
            registroNotas.put(aluno, new HashMap<>());
        }
    }

    public void registrarNota(Aluno aluno, Disciplina disciplina, double nota) {
        if (!registroNotas.containsKey(aluno)) {
            adicionarAluno(aluno);
        }
        registroNotas.get(aluno).put(disciplina, nota);
    }

    public Double exibirNota(Aluno aluno, Disciplina disciplina) {
        if (registroNotas.containsKey(aluno) && registroNotas.get(aluno).containsKey(disciplina)) {
            return registroNotas.get(aluno).get(disciplina);
        }
        return null; 
    }

    public double calculoCra(Aluno aluno) {
    double numerador = 0.0;
    double denominador = 0.0;

    for (Disciplina disciplina : aluno.getDisciplinasAluno()) {
        Double media = this.exibirNota(aluno, disciplina);
        
        if (media != null) { 
            double cargaHoraria = disciplina.tempo_duracao; 
            numerador += cargaHoraria * media;
            denominador += cargaHoraria;
        }
    }
    return (denominador != 0) ? (numerador / denominador) : 0.0; 
}

}

