package com.PapeisPackage;

import com.Interface.PapelInterface;

public class Cinegrafista implements PapelInterface {
    @Override
    public String papelAtribuido() {
        return "Montar o Cenário";
    }

    public String toString(){
        return "Cinegrafista do filme";
    }
}
