package com.api.ptransportes.cadastros.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public record MotoristaRecord(@NotBlank String nome, @NotNull LocalDate dtnasc, @NotNull String cnh, @NotNull String cpf, @NotNull String celular, @NotNull @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dtcontratacao) {
}
