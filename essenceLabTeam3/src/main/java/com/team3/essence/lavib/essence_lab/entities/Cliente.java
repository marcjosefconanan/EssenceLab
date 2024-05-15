package com.team3.essence.lavib.essence_lab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team3.essence.lavib.essence_lab.Enum.RecordStatusEnum;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Table
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false)
    private String genere;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String codiceFiscale;
    @Column(nullable = false)
    private Integer eta;
    @Column(nullable = false)
    private String indirizzo;
    @Enumerated(EnumType.STRING)
    @Column(name = "record_status", nullable = false, length = 1)
    @JsonIgnore
    private RecordStatusEnum recordStatusEnum = RecordStatusEnum.A;
    @ManyToOne
    @JoinColumn(name = "carrello_id")
    private Carrello carrello;
    public Cliente(){}

    public Cliente(Long id, String nome_cliente, String cognome_cliente, String genere_cliente, String email_cliente, String codiceFiscale_cliente, Integer eta_cliente, String indirizzo_cliente, RecordStatusEnum recordStatusEnum, Carrello carrello) {
        this.id = id;
        this.nome = nome_cliente;
        this.cognome = cognome_cliente;
        this.genere = genere_cliente;
        this.email = email_cliente;
        this.codiceFiscale = codiceFiscale_cliente;
        this.eta = eta_cliente;
        this.indirizzo = indirizzo_cliente;
        this.recordStatusEnum = recordStatusEnum;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public RecordStatusEnum getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(RecordStatusEnum recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }
}
