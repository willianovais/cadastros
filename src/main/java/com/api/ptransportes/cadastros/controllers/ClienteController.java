package com.api.ptransportes.cadastros.controllers;

import com.api.ptransportes.cadastros.models.ClienteModel;
import com.api.ptransportes.cadastros.repositories.ClienteRepository;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.Cleaner;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/api/ptransportes/cadastro/cliente/novo")
    public ResponseEntity<ClienteModel> saveCliente(@RequestBody @Valid ClienteModel clienteModel) throws Exception {

        URL url = new URL("https://viacep.com.br/ws/"+clienteModel.getCep()+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        String cep = "";
        StringBuilder jsonCep = new StringBuilder();
        System.out.println(jsonCep.toString());

        while ((cep = br.readLine()) != null) {
            jsonCep.append(cep);
        }

        ClienteModel clientaux = new Gson().fromJson(jsonCep.toString(), ClienteModel.class);

        clienteModel.setCep(clientaux.getCep());
        clienteModel.setBairro(clientaux.getBairro());
        clienteModel.setLogradouro(clientaux.getLogradouro());
        clienteModel.setLocalidade(clientaux.getLocalidade());
        clienteModel.setUf(clientaux.getUf());
        clienteModel.setDdd(clientaux.getDdd());

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }



    @GetMapping("/api/ptransportes/cadastro/cliente/consulta")
    public ResponseEntity<List<ClienteModel>> getclienteAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    @GetMapping("/api/ptransportes/cadastro/cliente/consulta/cnpj/{cnpj}")
    public ResponseEntity<Object> getClienteCnpj(@PathVariable(value = "cnpj") String cnpj){
        Optional<ClienteModel> cnpj0 = Optional.ofNullable(clienteRepository.findByCnpj(cnpj));
        if (cnpj0.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cnpj0.get());
    }
}
