package br.com.desafio2.ilab.group5.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.desafio2.ilab.group5.security.Token;
import br.com.desafio2.ilab.group5.service.IAdministratorService;
import br.com.desafio2.ilab.group5.dto.AdministratorLoginDTO;
import br.com.desafio2.ilab.group5.model.KafkaService;


@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private IAdministratorService service;

	@PostMapping("/login")
	public ResponseEntity<?> realizarLogin(@RequestBody AdministratorLoginDTO dadosLogin) throws InterruptedException, ExecutionException {
		Token token = service.gerarTokenAdministrador(dadosLogin);

		if (token != null) {
			KafkaService.sendMessage("Token", token.toString());
			return ResponseEntity.ok(token);
		}
			KafkaService.sendMessage("Token", "Token invalido");
			return ResponseEntity.status(401).body("Acesso Negado");

	}
}
