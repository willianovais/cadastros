package com.api.ptransportes.cadastros.controllers;

import com.api.ptransportes.cadastros.dtos.MotoristaRecord;
import com.api.ptransportes.cadastros.models.MotoristaModel;
import com.api.ptransportes.cadastros.repositories.MotoristaReposotory;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class MotoristaController {

    @Autowired
    MotoristaReposotory motoristaReposotory;
    @PostMapping("/api/ptransportes/cadastro/motorista/novo")
    public ResponseEntity<MotoristaModel> saveMotorista(@RequestBody @Valid MotoristaRecord motoristaRecord){
        var motoristaModel = new MotoristaModel();
        BeanUtils.copyProperties(motoristaRecord, motoristaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(motoristaReposotory.save(motoristaModel));
    }

    @GetMapping("/api/ptransportes/cadastro/motorista/consulta")
    public ResponseEntity<List<MotoristaModel>> getAllMotorista(){
        return ResponseEntity.status(HttpStatus.OK).body(motoristaReposotory.findAll());
    }

    @GetMapping("/api/ptransportes/cadastro/motorista/consulta/{cpf}")
    public ResponseEntity<Object> getOneMotorista(@PathVariable(value = "cpf") String cpf){
        Optional<MotoristaModel> id0 = Optional.ofNullable((motoristaReposotory.findByCpf(cpf)));
        if (id0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista Nao encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(id0.get());
    }

    @PutMapping("/api/ptransportes/cadastro/motorista/atualizacao/{cpf}")
    public ResponseEntity<Object> updateMotorista(@PathVariable(value = "cpf") String cpf, @RequestBody @Valid MotoristaRecord motoristaRecord){
        Optional<MotoristaModel> id0 = Optional.ofNullable((motoristaReposotory.findByCpf(cpf)));
        if (id0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista Nao encontrado!");
        }
        var motoristaModel = id0.get();
        BeanUtils.copyProperties(motoristaRecord, motoristaModel);
        return ResponseEntity.status(HttpStatus.OK).body(motoristaReposotory.save(motoristaModel));
    }

    @DeleteMapping("/api/ptransportes/cadastro/motorista/exclui/{cpf}")
    public ResponseEntity<Object> deleteMotorista(@PathVariable(value = "cpf") String cpf){
        Optional<MotoristaModel> id0 = Optional.ofNullable((motoristaReposotory.findByCpf(cpf)));
        if (id0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista Nao encontrado!");
        }
        motoristaReposotory.delete(id0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cadastro excluido");
    }
}
