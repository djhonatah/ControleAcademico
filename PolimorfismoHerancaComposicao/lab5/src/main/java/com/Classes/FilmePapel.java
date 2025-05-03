package com.Classes;

import com.Interface.PapelInterface;

public class FilmePapel {
    private String filme;
    private PapelInterface papel;

    public FilmePapel(String filme, PapelInterface papel){
        this.filme = filme;
        this.papel = papel;
    }

    public FilmePapel(String filme) {
        this.filme = filme;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public PapelInterface getPapel() {
        return papel;
    }

    public void setPapel(PapelInterface papel) {
        this.papel = papel;
    }
}