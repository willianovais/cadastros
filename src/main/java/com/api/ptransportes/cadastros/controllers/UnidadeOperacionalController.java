package com.api.ptransportes.cadastros.controllers;

import com.api.ptransportes.cadastros.dtos.UnidadeOperacionalRecord;
import com.api.ptransportes.cadastros.models.UnidadeOperacionalModel;
import com.api.ptransportes.cadastros.repositories.UnidadeOperacionalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class UnidadeOperacionalController {

    @Autowired
    UnidadeOperacionalRepository unidadeOperacionalRepository;

    @PostMapping("/api/ptransportes/cadastro/uo/novo")
    public ResponseEntity<UnidadeOperacionalModel> saveUo(@RequestBody @Valid UnidadeOperacionalRecord unidadeOperacionalRecord){
        var unidadeOperacionalModel = new UnidadeOperacionalModel();
        BeanUtils.copyProperties(unidadeOperacionalRecord, unidadeOperacionalModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadeOperacionalRepository.save(unidadeOperacionalModel));
    }

    @GetMapping("/api/ptransportes/cadastro/uo/consulta")
    public ResponseEntity<List<UnidadeOperacionalModel>> getAllUo(){
        return ResponseEntity.status(HttpStatus.OK).body(unidadeOperacionalRepository.findAll());
    }

    @GetMapping("/api/ptransportes/cadastro/uo/consulta/regiao/{regiao}")
    public ResponseEntity<List<UnidadeOperacionalModel>> getRegiaoUo(@PathVariable(value = "regiao") String regiao){
        return ResponseEntity.status(HttpStatus.OK).body(unidadeOperacionalRepository.findByRegiaoContainingIgnoreCase(regiao));
    }
    @GetMapping("/api/ptransportes/cadastro/uo/consulta/estado/{uf}")
    public ResponseEntity<List<UnidadeOperacionalModel>> getEstadoUo(@PathVariable(value = "uf") String uf) {
        return ResponseEntity.status(HttpStatus.OK).body(unidadeOperacionalRepository.findByUfContainingIgnoreCase(uf));
    }

    @GetMapping("/api/ptransportes/cadastro/uo/consulta/cidade/{cidade}")
    public ResponseEntity<Object> getCidadeUo(@PathVariable(value = "cidade") String cidade) {
        Optional<UnidadeOperacionalModel> id0 = Optional.ofNullable(unidadeOperacionalRepository.findByCidadeContainingIgnoreCase(cidade));
        if (id0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Regiao Nao Encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(id0.get());
    }

    @PutMapping("/api/ptransportes/cadastro/uo/atualizacao/{id}")
    public ResponseEntity<Object> atualizaUo(@PathVariable(value = "id") Long id, @RequestBody @Valid UnidadeOperacionalRecord unidadeOperacionalRecord){
        Optional<UnidadeOperacionalModel> id0 = unidadeOperacionalRepository.findById(id);
        if (id0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UO Nao encontrada!");
        }
        var unidadeOperacionalModel = id0.get();
        BeanUtils.copyProperties(unidadeOperacionalRecord, unidadeOperacionalModel);
        return ResponseEntity.status(HttpStatus.OK).body(unidadeOperacionalRepository.save(unidadeOperacionalModel));
    }

    @DeleteMapping("/api/ptransportes/cadastro/uo/exclui/{id}")
    public ResponseEntity<Object> deleteUo(@PathVariable(value = "id") Long id) {
        Optional<UnidadeOperacionalModel> id0 = unidadeOperacionalRepository.findById(id);
        if (id0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UO Nao encontrada!");
        }
        unidadeOperacionalRepository.delete(id0.get());
        return ResponseEntity.status(HttpStatus.OK).body("UO Excluida!");
    }
}
