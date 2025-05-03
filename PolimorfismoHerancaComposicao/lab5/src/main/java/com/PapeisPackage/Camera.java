package com.PapeisPackage;

import com.Interface.PapelInterface;

public class Camera implements PapelInterface {
    @Override
    public String papelAtribuido() {
        return "Filmar o set do filme";
    }

    public String toString(){
        return "Cameraman";
    }
}
