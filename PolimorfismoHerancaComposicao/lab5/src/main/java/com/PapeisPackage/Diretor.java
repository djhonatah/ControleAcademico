package com.PapeisPackage;

import com.Interface.PapelInterface;

public class Diretor implements PapelInterface {
    @Override
    public String papelAtribuido() {
        return "Dirigir o Filme";
    }

    public String toString(){
        return "Diretor";
    }
}