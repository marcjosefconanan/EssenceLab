package com.team3.essence.lavib.essence_lab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.List;

@Table
@Entity
public class Negozio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String luogo;
    @Column(nullable = false)
    private String indirizzo;
    @Column(nullable = false, unique = true)
    private String partitaIva;
    @OneToMany(mappedBy = "negozio")
    @JsonIgnore
    private List<Profumo> profumi;
    @Enumerated(EnumType.STRING)
    @Column(name = "record_status", nullable = false, length = 1)
    @JsonIgnore
    private RecordStatusEnum recordStatusEnum =  RecordStatusEnum .A;

    public Negozio(){}

    public Negozio(Long id, String nome_negozio, String luogo_negozio, String indirizzo_negozio, String partita_iva_negozio, List<Profumo> profumi, RecordStatusEnum recordStatusEnum) {
        this.id = id;
        this.nome = nome_negozio;
        this.luogo = luogo_negozio;
        this.indirizzo = indirizzo_negozio;
        this.partitaIva = partita_iva_negozio;
        this.profumi = profumi;
        this.recordStatusEnum = recordStatusEnum;
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

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public List<Profumo> getProfumi() {
        return profumi;
    }

    public void setProfumi(List<Profumo> profumi) {
        this.profumi = profumi;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }
}
