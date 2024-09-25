package com.api.ptransportes.cadastros.repositories;

import com.api.ptransportes.cadastros.models.MotoristaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaReposotory extends JpaRepository<MotoristaModel, Long> {
    MotoristaModel findByCpf(String cpf);
}
