package com.java;

import classes.Aluno;
import classes.Disciplina;
import classes.Professor;

public class Main {
    public static void main(String[] args) {
        // Criando instâncias de professores
        Professor professor1 = new Professor("Janderson", 201964637);
        Professor professor2 = new Professor("Allan Vilar", 201887654);

        // Criando instâncias de disciplinas
        Disciplina disciplina1 = new Disciplina("Técnicas de análise de Algoritmo", 60, "Obrigatória", "Computação", "7 - 9 Segunda\n9 - 11 Quarta");
        Disciplina disciplina2 = new Disciplina("Programação Web", 60, "Obrigatória", "Computação", "11 - 13 Segunda\n11 - 13 Quinta");

        // Adicionando professores às disciplinas
        disciplina1.adicionarProfessor(professor1);
        disciplina2.adicionarProfessor(professor2);

        // Criando instâncias de alunos
        Aluno aluno1 = new Aluno(0.0, "João Pedro", 222018124);
        Aluno aluno2 = new Aluno(0.0, "Johnattan Rodrigues", 222070456);

        // Matriculando alunos nas disciplinas
        aluno1.matricular_disciplina(disciplina1);
        aluno2.matricular_disciplina(disciplina2);

        // Adicionando alunos às disciplinas
        disciplina1.adicionarAluno(aluno1);
        disciplina2.adicionarAluno(aluno2);

        //Atribuindo professor a disciplina
        professor1.adicionarDisciplina(disciplina1);
        professor2.adicionarDisciplina(disciplina2);

        // Atribuindo notas aos alunos
        aluno1.adicionarNotas(disciplina1, 7.5, 8.0);
        aluno2.adicionarNotas(disciplina2, 6.0, 7.5);

        // Calculando e exibindo o CRA de cada aluno
        aluno1.setCRA(aluno1.calculoCra()); 
        aluno2.setCRA(aluno2.calculoCra());

        System.out.println("CRA de " + aluno2.getNome() + ": " + aluno2.getCRA()+"\n");
        System.out.println("CRA de " + aluno1.getNome() + ": " + aluno1.getCRA());

        // Exibindo horários das disciplinas para os alunos
        System.out.println(aluno1.getNome() + " tem os seguintes horários: ");
        System.out.println(aluno1.get_Horario());

        System.out.println("\n"+aluno2.getNome() + " tem os seguintes horários: ");
        System.out.println(aluno2.get_Horario());

        //Exibindo os professores das disciplinas e Horário dos professores
        System.out.println("\nDisciplinas que o professor "+professor1.getNome()+" ministra:");
        for (Disciplina disc : professor1.getDisciplinas()) {
            System.out.println(disc.ComponenteCurricular+"\nHorário do professor: \n"+disc.horario_disciplina);
        }
        
        System.out.println("\nDisciplinas que o professor "+professor2.getNome()+" ministra:");
        for (Disciplina disc : professor2.getDisciplinas()) {
            System.out.println(disc.ComponenteCurricular+"\nHorário do professor: \n"+disc.horario_disciplina);
        }
    }
}