package com.Classes;

import java.util.ArrayList;

import com.Interface.PapelInterface;


public class Funcionario {
    private final String nome;
    private final Integer matricula;
    private ArrayList<FilmePapel> papeisFuncionario;

    public Funcionario(String nome, Integer matricula){
        this.nome = nome;
        this.matricula = matricula;
        this.papeisFuncionario = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<FilmePapel> getPapeis() {
        return papeisFuncionario;
    }


    public void adicionarPapel(PapelInterface novoPapel, Filme filme){
        papeisFuncionario.add(new FilmePapel(filme.getNome(),novoPapel));
    }

    // @Override
    // public boolean equals(Object obj) {  // usado nos testes
    //     if (this == obj) return true;
    //     if (obj == null || getClass() != obj.getClass()) return false;
    //     Funcionario func = (Funcionario) obj;
    //     return Objects.equals(nome, func.nome) && Objects.equals(papeis, func.papeis);
    // }
}