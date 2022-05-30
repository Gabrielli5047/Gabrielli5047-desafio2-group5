package br.com.desafio2.ilab.group5.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.desafio2.ilab.group5.security.Token;
import br.com.desafio2.ilab.group5.service.IAdministradorService;
import br.com.desafio2.ilab.group5.dto.AdministradorLoginDTO;
import br.com.desafio2.ilab.group5.model.KafkaService;


@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private IAdministradorService service;

	@PostMapping("/login")
	public ResponseEntity<?> realizarLogin(@RequestBody AdministradorLoginDTO dadosLogin) throws InterruptedException, ExecutionException {
		Token token = service.gerarTokenEntregador(dadosLogin);

		if (token != null) {
			KafkaService.sendMessage("Token", token.toString());
			System.err.println("OIIIIIII");
			return ResponseEntity.ok(token);
		}
		KafkaService.sendMessage("Token", "Token invalido");
		return ResponseEntity.status(401).body("Acesso Negado");

	}
}
