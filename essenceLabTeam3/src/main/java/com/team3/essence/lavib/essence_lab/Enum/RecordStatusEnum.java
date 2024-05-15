package com.team3.essence.lavib.essence_lab.Enum;

public enum RecordStatusEnum {
    A("Attivo"),
    I("Inattivo");

    private String descrzione;

    RecordStatusEnum(String descrzione) {
        this.descrzione = descrzione;
    }

    public String getDescrzione() {
        return descrzione;
    }
}