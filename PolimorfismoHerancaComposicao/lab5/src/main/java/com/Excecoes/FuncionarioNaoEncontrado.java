package com.Excecoes;

public class FuncionarioNaoEncontrado extends Exception{
    public FuncionarioNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}