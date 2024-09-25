package com.api.ptransportes.cadastros.dtos;

import jakarta.validation.constraints.NotBlank;

public record UnidadeOperacionalRecord(@NotBlank String regiao, @NotBlank String uf, @NotBlank String cidade) {
}
