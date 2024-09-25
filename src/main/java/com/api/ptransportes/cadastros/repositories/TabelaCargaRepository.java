package com.api.ptransportes.cadastros.repositories;

import com.api.ptransportes.cadastros.models.TabelaCargaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TabelaCargaRepository extends JpaRepository<TabelaCargaModel, Long> {
    TabelaCargaModel findByTipo(String tipo);
    public List<TabelaCargaModel> findAllByOrderByIdAsc();
}
