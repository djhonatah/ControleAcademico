package com.Excecoes;

public class FilmeNaoEncontrado extends Exception{
    public FilmeNaoEncontrado(String mensagem){
        super(mensagem);
    }
}