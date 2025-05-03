package com.Excecoes;

public class FilmeExistente extends Exception{
    public FilmeExistente(String mensagem) {
        super(mensagem);
    }
}