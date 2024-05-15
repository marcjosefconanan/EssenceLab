package com.team3.essence.lavib.essence_lab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team3.essence.lavib.essence_lab.Enum.EnumCategoriaProfumo;
import com.team3.essence.lavib.essence_lab.Enum.EnumMarcaProfumo;
import com.team3.essence.lavib.essence_lab.Enum.EnumTipoProfumo;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Table
@Entity
public class Profumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descrizione;
    @Column(nullable = false)
    private String ingredienti;
    @Column(nullable = false)
    private Double prezzo;
    @Column(nullable = false)
    private String allergeni;
    @OneToMany(mappedBy = "profumo")
    @JsonIgnore
    private List<Essenza> essenze;
    @ManyToOne
    @JoinColumn(name = "negozio_id")
    private Negozio negozio;
    @Enumerated(EnumType.STRING)
    @Column(name = "record_status", nullable = false, length = 1)
    @JsonIgnore
    private RecordStatusEnum recordStatusEnum =  RecordStatusEnum .A;
    @Enumerated(EnumType.STRING)
    private EnumTipoProfumo enumTipoProfumo;
    @Enumerated(EnumType.STRING)
    private EnumMarcaProfumo enumMarcaProfumo;
    @Enumerated(EnumType.STRING)
    private EnumCategoriaProfumo enumCategoriaProfumo;
    @ManyToOne
    @JoinColumn(name = "carrello_id")
    private Carrello carrello;
    public Profumo(){}

    public Profumo(Long id, String nome_profumo, String descrizione_profumo, String ingredienti_profumo, Double prezzo_profumo, String allergeni_profumo, List<Essenza> essenze, Negozio negozio, RecordStatusEnum recordStatusEnum, EnumTipoProfumo enumTipoProfumo, EnumMarcaProfumo enumMarcaProfumo, EnumCategoriaProfumo enumCategoriaProfumo, Carrello carrello) {
        this.id = id;
        this.nome = nome_profumo;
        this.descrizione = descrizione_profumo;
        this.ingredienti = ingredienti_profumo;
        this.prezzo = prezzo_profumo;
        this.allergeni = allergeni_profumo;
        this.essenze = essenze;
        this.negozio = negozio;
        this.recordStatusEnum = recordStatusEnum;
        this.enumTipoProfumo = enumTipoProfumo;
        this.enumMarcaProfumo = enumMarcaProfumo;
        this.enumCategoriaProfumo = enumCategoriaProfumo;
        this.carrello = carrello;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getAllergeni() {
        return allergeni;
    }

    public void setAllergeni(String allergeni) {
        this.allergeni = allergeni;
    }

    public List<Essenza> getEssenze() {
        return essenze;
    }

    public void setEssenze(List<Essenza> essenze) {
        this.essenze = essenze;
    }

    public Negozio getNegozio() {
        return negozio;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }

    public EnumTipoProfumo getEnumTipoProfumo() {
        return enumTipoProfumo;
    }

    public void setEnumTipoProfumo(EnumTipoProfumo enumTipoProfumo) {
        this.enumTipoProfumo = enumTipoProfumo;
    }

    public EnumMarcaProfumo getEnumMarcaProfumo() {
        return enumMarcaProfumo;
    }

    public void setEnumMarcaProfumo(EnumMarcaProfumo enumMarcaProfumo) {
        this.enumMarcaProfumo = enumMarcaProfumo;
    }

    public EnumCategoriaProfumo getEnumCategoriaProfumo() {
        return enumCategoriaProfumo;
    }

    public void setEnumCategoriaProfumo(EnumCategoriaProfumo enumCategoriaProfumo) {
        this.enumCategoriaProfumo = enumCategoriaProfumo;
    }
}
