package com.team3.essence.lavib.essence_lab.Enum;

public enum EnumMarcaProfumo {
    PERSONALIZZATO("Profumo personalizzato"),
    ACQUA_DI_PARMA("Acqua di Parma"),
    AMOUAGE("Amouage"),
    ANTIQUA_FIRENZE("Antiqua Firenze"),
    BARUTI("Baruti"),
    BOIS_1920("Bois 1920"),
    BOUCHERON("Boucheron"),
    BULGARI("Bulgari"),
    BURBERRY("Burberry"),
    CALVIN_KLEIN("Calvin Klein"),
    CHANEL("Chanel"),
    CHLOE("Chloé"),
    CHRISTIAN_DIOR("Christian Dior"),
    COLLISTAR("Collistar"),
    COSTUME_NATIONAL("CoSTUME NATIONAL"),
    DAVIDOFF("Davidoff"),
    DIPTYQUE("Diptyque"),
    DOLCE_E_GABBANA("Dolce & Gabbana"),
    ESTEE_LAUDER("Estee Lauder"),
    ETRO("Etro"),
    FRANCESCA_BIANCHI("Francesca Bianchi"),
    GIANFRANCO_FERRE("Gianfranco Ferre"),
    GIORGIO_ARMANI("Giorgio Armani"),
    GIVENCHY("Givenchy"),
    GUCCI("Gucci"),
    GUERLAIN("Guerlain"),
    HERMES("Hermes"),
    HUGO_BOSS("Hugo Boss"),
    ISSEY_MIYAKE("Issey Miyake"),
    JEAN_PAUL_GAULTIER("Jean Paul Gaultier"),
    JIMMY_CHOO("Jimmy Choo"),
    JOOP("JOOP"),
    KENZO("Kenzo"),
    L_ARTISAN_PARFUMEUR("L’Artisan Parfumeur"),
    LABORATORIO_OLFATTIVO("Laboratorio Olfattivo"),
    LANCOME("Lancome"),
    LAURA_BIAGIOTTI("Laura Biagiotti"),
    LORENZO_VILLORESI("Lorenzo Villoresi"),
    MARIA_CANDIDA_GENTILE("Maria Candida Gentile"),
    MEO_FUSCIUNI("Meo Fusciuni"),
    MUGLER("Mugler"),
    NARCISO_RODRIGUEZ("Narciso Rodriguez"),
    NASOMATTO("Nasomatto"),
    NISHANE("Nishane"),
    PACO_RABANNE("Paco Rabanne"),
    PRADA("Prada"),
    ROBERTO_CAVALLI("Roberto Cavalli"),
    SIMONE_ANDREOLI("Simone Andreoli"),
    TAUER("Tauer"),
    TOM_FORD("Tom Ford"),
    TRUSSARDI("Trussardi"),
    VALENTINO("Valentino"),
    VERSACE("Versace"),
    YVES_SAINT_LAURENT("Yves Saint Laurent"),
    ZADIG_E_VOLTAIRE("Zadig & Voltaire");
    private String marca;

    EnumMarcaProfumo(String marca) {
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }
}
