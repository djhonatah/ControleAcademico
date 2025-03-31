package com.java;

import classes.Aluno;
import classes.ControleAcademicoClass;
import classes.Disciplina;
import classes.Professor;
import classes.RDM;

public class Main {
    public static void main(String[] args) {
        // Criando o controle acadêmico
        ControleAcademicoClass suap = new ControleAcademicoClass();

        // Criando professores
        Professor professor1 = new Professor("Fábio Luiz Leite", 1233467445, suap);
        Professor professor2 = new Professor("Edson Tavares", 1735643894, suap);

        // Criando disciplinas
        Disciplina disciplina1 = new Disciplina("Computação moderna", 60, "Obrigatória", "Computação", "Segunda-feira 09:00-11:00");
        Disciplina disciplina2 = new Disciplina("Algoritmos", 60, "Obrigatória", "Computação", "Terça-feira 11:00-13:00");
        Disciplina disciplina3 = new Disciplina("Banco de Dados", 60, "Obrigatória", "Computação", "quarta-feira 11:00-13:00");

        // Adicionando professores às disciplinas
        try {
            professor1.adicionarDisciplina(disciplina1);
            professor1.adicionarDisciplina(disciplina3);
            professor2.adicionarDisciplina(disciplina2);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar disciplina ao professor: " + e.getMessage());
        }

        // Criando alunos
        Aluno aluno1 = new Aluno(0.0, "Werlys", 222076153, suap, new RDM());
        Aluno aluno2 = new Aluno(0.0, "Matheus Victor", 222019375, suap, new RDM());
        Aluno aluno3 = new Aluno(0.0, "Letícia Dantas", 202384637, suap, new RDM());

        // Matriculando alunos nas disciplinas
        try {
            aluno1.matricular_disciplina(disciplina1);
            aluno2.matricular_disciplina(disciplina2);
            aluno2.matricular_disciplina(disciplina1);
            aluno3.matricular_disciplina(disciplina3);
        } catch (Exception e) {
            System.out.println("Erro ao matricular aluno: " + e.getMessage());
        }

        // Consultando alunos das disciplina do professor Fábio Luiz
        try {
            for (Disciplina disciplina : professor1.getDisciplinasProfessor()) {
                System.out.println("Alunos na disciplina de " + disciplina.ComponenteCurricular + " ministrada por " + professor1.getNomeProfessor() + ":");   
                for (Aluno aluno : suap.consultarAlunosDisciplina(disciplina)) {
                System.out.println(aluno.getNomeAluno());
                }
                System.out.print("\n");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar alunos da disciplina: " + e.getMessage());
        }
        // Adicionando notas de um aluno em uma disciplina
        try {
            double media = professor1.adicionarNotas(aluno1, disciplina1, 8.0, 7.5);
            System.out.println("Nota de " + aluno1.getNomeAluno() + " na disciplina " + disciplina1.ComponenteCurricular + " ministrada por " + professor1.getNomeProfessor()+ ": " + media);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar nota: " + e.getMessage());
        }
        System.out.print("\n");
        // Alterando o horário de uma disciplina
        try {
            String novoHorario = suap.alterarHorarioDisciplina(disciplina1, "Segunda-feira 14:00");
            System.out.println("Novo horário da disciplina " + disciplina1.ComponenteCurricular + " ministrada por " + professor1.getNomeProfessor() + ": " + novoHorario);
        } catch (Exception e) {
            System.out.println("Erro ao alterar horário: " + e.getMessage());
        }
        System.out.print("\n");
        // Calculando o CRA do aluno Werlys
        try {
            RDM rdm = new RDM();
            rdm.registrarNota(aluno1, disciplina1, 7.8);
            double CRA = rdm.calculoCra(aluno1);
            System.out.print("CRA de " + aluno1.getNomeAluno() + ": " + CRA);
        } catch (Exception e) {
            System.out.println("Erro ao calcular CRA: " + e.getMessage());
        }
    }
}
