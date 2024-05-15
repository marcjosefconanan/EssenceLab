package com.team3.essence.lavib.essence_lab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team3.essence.lavib.essence_lab.Enum.EnumTipoEssenza;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Table
@Entity
public class Essenza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String allergeni;
    @Column(nullable = false)
    private String descrizione;
    @Column(nullable = false)
    private Double prezzo;
    @Column(nullable = false)
    private String ingredienti;
    @ManyToOne
    @JoinColumn(name = "profumo_id")
    private Profumo profumo;
    @Enumerated(EnumType.STRING)
    @Column(name = "record_status", nullable = false, length = 1)
    @JsonIgnore
    private RecordStatusEnum recordStatusEnum = RecordStatusEnum.A;
    @Enumerated(EnumType.STRING)
    private EnumTipoEssenza enumTipoEssenza;

    public Essenza() {
    }

    public Essenza(Long id, String nome_essenza, String allergeni_essenza, String descrizione_essenza, Double prezzo_essenza, String ingredienti_essenza, Profumo profumo, RecordStatusEnum recordStatusEnum, EnumTipoEssenza enumTipoEssenza) {
        this.id = id;
        this.nome = nome_essenza;
        this.allergeni = allergeni_essenza;
        this.descrizione = descrizione_essenza;
        this.prezzo = prezzo_essenza;
        this.ingredienti = ingredienti_essenza;
        this.profumo = profumo;
        this.recordStatusEnum = recordStatusEnum;
        this.enumTipoEssenza = enumTipoEssenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAllergeni() {
        return allergeni;
    }

    public void setAllergeni(String allergeni) {
        this.allergeni = allergeni;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public Profumo getProfumo() {
        return profumo;
    }

    public void setProfumo(Profumo profumo) {
        this.profumo = profumo;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }

    public EnumTipoEssenza getEnumTipoEssenza() {
        return enumTipoEssenza;
    }

    public void setEnumTipoEssenza(EnumTipoEssenza enumTipoEssenza) {
        this.enumTipoEssenza = enumTipoEssenza;
    }
}