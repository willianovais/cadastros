package com.api.ptransportes.cadastros.dtos;

import com.api.ptransportes.cadastros.models.UnidadeOperacionalModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record VeiculoRecord(@NotBlank String placa, @NotBlank String marca, @NotBlank String modelo, @NotNull String ano, @NotNull BigDecimal kms, String tipo, UnidadeOperacionalModel iduo, UnidadeOperacionalModel regiao, UnidadeOperacionalModel uf, UnidadeOperacionalModel cidade) {
}
