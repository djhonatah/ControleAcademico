package com.Excecoes;

public class FuncionarioExistente extends Exception{
    public FuncionarioExistente(String mensagem) {
        super(mensagem);
    }
}