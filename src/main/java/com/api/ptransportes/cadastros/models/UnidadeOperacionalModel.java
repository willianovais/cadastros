package com.api.ptransportes.cadastros.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "UO")
public class UnidadeOperacionalModel implements Serializable {

    private static long serialVerionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regiao;
    private String uf;
    private String cidade;

    public static long getSerialVerionUID() {
        return serialVerionUID;
    }

    public static void setSerialVerionUID(long serialVerionUID) {
        UnidadeOperacionalModel.serialVerionUID = serialVerionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
