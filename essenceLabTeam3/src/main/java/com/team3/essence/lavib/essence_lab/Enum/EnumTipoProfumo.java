package com.team3.essence.lavib.essence_lab.Enum;

public enum EnumTipoProfumo {

    PROFUMO_AGRUMATO("Profumo agrmato"),
    PROFUMO_DOLCE("Profumo dolce"),
    PROFUMO_ESOTICO("Profumo esotico"),
    PROFUMO_ORIENTALE("Profumo orientale"),
    PROFUMO_FLOREALE("Profumo floreale"),
    PROFUMO_SPEZIATO("Profumo speziato");
    private String tipoProfumo;

    EnumTipoProfumo(String tipoProfumo) {
        this.tipoProfumo = tipoProfumo;
    }
}
