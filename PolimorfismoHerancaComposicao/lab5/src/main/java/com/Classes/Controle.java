package com.Classes;

import java.util.ArrayList;
import java.util.Random;

import com.Excecoes.FilmeExistente;
import com.Excecoes.FilmeNaoEncontrado;
import com.Excecoes.FuncionarioExistente;
import com.Excecoes.FuncionarioNaoEncontrado;
import com.Excecoes.PapelNaoEncontrado;
import com.Excecoes.TamanhoIncompativel;
import com.Interface.Papeis;
import com.Interface.PapelInterface;
import com.PapeisPackage.Ator;
import com.PapeisPackage.Camera;
import com.PapeisPackage.Cinegrafista;
import com.PapeisPackage.Diretor;
import com.PapeisPackage.Roteirista;

public class Controle {
    private final ArrayList<Funcionario> listFuncionarios;
    private final ArrayList<Filme> listFilmes;

    public Controle() {
        this.listFuncionarios = new ArrayList<>();
        this.listFilmes = new ArrayList<>();
    }

    //Métodos - Funcionario
     public ArrayList<Funcionario> getFuncionarios() {
        return this.listFuncionarios;
    }

    public Funcionario adicionarFuncionario(String nome) throws FuncionarioExistente {
        verificarExistenciaFuncionario(nome);
        Random random = new Random();
        int numero = 100000 + random.nextInt(900000);
    
        Funcionario funcionario = new Funcionario(nome,numero);
        this.listFuncionarios.add(funcionario);
        return funcionario;
    }


    //Métodos - Filmes
    public Filme cadastrarFilme(String nome, String ano, String[] trilha) throws FilmeExistente {
        verificarExistenciaFilme(nome);
        Filme filme = new Filme(nome,ano,trilha);
        this.listFilmes.add(filme);
        return filme;
    }

    public PapelInterface cadastrarPapelNoFilme(Filme filme, Papeis papel, String nomeFuncionario) throws PapelNaoEncontrado, FuncionarioNaoEncontrado {

        if(papel == null) {
            throw new PapelNaoEncontrado("Papel não informado");
        }

        PapelInterface papeisFuncao;
        Funcionario funcionario;

        funcionario = buscarFuncionario(nomeFuncionario);

        //Switch case com os papeis do filme
        papeisFuncao = switch (papel) {
            case ATOR -> new Ator();
            case ROTEIRISTA -> new Roteirista();
            case DIRETOR -> new Diretor();
            case CINEGRAFISTA -> new Cinegrafista();
            case CAMERA -> new Camera();
        };

        funcionario.adicionarPapel(papeisFuncao, filme);
        filme.addEnvolvido(papeisFuncao, funcionario);

        return papeisFuncao;
    }

    public void cadastrarEnvolvidos(String nomeFilme, Papeis[] papeis, String[] envolvidos) throws TamanhoIncompativel, FilmeNaoEncontrado, PapelNaoEncontrado, FuncionarioNaoEncontrado {

        if(papeis.length != envolvidos.length)
            throw new TamanhoIncompativel("Papeis e envolvidos são de tamanhos diferentes");

        Filme filmeAtual;
        filmeAtual = buscarFilme(nomeFilme);

        for(int i = 0; i < envolvidos.length; i++){
            cadastrarPapelNoFilme(filmeAtual, papeis[i], envolvidos[i]);
        }
    }

    public void exibirFilmografia(String nomeFuncionario) throws FuncionarioNaoEncontrado {

        Funcionario funcionario;
        funcionario = buscarFuncionario(nomeFuncionario);

        System.out.println("Filmografia de "+nomeFuncionario+":");

        for(FilmePapel filmografia : funcionario.getPapeis()){
            System.out.println("Filme: "+filmografia.getFilme()+" | Função: "+filmografia.getPapel().toString());
        }
    }

    public void exibirDadosFilme(String filme) throws FilmeNaoEncontrado {

        Filme filmeDesejado;
        filmeDesejado = buscarFilme(filme);

        System.out.println("Dados do filme "+filmeDesejado.getNome()+":");
        System.out.println("Ano de Lançamento: "+filmeDesejado.getAno()+"\n");
        System.out.println("Trilha Sonora: ");
        for(String trilha : filmeDesejado.getTrilhaSonora())
            System.out.println(trilha);
        System.out.println();
        for(PapelFuncionario envolvido : filmeDesejado.getEnvolvidos())
            System.out.println(envolvido.getPapel().toString()+": "+envolvido.getFuncionario());
        System.out.println();
    }
    
    // Métodos de Busca (Funcionario, Filme)
    public Funcionario buscarFuncionario(String nomeDoFuncionario) throws FuncionarioNaoEncontrado {
        for(Funcionario funcionario : listFuncionarios){
            if(funcionario.getNome().equals(nomeDoFuncionario))
                return funcionario;
        }
        throw new FuncionarioNaoEncontrado("Funcionario não encontrado.("+nomeDoFuncionario+")");
    }

    public Filme buscarFilme(String nomeDoFilme) throws FilmeNaoEncontrado {
        for(Filme filme : listFilmes){
            if(filme.getNome().equals(nomeDoFilme))
                return filme;
        }
        throw new FilmeNaoEncontrado("Filme não encontrado");
    }


    // Métodos de verificação (Funcionario, filme)
    private  Boolean verificarExistenciaFuncionario(String nomeDoFuncionario) throws FuncionarioExistente {

        for (Funcionario funcionario : listFuncionarios) {
            if (funcionario.getNome().equals(nomeDoFuncionario)){
                throw new FuncionarioExistente("Já existe um funcionário cadastrado com este nome.("+nomeDoFuncionario+")");
            }
        }
        return false;
    }

    private Boolean verificarExistenciaFilme(String nomeDoFilme) throws FilmeExistente {

        for (Filme filme : listFilmes) {
            if (filme.getNome().equals(nomeDoFilme)){
                throw new FilmeExistente("Já existe um filme cadastrado com esse nome.");
            }
        }
        return false;
    }
}