package com.api.ptransportes.cadastros.controllers;

import ch.qos.logback.classic.Logger;
import com.api.ptransportes.cadastros.dtos.VeiculoRecord;
import com.api.ptransportes.cadastros.models.UnidadeOperacionalModel;
import com.api.ptransportes.cadastros.models.VeiculoModel;
import com.api.ptransportes.cadastros.repositories.UnidadeOperacionalRepository;
import com.api.ptransportes.cadastros.repositories.VeiculoRepository;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class VeiculoController {

    @Autowired
    VeiculoRepository veiculoRepository;
    @Autowired
    UnidadeOperacionalRepository unidadeOperacionalRepository;

    @PostMapping("/api/ptransportes/cadastro/veiculo/novo")
    public ResponseEntity<VeiculoModel> saveVeiculo(@RequestBody @Valid VeiculoRecord veiculoRecord){
        var veiculoModel = new VeiculoModel();
        BeanUtils.copyProperties(veiculoRecord, veiculoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoRepository.save(veiculoModel));
    }

    @GetMapping("/api/ptransportes/cadastro/veiculo/consulta/placa/{placa}")
    public ResponseEntity<Object> getOneVeiculo(@PathVariable(value = "placa") String placa){
        Optional<VeiculoModel> placa0 = veiculoRepository.findById(placa);
        if(placa0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(placa0);
    }

    @GetMapping("/api/ptransportes/cadastro/veiculo/consulta/uo/{iduo}")
    public ResponseEntity<Object> getVeiculoUo(@PathVariable(value = "iduo") Long id, UnidadeOperacionalModel iduo){
        Optional<UnidadeOperacionalModel> id0 = unidadeOperacionalRepository.findById(id);
        if(id0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UO Nao Encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.findByIduo(id0));
    }

    @GetMapping("/api/ptransportes/cadastro/veiculo/consulta/tipo/{tipo}")
    public ResponseEntity<List<VeiculoModel>> getVeiculoTipo(@PathVariable(value = "tipo") String tipo){
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.findByTipo(tipo));
    }

    @PutMapping("/api/ptransportes/cadastro/veiculo/atualizacao/{placa}")
    public ResponseEntity<Object> updateVeiculo(@PathVariable(value = "placa") String placa, @RequestBody @Valid VeiculoRecord veiculoRecord){
        Optional<VeiculoModel> placa0 = veiculoRepository.findById(placa);
        if (placa0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo nao encontrado!");
        }
        var veiculoModel = placa0.get();
        BeanUtils.copyProperties(veiculoRecord, veiculoModel);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.save(veiculoModel));
    }

    @DeleteMapping("/api/ptransportes/cadastro/veiculo/exclui/{placa}")
    public ResponseEntity<Object> deleteVeiculo(@PathVariable(value = "placa") String placa){
        Optional<VeiculoModel> placa0 = veiculoRepository.findById(placa);
        if (placa0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo nao encontrado!");
        }
        veiculoRepository.delete(placa0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cadastro do veiculo excluido!");
    }
}
