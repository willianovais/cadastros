package com.api.ptransportes.cadastros.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "T_VEICULO")
public class VeiculoModel {

    @Id
    @Column(name = "placa", length = 7, nullable = false, unique = true)
    private String placa;

    @Column(name = "marca", length = 30, nullable = false)
    private  String marca;

    @Column(name = "modelo", length = 30, nullable = false)
    private String modelo;

    @Column(name = "ano", length = 4, nullable = false)
    private String ano;

    @Column(name = "kms", nullable = false, length = 12)
    private BigDecimal kms;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "uo")
    private UnidadeOperacionalModel iduo;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public BigDecimal getKms() {
        return kms;
    }

    public void setKms(BigDecimal kms) {
        this.kms = kms;
    }

    public UnidadeOperacionalModel getIduo() {
        return iduo;
    }

    public void setIduo(UnidadeOperacionalModel iduo) {
        this.iduo = iduo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
