package com.api.ptransportes.cadastros;

import com.api.ptransportes.cadastros.models.ClienteModel;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class CadastrosApplication {
	@PostConstruct
	void starter() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

	public static void main(String[] args) {
		SpringApplication.run(CadastrosApplication.class, args);

	}
}

