package com.api.ptransportes.cadastros.controllers;

import com.api.ptransportes.cadastros.dtos.TabelaCargaRecord;
import com.api.ptransportes.cadastros.models.TabelaCargaModel;
import com.api.ptransportes.cadastros.repositories.TabelaCargaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TabelaCargaController {

    @Autowired
    TabelaCargaRepository tabelaCargaRepository;

    @PostMapping("/api/ptransportes/cadastro/carga/novo")
    public ResponseEntity<TabelaCargaModel> saveCarga(@RequestBody @Valid TabelaCargaRecord tabelaCargaRecord){
        var tabelaCargaModel = new TabelaCargaModel();
        BeanUtils.copyProperties(tabelaCargaRecord, tabelaCargaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(tabelaCargaRepository.save(tabelaCargaModel));
    }

    @GetMapping("/api/ptransportes/cadastro/carga/consulta")
    public ResponseEntity<List<TabelaCargaModel>> getAllTabela(){
        return ResponseEntity.status(HttpStatus.OK).body(tabelaCargaRepository.findAllByOrderByIdAsc());
    }

    @PutMapping("/api/ptransportes/cadastro/carga/atualizacao/{tipo}")
    public ResponseEntity<Object> updateTabela(@PathVariable(value = "tipo") String tipo, @RequestBody @Valid TabelaCargaRecord tabelaCargaRecord){
        Optional<TabelaCargaModel> id0 = Optional.ofNullable(tabelaCargaRepository.findByTipo(tipo));
        if (id0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Carga nao encontrado!");
        }
        var tabelaCargaModel = id0.get();
        BeanUtils.copyProperties(tabelaCargaRecord, tabelaCargaModel);
        return ResponseEntity.status(HttpStatus.OK).body(tabelaCargaRepository.save(tabelaCargaModel));
    }
}
