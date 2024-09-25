package com.api.ptransportes.cadastros.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.TimeZoneColumn;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "T_MOTORISTA")
public class MotoristaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "dtnasc", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dtnasc;

    @Column(name = "cnh", length = 9, nullable = false, unique = true)
    private String cnh;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "celular", length = 11, nullable = false, unique = true)
    private String celular;

    @Column(name = "dtcontratacao", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dtcontratacao;

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

    public LocalDate getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(LocalDate dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getDtcontratacao() {
        return dtcontratacao;
    }

    public void setDtcontratacao(LocalDate dtcontratacao) {
        this.dtcontratacao = dtcontratacao;

    }
}
