package com.team3.essence.lavib.essence_lab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.List;


@Entity
public class Carrello {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double prezzoTotale;
    @Enumerated(EnumType.STRING)
    @Column(name = "record_status", nullable = false, length = 1)
    @JsonIgnore
    private RecordStatusEnum recordStatusEnum = RecordStatusEnum.A;
    @OneToMany(mappedBy = "carrello")
    @JsonIgnore
    private List<Profumo> profumi;
    @OneToMany(mappedBy = "carrello")
    @JsonIgnore
    private List<Cliente> clienti;
    public Carrello(){}

    public Carrello(Long id, Double prezzoTotale, List<Profumo> profumi, List<Cliente> clienti, RecordStatusEnum recordStatusEnum) {
        this.id = id;
        this.prezzoTotale = prezzoTotale;
        this.profumi = profumi;
        this.clienti = clienti;
        this.recordStatusEnum = recordStatusEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(Double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public List<Profumo> getProfumi() {
        return profumi;
    }

    public void setProfumi(List<Profumo> profumi) {
        this.profumi = profumi;
    }

    public List<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }
}
