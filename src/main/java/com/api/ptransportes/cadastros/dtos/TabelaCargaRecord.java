package com.api.ptransportes.cadastros.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TabelaCargaRecord(@NotBlank String tipo, @NotNull BigDecimal valor) {
}
