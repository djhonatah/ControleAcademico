package com.PapeisPackage;

import com.Interface.PapelInterface;

public class Roteirista implements PapelInterface {
    @Override
    public String papelAtribuido() {
        return "Escrever o roteiro";
    }

    public String toString(){
        return "Roteirista";
    }
}