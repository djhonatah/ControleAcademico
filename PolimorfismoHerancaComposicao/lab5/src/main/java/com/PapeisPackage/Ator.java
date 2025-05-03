package com.PapeisPackage;

import com.Interface.PapelInterface;

public class Ator implements PapelInterface {
    
    @Override
    public String papelAtribuido() {
        return "Atuar no filme";
    }

    public String toString(){
        return "Ator no Filme";
    }
}