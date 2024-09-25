package com.api.ptransportes.cadastros.repositories;

import com.api.ptransportes.cadastros.models.UnidadeOperacionalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadeOperacionalRepository extends JpaRepository<UnidadeOperacionalModel, Long> {
    List<UnidadeOperacionalModel> findByRegiaoContainingIgnoreCase(String regiao);
    List<UnidadeOperacionalModel> findByUfContainingIgnoreCase(String uf);
    UnidadeOperacionalModel findByCidadeContainingIgnoreCase(String cidade);

}
