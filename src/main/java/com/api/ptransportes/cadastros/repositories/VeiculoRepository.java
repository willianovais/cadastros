package com.api.ptransportes.cadastros.repositories;

import com.api.ptransportes.cadastros.models.UnidadeOperacionalModel;
import com.api.ptransportes.cadastros.models.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, String> {
    List<VeiculoModel> findByIduo(Optional<UnidadeOperacionalModel> iduo);
    List<VeiculoModel> findByTipo(String tipo);
}
