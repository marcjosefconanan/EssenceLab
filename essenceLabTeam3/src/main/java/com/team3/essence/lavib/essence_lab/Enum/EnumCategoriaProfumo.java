package com.team3.essence.lavib.essence_lab.Enum;

public enum EnumCategoriaProfumo {
    EAU_DE_TOILETTE("Eau de toilette"),
    EAU_DE_PARFUM("Eau de parfum"),
    EAU_DE_COLOGNE("Eau de cologne");
    private String tipoCatalogo;

    EnumCategoriaProfumo(String tipoCatalogo) {
        this.tipoCatalogo = tipoCatalogo;
    }
}
