package com.api.ptransportes.cadastros.repositories;

import com.api.ptransportes.cadastros.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

   ClienteModel findByCnpj(String cnpj);
   ClienteModel findByNomeContainingIgnoreCase(String nome);
}
