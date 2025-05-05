package com.java;

import java.util.ArrayList;

import com.Classes.*;
import com.Excecoes.*;
import com.Interface.Papeis;

public class MainRevisao {
    public static void main(String[] args) {
        Controle controle = new Controle();

        try {
            // Cadastro de funcionários
            Funcionario f1 = controle.adicionarFuncionario("Djhonatah Wesley");
            Funcionario f2 = controle.adicionarFuncionario("Werlys Kayan");
            Funcionario f3 = controle.adicionarFuncionario("Luis Gustavo");

            // Cadastro de filmes
            String[] trilha1 = { "\"Life is a Highway - Rascal Flatts\"", "\"Route 66 - Chuck Berry\""};
            Filme filme1 = controle.cadastrarFilme("Carros", "2004", trilha1);

            String[] trilha2 = { "\"Minecraft - C418\"", "\"Living Mice - C418\"" };
            Filme filme2 = controle.cadastrarFilme("Um Filme Minecraft", "2025", trilha2);

            // Atribuir papéis manualmente
            controle.cadastrarPapelNoFilme(filme1, Papeis.DIRETOR, "Djhonatah Wesley");
            controle.cadastrarPapelNoFilme(filme1, Papeis.ATOR, "Djhonatah Wesley");
            controle.cadastrarPapelNoFilme(filme1, Papeis.ATOR, "Werlys Kayan");
            controle.cadastrarPapelNoFilme(filme2, Papeis.CINEGRAFISTA, "Luis Gustavo");

            // Atribuir papéis em lote
            Papeis[] papeis = { Papeis.ROTEIRISTA, Papeis.CAMERA };
            String[] envolvidos = { "Luis Gustavo", "Luis Gustavo" };
            controle.cadastrarEnvolvidos("Um Filme Minecraft", papeis, envolvidos);

            // Exibir dados do filme
            controle.exibirDadosFilme("Carros");
            System.out.println();
            controle.exibirDadosFilme("Um Filme Minecraft");

            System.out.println("-----------------------------------------------------");
            // Exibir filmografia
            controle.exibirFilmografia("Djhonatah Wesley");
            System.out.println();
            controle.exibirFilmografia("Werlys Kayan");
            System.out.println();
            controle.exibirFilmografia("Luis Gustavo");

        } catch (FuncionarioExistente | FilmeExistente | FuncionarioNaoEncontrado | FilmeNaoEncontrado
                | PapelNaoEncontrado | TamanhoIncompativel e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
